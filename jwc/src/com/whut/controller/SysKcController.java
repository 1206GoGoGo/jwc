package com.whut.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyPyjhkcxx;
import com.whut.pojo.JyTsxxpy;
import com.whut.pojo.SysKc;
import com.whut.pojo.SysXy;
import com.whut.service.JyPyjhkcxxService;
import com.whut.service.JyTsxxpyService;
import com.whut.service.SysKcService;
import com.whut.service.SysXyService;


@RequestMapping(value="/SysKc")
@Controller
public class SysKcController {
	
	@Autowired
	private SysKcService sysKcService;

	@Autowired
	private SysXyService sysXyService; //学院
	@Autowired
	private JyPyjhkcxxService jyPyjhkcxxService; //培养计划课程
	@Autowired
	private JyTsxxpyService jyTsxxpyService;  //通识选修培养

	/**
	 * 添加课程
	 * @param sysKc 待添加的课程对象
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addKecheng(@RequestBody SysKc sysKc) {
		sysKcService.addKecheng(sysKc);
		return "AddSuccess";
	}

	/**
	 * 获取全部课程信息
	 * @return 课程列表
	 */
	@RequestMapping(value="/getAll")
	public @ResponseBody List<SysKc> getAllList() {
		return sysKcService.getAll();
	}

	/**
	 * 修改课程信息
	 * @param sysKc 课程对象
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modify(@RequestBody SysKc sysKc) {
		sysKcService.modifyKecheng(sysKc);
		return "UpdateSuccess";
	}

	/**
	 * 删除课程(逻辑删除)
	 * @param id
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteKc(String id) {
		SysKc sysKc = sysKcService.getKechengById(id);
		sysKc.setZt(0);
		sysKcService.modifyKecheng(sysKc);
		return "DeletlSuccess";
	}

	/**
	 * 通过指定id获取课程信息
	 * @param id 课程代码
	 * @return 课程对象
	 */
	@RequestMapping(value="/getKcById", method = RequestMethod.GET)
	public @ResponseBody SysKc getKcById(String kcdm) {
		SysKc sysKc = sysKcService.getKechengById(kcdm);
		return sysKc;
	}
	
	//heyuqi 2016.6.8 专业培养计划管理和通识选修管理新增课程时只显示sfqy=1的课程
	public SysKc getKcByIdAndSfqy(String id) {//
		SysKc o = sysKcService.getKechengByIdAndSfqy(id);
		return o;
	}
	

	//停开指定id的课程 
	public void stopKc(String id) {
		SysKc sysKc = sysKcService.getKechengById(id);
		// System.out.println("!!!!!!!!!"+sysKc.getKczwmc()+"**************");
		sysKc.setZt(2); //设置课程状态
		sysKcService.modifyKecheng(sysKc);
	}

	public List<SysKc> getKcListbyXy(String xydm, String kclbdm) {
		return sysKcService.getKcListbyXy(xydm, kclbdm);
	}

	public List<SysKc> searchKcList(String xydm, String kclbdm, int zt) {
		return sysKcService.searchKcList(xydm, kclbdm, zt);
	}

	public List<SysKc> getAllListByKclb(String kclbdm) {

		return sysKcService.getAllListByKclb(kclbdm);
	}

	public String recommend(String xdm) {
		return sysKcService.recommend(xdm);
	}

	/**
	 * 通过学院代码或系代码获取按照规则生成的课程代码
	 * @param flag  标识是学院代码还是系代码
	 * @param dm 代码
	 * @return 按照规则生成课程代码前七位数
	 */
	@RequestMapping(value="/recommendBydm", method = RequestMethod.GET)
	public @ResponseBody String recommendBydm(String flag, String dm) {
		return sysKcService.recommendBydm(flag, dm);
	}

	public List<SysKc> getInitKcList(String kcxz) {
		List<SysKc> list = sysKcService.getInitKcList(kcxz);
		return list;
	}

	/**
	 * 按条件字段cd模糊查询text
	 * @param cb 查询字段   1.按课程中文名称   2.系代码   3.课程代码   4.课程类别名称
	 * @param text 查询条件
	 * @return 课程列表
	 */
	@RequestMapping(value="/getMHKcList", method = RequestMethod.GET)
	public @ResponseBody List<SysKc> getMHKcList(int cb, String text) {
		List<SysKc> list = sysKcService.getMHKcList(cb, text);
		return list;
	}
	//heyuqi 2016.06.15培养计划通过课程名称模糊查询新增课程sfqy='1'
	public List<SysKc> getByKcmcAndSfqy(String kczwmc){
		List<SysKc> List = sysKcService.getByKcmcAndSfqy(kczwmc);
		return List;
	}

	public List<SysKc> getInitZypyKc(String kclbdm, List kclist) {
		List<SysKc> rlist = kclist;
		List<SysKc> llist = sysKcService.getAllListByKclb(kclbdm);
		if (rlist != null) {
			llist.removeAll(rlist);
		}
		return llist;
	}

	public SysKc getTsKcById(String id) {
		SysKc kctemp = sysKcService.getKechengById(id);
		String xydm = kctemp.getXydm();

		if (sysXyService.getXyById(xydm) == null) {
			kctemp.setKcyl1("无");
		} else {
			SysXy xytemp = sysXyService.getXyById(kctemp.getXydm());
			kctemp.setKcyl1(xytemp.getXymc());
		}
		return kctemp;
	}

	public List<SysKc> get10SysKc() {
		List<SysKc> list = sysKcService.get10SysKc();
		return list;
	}

	/**
	 * 修改/查看课程
	 * @param kcdm 课程代码
	 * @param zyObj 培养计划课程
	 * @param tsObj 通识选修培养
	 * @return 能否被修改  返回结果为null能被修改，否则不能被修改
	 */
	@SuppressWarnings("unchecked")
	public List xgcheckKc(String kcdm) {
		JyPyjhkcxx zyObj = jyPyjhkcxxService.getkcByKcdm(kcdm); //培养计划课程
		JyTsxxpy tsObj = jyTsxxpyService.getkcByKcdm(kcdm);   //通识选修培养
		List results = new ArrayList();
		String pyjhdm = new String();
		if (zyObj == null && tsObj == null) {
			return null;
		}
		if (zyObj != null) {
			pyjhdm = zyObj.getJxjhh();
			results.add(pyjhdm);
		}
		if (tsObj != null) {
			pyjhdm = tsObj.getTsxxpydm();
			results.add(pyjhdm);
		}
		return results;
	}

	/**
	 * 查看能否删除指定课程代码的课程
	 * @param kcdm 课程代码
	 * @return 能否被删除  返回结果为null能被删除，否则不能被删除
	 */
	@SuppressWarnings("rawtypes")
	public List chackKc(String kcdm) {
		JyPyjhkcxx zyObj = jyPyjhkcxxService.getkcByKcdm(kcdm);  //培养计划课程信息
		JyTsxxpy tsObj = jyTsxxpyService.getkcByKcdm(kcdm);      //通识选修培养
		List results = new ArrayList();
		String pyjhdm = new String();
		if (zyObj == null && tsObj == null) {
			SysKc sysKc = sysKcService.getKechengById(kcdm);
			// sysKcService.del(sysKc);
			sysKc.setZt(0); //更改课程状态为0
			sysKcService.modifyKecheng(sysKc);
			return null;
		}
		if (zyObj != null) {
			pyjhdm = zyObj.getJxjhh();//教学计划号
			results.add(pyjhdm);
		}
		if (tsObj != null) {
			pyjhdm = tsObj.getTsxxpydm();//选修培养代码
			results.add(pyjhdm);
		}
		return results;
	}

	/**
	 * 拒绝课程修改
	 * @param syskc 课程对象
	 */
	@RequestMapping(value="/del", method = RequestMethod.GET)
	public @ResponseBody String del(@RequestBody SysKc syskc) {
		sysKcService.del(syskc);
		return "DelSuccess";
	}

	/**
	 * 是否已经存在指定的课程代码
	 * @param kcdm 课程代码
	 * @return 返回true(有)  false(没有)
	 */
	public boolean IfContainKcdm(String kcdm) {
		String aaa = sysKcService.IfContainKcdm(kcdm);
		if (aaa.equals("has"))
			return true;
		else
			return false;
	}

	/**
	 * 获取变更过的课程
	 * @param xydm 学院代码
	 * @param kczwmc 学院中文名称
	 * @param state 课程状态
	 * @return 返回变更过的课程列表
	 */
	@RequestMapping(value="/getKcListforbg", method = RequestMethod.GET)
	public @ResponseBody List<SysKc> getKcListforbg(String xydm, String kczwmc, int state) {
		return sysKcService.getKcListforbg(xydm, kczwmc, state);
	}

	/**
	 * 通过课程修改
	 * @param syskc 课程对象
	 */
	@RequestMapping(value="/passforkcsh", method = RequestMethod.GET)
	public @ResponseBody String passforkcsh(@RequestBody SysKc syskc) {
		sysKcService.passforkcsh(syskc);
		return "pass";
	}

	/**
	 * 查询满足条件的课程
	 * @param all hql语句
	 * @return 返回课程列表
	 */
	@RequestMapping(value="/kcSearch", method = RequestMethod.GET)
	public @ResponseBody List<SysKc> kcSearch(String all) {
		return sysKcService.kcSearch(all);
	}

	//被ExcelController.importKcjj(path) 取代  ？？？？？
	public void importKcjj(List<SysKc> kcList) {
		sysKcService.importKcjj(kcList);
	}

	/**
	 * 弃用指定课程代码的课程
	 * @param kcdm 课程代码
	 * @return 0 弃用成功    1 课程恢复正常
	 */
	@RequestMapping(value="/depKc", method = RequestMethod.GET)
	public @ResponseBody int depKc(String kcdm) {
		return sysKcService.depKc(kcdm);
	}

}
