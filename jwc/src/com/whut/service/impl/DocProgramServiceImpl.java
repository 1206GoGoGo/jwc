package com.whut.service.impl;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyPyjhkcxx;
import com.whut.pojo.JyZyfx;
import com.whut.pojo.SysXy;
import com.whut.pojo.SysZy;
import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.pojo.pyjhkcxxZhcxObjF;
import com.whut.pojo.pyjhkcxxZhcxObjM;
import com.whut.service.DocProgramService;
import com.whut.service.JyPyjhkcxxService;
import com.whut.service.SysXyService;
import com.whut.service.SysZyService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class DocProgramServiceImpl implements DocProgramService {
	
	@Autowired
	private BaseHibernateDAO dao;
	
	private Configuration configuration = null;
	
	public DocProgramServiceImpl() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}
		
	public void pyjhkcxxZhcxToExcel(List<pyjhkcxxZhcxObj> datas, pyjhkcxxZhcxObjM nameobj, pyjhkcxxZhcxObjF flagobj, int len, String filepath) {

		// 组织数据
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("datas", datas);
		dataMap.put("nameobj", nameobj);
		dataMap.put("flagobj", flagobj);
		dataMap.put("len", len + 100);

		// 目标文件
		String fileName = filepath.replace("\\", "/") + ".xls";
		File targetFile = new File(fileName);

		// 模板文件
		String ftlpath = this.getClass().getResource("/").toString().replace("file:/", "").replace("WEB-INF", "userfile")
				.replace("classes", "docTemplate");
		
		String path = this.getClass().getClassLoader().getResource("").getPath();

		generatFile(dataMap, ftlpath, "PyjhkcxxZhcx.ftl", targetFile);
	}

	
	public void generatFile(Map<String, Object> dataMap, String ftlPath, String ftlFile, File targetFile) {
		configuration.setClassForTemplateLoading(this.getClass(), "/");
		try {
			this.configuration.setDirectoryForTemplateLoading(new File(ftlPath));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		Template t = null;
		try {
			t = configuration.getTemplate(ftlFile);
			t.setEncoding("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile), "UTF-8"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			t.setEncoding("UTF-8");
			t.process(dataMap, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 教学计划批量打印：pldyExport（）
	 * 
	 * 打印培养计划课程信息表中”教学计划号“数组”jxjhhArray“中的 and
	 * ”开课学期“为”xq“的课程，并按”排序方式pxfs“导出到excel文件中
	 * 
	 * @author Administrator
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void pldyExport(String[] jxjhhArray, String xq, String pxfs, String filepath) {
		// 路径
		String fileName = filepath.replace("\\", "/");
		for (int i = 0; i < jxjhhArray.length; i++) {
			// 获取数据
			Map<String, Object> dataMap = new HashMap<String, Object>();
			SysXyService sysXyService = new SysXyServiceImpl();
			SysXy xy = sysXyService.getXyById(jxjhhArray[i].substring(4, 7)); // 学院
			SysZyService sysZyService = new SysZyServiceImpl();
			SysZy zy = sysZyService.getZyByzydm(jxjhhArray[i].substring(4, 8)); // 专业
			String xn = jxjhhArray[i].substring(0, 4); // 级
			String xueqi = ""; // 学期
			if (xq.equals("0")) {
				xueqi = "第一至第十学期";
			} else {
				xueqi = "第" + xq + "学期";
			}
			String biaoti = xn + "级" + zy.getZymc() + "专业" + xueqi;
			dataMap.put("biaoti", biaoti); // biaoti:String
			dataMap.put("title", xy.getXymc().substring(0, 2)); // title:String
			JyPyjhkcxxService jyPyjhkcxxService = new JyPyjhkcxxServiceImpl();
			List<JyPyjhkcxx> tsbxkcxx2List;
			tsbxkcxx2List = jyPyjhkcxxService.getPyjhkcxxFrompldyExport(jxjhhArray[i], xq, pxfs);
			String hql = "from JyZyfx as n where n.zt=1";
			List<JyZyfx> zyfxList = dao.search(hql);
			Iterator<JyZyfx> it = zyfxList.iterator();
			HashMap<String, JyZyfx> map = new HashMap<String, JyZyfx>();
			while (it.hasNext()) {
				JyZyfx aa = it.next();
				map.put(aa.getZyfxdm(), aa);
			}
			String hql1 = "from SysXy as n where n.zt=1";
			List<SysXy> XyList = dao.search(hql1);
			Iterator<SysXy> it1 = XyList.iterator();
			Map map1 = new HashMap();
			while (it1.hasNext()) {
				SysXy bb = it1.next();
				map1.put(bb.getXydm(), bb);
			}
			double zxs = 0;
			double zxf = 0;
			int kk = 0;
			int len = tsbxkcxx2List.size();
			while (kk < len) {
				JyPyjhkcxx kcxx = tsbxkcxx2List.get(kk);
				if (kcxx.getZyfxdm() != null) {
					JyZyfx zyfx = map.get(kcxx.getZyfxdm());
					kcxx.setZyfxdm(zyfx.getZyfxzwmc());
				} else
					kcxx.setZyfxdm("无");
				SysXy sysXy = (SysXy) map1.get(kcxx.getSysKc().getXydm());
				kcxx.setJxjhh(sysXy.getXymc());

				kcxx.setId(kk + 1);
				zxs = zxs + kcxx.getSysKc().getZhxs();
				zxf = zxf + Double.parseDouble(kcxx.getSysKc().getXf());
				kk++;
			}
			dataMap.put("zxs", zxs); // zxs:String
			dataMap.put("zxf", zxf); // zxf:String
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);
			dataMap.put("date", dateString);
			dataMap.put("tsbxkcxx2List", tsbxkcxx2List);
			// 模板路径
			String path = this.getClass().getResource("/").toString().replace("file:/", "").replace("WEB-INF", "userfile")
					.replace("classes", "docTemplate");
			// 目标文件
			File targetFile = new File(fileName + "/" + biaoti + "培养计划.xls");
			// 生成文件
			generatFile(dataMap, path, "excel.ftl", targetFile);
		}
	}


}
