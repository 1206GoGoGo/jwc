package com.whut.service.impl;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;



import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.pojo.pyjhkcxxZhcxObjF;
import com.whut.pojo.pyjhkcxxZhcxObjM;
import com.whut.service.DocProgramService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class DocProgramServiceImpl implements DocProgramService {
	
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


}
