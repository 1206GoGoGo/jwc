package com.whut.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyTsxxpy;
import com.whut.pojo.SysKc;
import com.whut.service.JyTsxxpyService;
import com.whut.service.SysKcService;

@RequestMapping(value="/JyTsxxpy")
@Controller
public class JyTsxxpyController {
	
	@Autowired
	private JyTsxxpyService jyTsxxpyService;
	
	@Autowired
	private SysKcService sysKcService;
	
	

	@RequestMapping(value="/searchxvsn1", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> searchxvsn1(String xydm, String nj) {
		List<JyTsxxpy> list = jyTsxxpyService.searchxvsn1(xydm, nj);
		return list;
	}
	
	@RequestMapping(value="/gettspykcByXyNjMc", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> gettspykcByXyNjMc(String xydm, String tsxxpydm,
			String kcmc) {
		List<JyTsxxpy> list = jyTsxxpyService.gettspykcByXyNjMc(xydm, tsxxpydm,
				kcmc);
		return list;
	}
	
	/**
	 * 得到所有的通识培养计划
	 * */
	@RequestMapping(value="/getAllTspyjhList", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> getAllTspyjhList() {
		List<JyTsxxpy> list = jyTsxxpyService.getAllTspyjhList();
		return list;
	}
	
	/**
	 * 得到某年级的通识培养计划
	 * */
	@RequestMapping(value="/getTsxxpyListBynj", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> getTsxxpyListBynj(String nj) {
		List<JyTsxxpy> list = jyTsxxpyService.getTsxxpyListBynj1(nj);
		return list;
	}
	
	@RequestMapping(value="/getListByNj", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> getListByNj(String nj) {
		List<JyTsxxpy> list = jyTsxxpyService.getListByNj(nj);
		return list;
	}
	
	/**
	 * 查看课程代码为kcdm在nj届通识选修培养中是否存在
	 * */
	@RequestMapping(value="/hasKcInNj", method=RequestMethod.GET)
	public @ResponseBody boolean hasKcInNj(String kcdm, String nj) {
		return jyTsxxpyService.hasKcInNj(kcdm, nj);
	}
	
	@RequestMapping(value="/addJyTsxxpy", method=RequestMethod.GET)
	public @ResponseBody void addJyTsxxpy(JyTsxxpy jyTsxxpy) {
		jyTsxxpyService.addJyTsxxpy(jyTsxxpy);
	}
	
	/**
	 * 修改
	 * */
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public @ResponseBody void modify(JyTsxxpy jyTsxxpy) {
		jyTsxxpyService.modifyTsxxpy(jyTsxxpy);
	}
	
	/**
	 * 取得某年的通识课程，状态为：4、学院修改 5、学院删除 6、学院新增
	 * */
	@RequestMapping(value="/getListByNj2", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> getListByNj2(String nj) {
		List<JyTsxxpy> list = jyTsxxpyService.getListByNj2(nj);
		return list;
	}
	
	@RequestMapping(value="/shpasstspyjh", method=RequestMethod.GET)
	public @ResponseBody void shpasstspyjh(String kcdm, String tsdm) {
		JyTsxxpy jyTsxxpy = jyTsxxpyService.getpassTskc(kcdm, tsdm);
		jyTsxxpy.setZt(1);
		jyTsxxpyService.modifyTsxxpy(jyTsxxpy);
		if (jyTsxxpy.getSysKc().getZt() == 4
				&& jyTsxxpy.getZt() == 6) /* 新增 */
		{
			SysKc sysKc = jyTsxxpy.getSysKc();
			sysKc.setZt(1);
			sysKcService.modifyKecheng(sysKc);
		} else if (jyTsxxpy.getSysKc().getZt() == 6
				&& jyTsxxpy.getZt() == 4) /* 修改 */
		{
			SysKc sysKc = jyTsxxpy.getSysKc();
			sysKc.setZt(1);
			sysKcService.modifyKecheng(sysKc);

		} else if (jyTsxxpy.getSysKc().getZt() == 5
				&& jyTsxxpy.getZt() == 3) /* 旧课程 */
		{
			SysKc sysKc = jyTsxxpy.getSysKc();
			// 删除旧课程(逻辑删除)
			sysKc.setZt(0);
			sysKcService.modifyKecheng(sysKc);
			// 物理删除
			// sysKcService.deleteKecheng(sysKc);
		} else if (jyTsxxpy.getZt() == 5) /* 学院删除 */
		{
			jyTsxxpy.setZt(0);
			jyTsxxpyService.modifyTsxxpy(jyTsxxpy);
		}
	}

	@RequestMapping(value="/shRefuse", method=RequestMethod.GET)
	public @ResponseBody void shRefuse(String kcdm, String tsdm) {
		JyTsxxpy jyTsxxpy = jyTsxxpyService.getpassTskc(kcdm, tsdm);
		jyTsxxpy.setZt(2); // 学院删除和拒绝状态相同？？？？？？？？？？？？？？？
		jyTsxxpyService.modifyTsxxpy(jyTsxxpy);
		if (jyTsxxpy.getSysKc().getZt() == 4
				&& jyTsxxpy.getZt() == 6) /* 新增 */
		{
			SysKc sysKc = jyTsxxpy.getSysKc();
			/* 逻辑删除 */
			sysKc.setZt(0);
			sysKcService.modifyKecheng(sysKc);
			/* 物理删除 */
			// sysKcService.deleteKecheng(sysKc);
		} else if (jyTsxxpy.getSysKc().getZt() == 6
				&& jyTsxxpy.getZt() == 4) /* 修改新课程 */
		{
			SysKc sysKc = jyTsxxpy.getSysKc();
			/* 逻辑删除 */
			sysKc.setZt(0);
			sysKcService.modifyKecheng(sysKc);
			/* 物理删除 */
			// sysKcService.deleteKecheng(sysKc);
		} else if (jyTsxxpy.getSysKc().getZt() == 5
				&& jyTsxxpy.getZt() == 3) /* 旧课程 */
		{
			SysKc sysKc = jyTsxxpy.getSysKc();
			sysKc.setZt(1);
			sysKcService.modifyKecheng(sysKc);
		} else if (jyTsxxpy.getZt() == 5) /* 学院删除 */
		{
			jyTsxxpy.setZt(1);
			jyTsxxpyService.modifyTsxxpy(jyTsxxpy);
		}
	}
	
	@RequestMapping(value="/getXkc", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> getXkc(String nj) {
		List<JyTsxxpy> list = jyTsxxpyService.getXkc(nj);
		return list;
	}

	@RequestMapping(value="/getXkcxx", method=RequestMethod.GET)
	public @ResponseBody JyTsxxpy getXkcxx(String nj, String kcmc) {
		JyTsxxpy list = jyTsxxpyService.getXkcxx(nj, kcmc);
		return list;
	}
	
	@RequestMapping(value="/getJkcxx", method=RequestMethod.GET)
	public @ResponseBody JyTsxxpy getJkcxx(String nj, String kcmc) {
		JyTsxxpy list = jyTsxxpyService.getJkcxx(nj, kcmc);
		return list;
	}
	
	/**
	 * 逻辑删除某年的通识培养计划
	 * */
	@RequestMapping(value="/DelAndUpdata", method=RequestMethod.GET)
	public @ResponseBody void DelAndUpdata(String nj) {
		List<JyTsxxpy> list = jyTsxxpyService.getListByNj(nj);
		for (int i = 0; i < list.size(); i++) {
			JyTsxxpy tsxxpy = list.get(i);
			tsxxpy.setZt(0);
			jyTsxxpyService.modifyTsxxpy(tsxxpy);
		}
	}
	
	/**
	 * 通识选修的批量复制
	 * */
	@RequestMapping(value="/creat", method=RequestMethod.GET)
	public @ResponseBody void creat(String Jnj, String Xnj) {
		List<JyTsxxpy> list = jyTsxxpyService.getListByNj(Jnj);// 取出某年级的审核通过课程
		for (int i = 0; i < list.size(); i++) {
			JyTsxxpy jyTsxxpy = list.get(i);
			jyTsxxpy.setTsxxpydm(Xnj.trim());
			jyTsxxpy.setNj(Xnj.trim());
			jyTsxxpyService.addJyTsxxpy(jyTsxxpy);
		}
	}
	
	@RequestMapping(value="/getTsxxpydm", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> getTsxxpydm() {
		List<JyTsxxpy> list = jyTsxxpyService.getTsxxpydm();
		return list;
	}
	
	@RequestMapping(value="/getPyjhBytsdmAndnj", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> getPyjhBytsdmAndnj(String tsdm, String nj) {
		return jyTsxxpyService.getPyjhBytsdmAndnj(tsdm, nj);
	}
}
