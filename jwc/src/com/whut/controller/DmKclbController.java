package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.DmKclb;
import com.whut.service.DmKclbService;



@RequestMapping(value="/DmKclb")
@Controller
public class DmKclbController {

	@Autowired
	private DmKclbService dmKclbService;


	/**
	 * 检查某课程类别代码是否存在
	 * @param kclbdm
	 * @return
	 */
	public String checkKclbdm(String kclbdm) {
		return dmKclbService.checkKclbdm(kclbdm);
	}

	/**
	 * 添加课程类别
	 * @param sysKclb
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addDkclb(@RequestBody DmKclb sysKclb) {
		dmKclbService.addDkclb(sysKclb);
		return "AddSuccess";
	}

	/**
	 * 获取所有课程类别
	 * @return
	 */
	@RequestMapping(value="/getAll")  
	public @ResponseBody List<DmKclb> getAllList() {
		List<DmKclb> list = dmKclbService.getAllList();
		return list;
	}

	/**
	 * 获取可使用的课程类别代码起始点
	 * @return
	 */
	@RequestMapping(value="/getKclbdm", method = RequestMethod.GET)
	public @ResponseBody String getKclbdm() {
		return dmKclbService.getKclbdm();
	}

	/**
	 * 修改课程类别
	 * @param sysKclb
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyKclb(@RequestBody DmKclb sysKclb) {
		dmKclbService.modifyKclb(sysKclb);
		return "UpdateSuccess";
	}

	/**
	 * 删除课程类别
	 * @param sysKclb
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteKclb(String kclbdm) {
		DmKclb dmKclb = dmKclbService.getkclbBykclbdm(kclbdm);
		dmKclbService.deleteKclb(dmKclb);
		return "DeleteSuccess";
	}

	/**
	 * 将课程类别状态设置为0
	 * @param Kclbdm
	 */
	public void setZt(String Kclbdm) {
		dmKclbService.setZt(Kclbdm);
	}

	/**
	 * 获取课程类别代码在数据库中的序号
	 * @param kclbdm
	 * @return
	 */
	public int getIndex(String kclbdm) {

		return dmKclbService.getIndex(kclbdm);
	}

	/**
	 * 通过课程类别代码获取课程类别
	 * @param kclbdm
	 * @return
	 */
	@RequestMapping(value="/getkclbBykclbdm", method = RequestMethod.GET)
	public @ResponseBody DmKclb getkclbBykclbdm(String kclbdm) {
		DmKclb dmKclb = dmKclbService.getkclbBykclbdm(kclbdm);
		return dmKclb;
	}
}
