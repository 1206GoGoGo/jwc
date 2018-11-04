package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.SysZy;
import com.whut.service.SysZyService;

/**
 * 专业
 * @author wangql
 *
 */
@RequestMapping(value="/SysZy")
@Controller
public class SysZyController {
	
	@Autowired
	private SysZyService sysZyService;
	
	public List<SysZy> getzyListByXdm(String id) {
		List<SysZy> list = sysZyService.getzyListByXdm(id);
		return list;
	}

	public List<SysZy> getzyListByXydm(String id) {
		List<SysZy> list = sysZyService.getzyListByXydm(id);
		return list;
	}

	/**
	 * 获取所有专业信息
	 * @return
	 */
	@RequestMapping(value="/getAll")  
	public @ResponseBody List<SysZy> getAllZyList() {
		List<SysZy> list = sysZyService.getAllZyList();
		return list;
	}

	/**
	 * 修改专业信息
	 * @param sysZy
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyZy(@RequestBody SysZy sysZy) {
		sysZyService.modifyZy(sysZy);
		return "UpdateSuccess";
	}

	public String getZydmByXydm(String xydm) {
		return sysZyService.getZydmByXydm(xydm);
	}

	/**
	 * 添加专业
	 * @param sysZy
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addZy(@RequestBody SysZy sysZy) {
		sysZyService.addZy(sysZy);
		return "AddSuccess";
	}

	/**
	 * 通过专业代码获取专业信息
	 * @param zydm
	 * @return
	 */
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public @ResponseBody SysZy getZyByzydm(String zydm) {
		SysZy sysZy = sysZyService.getZyByzydm(zydm);
		return sysZy;
	}

	/**
	 * 通过专业代码删除专业
	 * @param zydm
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteZy(String zydm) {
		sysZyService.deleteZy(zydm);
		return "DeletlSuccess";
	}

	public String checkZydm(String zydm) {
		return sysZyService.checkZydm(zydm);
	}

	public List<SysZy> WhSearch(String ssxydm, String zymc) {
		List<SysZy> list = sysZyService.WhSearch(ssxydm, zymc);
		return list;
	}

	public List<SysZy> getzyListByxydm(String xydm) {
		List<SysZy> list = sysZyService.getzyListByxydm(xydm);
		return list;
	}
}
