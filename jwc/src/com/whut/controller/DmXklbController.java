package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.DmXklb;
import com.whut.service.DmXklbService;


@RequestMapping(value="/DmXklb")
@Controller
public class DmXklbController {
	
	@Autowired
	private DmXklbService dmXklbService;

	/**
	 * 获取所有学科类别
	 * @return
	 */
	@RequestMapping(value="/getAll")  
	public @ResponseBody List<DmXklb> getAllList() {
		return dmXklbService.getAllList();
	}

	/**
	 * 获取可使用的学科类别代码起始点
	 * @return
	 */
	@RequestMapping(value="/getXklbdm", method = RequestMethod.GET)
	public @ResponseBody String getXklbdm() {
		return dmXklbService.getXklbdm();
	}

	/**
	 * 检查某学科类别代码是否存在
	 * @param xklbdm
	 * @return
	 */
	public String checkXklbdm(String xklbdm) {
		return dmXklbService.checkXklbdm(xklbdm);
	}

	/**
	 * 添加学科类别
	 * @param sysXklb
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addDxklb(@RequestBody DmXklb sysXklb) {
		dmXklbService.addDxklb(sysXklb);
		return "AddSuccess";
	}

	/**
	 * 修改学科类别
	 * @param sysXklb
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyXklb(@RequestBody DmXklb sysXklb) {
		dmXklbService.modifyXklb(sysXklb);
		return "UpdateSuccess";
	}

	/**
	 * 删除学科类别
	 * @param sysXklb
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteXklb(String xklbdm) {
		DmXklb xklb = dmXklbService.getXklbById(xklbdm);
		System.out.println(xklb);
		dmXklbService.deleteXklb(xklb);
		return "DeletlSuccess";
	}

}
