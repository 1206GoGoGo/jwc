package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.DmKhfs;
import com.whut.service.DmKhfsService;

@RequestMapping(value="/DmKhfs")
@Controller
public class DmKhfsController {
	@Autowired
	private DmKhfsService sysKhfsService;

	/**
	 * 添加考核方式
	 * @param sysKhfs
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public  @ResponseBody String addDkhfs(@RequestBody DmKhfs sysKhfs) {
		sysKhfsService.addDkhfs(sysKhfs);
		return "AddSuccess";
	}

	/**
	 * 获取所有考核方式
	 * @return
	 */
	@RequestMapping(value="/getAll") 
	public @ResponseBody List<DmKhfs> getAllList() {

		List<DmKhfs> list = sysKhfsService.getAllList();
		return list;
	}

	/**
	 * 获取可使用的考核方式代码起始点
	 * @return
	 */
	@RequestMapping(value="/getKhfsdm", method = RequestMethod.GET)
	public @ResponseBody String getKhfsdm() {
		return sysKhfsService.getKhfsdm();
	}

	/**
	 * 修改考核方式
	 * @param sysKhfs
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyKhfs(@RequestBody DmKhfs sysKhfs) {
		sysKhfsService.modifyKhfs(sysKhfs);
		return "UpdateSuccess";
	}

	/**
	 * 删除考核方式
	 * @param sysKhfs
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteKhfs(String khfsdm) {
		DmKhfs dmKhfs = sysKhfsService.getDmKhfsBydm(khfsdm);
		sysKhfsService.deleteKhfs(dmKhfs);
		return "DeletlSuccess";
	}

	/**
	 * 通过考核方式代码获取考核方式
	 * @param khfsdm
	 * @return
	 */
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public @ResponseBody DmKhfs getDmKhfsBydm(String khfsdm) {
		DmKhfs dmKhfs = sysKhfsService.getDmKhfsBydm(khfsdm);
		return dmKhfs;
	}

}
