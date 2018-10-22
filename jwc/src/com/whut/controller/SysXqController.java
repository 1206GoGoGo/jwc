package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.SysXq;
import com.whut.service.SysXqService;

/**
 * 校区
 * @author wangql
 *
 */

@RequestMapping(value="/SysXq")
@Controller
public class SysXqController {
	
	@Autowired
	private SysXqService dmXqService;
	
	/**
	 * 添加校区信息
	 * @param dmXq
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addDxklb(@RequestBody SysXq dmXq) {
		dmXqService.addDxqdm(dmXq);
		return "AddSuccess";
	}
	
	/**
	 * 获取各校区信息
	 * @return
	 */
	@RequestMapping(value="/getAll")  
	public @ResponseBody List<SysXq> getAllList() {
		List<SysXq> list = dmXqService.getAllList();
		return list;
	}
	
	
	/**
	 * 修改校区信息
	 * @param dmXq
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyXq(@RequestBody SysXq dmXq) {
		dmXqService.modifyXq(dmXq);
		return "UpdateSuccess";
	}

	/**
	 * 通过校区代码删除校区
	 * @param xqdm
	 */
	@RequestMapping(value="/delet/{xqdm}", method = RequestMethod.GET)
	public @ResponseBody String deleteXq(@PathVariable String xqdm) {
		dmXqService.deleteXq(xqdm);
		return "DeletlSuccess";
	}

	/**
	 * 获取校区代码的最大数+1（新添加校区代码起始点）
	 * @return
	 */
	@RequestMapping(value="/getXqdm", method = RequestMethod.GET)
	public @ResponseBody String getXqdm() {
		return dmXqService.getXqdm();
	}

	/**
	 * 查看校区代码是否存在
	 * @param xqdm
	 * @return
	 */
	public String checkXqdm(String xqdm) {
		return dmXqService.checkXqdm(xqdm);
	}

	/**
	 * 通过校区代码获取校区信息
	 * @param xqdm
	 * @return
	 */
	@RequestMapping(value="/get/{xqdm}", method = RequestMethod.GET)
	public @ResponseBody SysXq getXqByXqdm(@PathVariable String xqdm) {
		return dmXqService.getXqByXqdm(xqdm);
	}
}
