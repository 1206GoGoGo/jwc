package com.whut.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.SysXy;
import com.whut.service.SysXyService;

/**
 * 学院
 * @author wangql
 *
 */
@RequestMapping(value="/SysXy")
@Controller
public class SysXyController {

	
	@Autowired
	private SysXyService sysXyService;
	
	/**
	 * 通过学院代码获取学院信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public @ResponseBody SysXy getXyById(@PathVariable String id){
		
		SysXy sysxY = sysXyService.getXyById(id);
		return sysxY;
	}
	
	/**
	 * 通过学院代码获取学院名称
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getXymc/{id}", method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public @ResponseBody String getXymcById(@PathVariable String id) {
		return sysXyService.getXymcById(id);
	}
	
	/**
	 * 获取所有学院信息
	 * @return
	 */
	@RequestMapping(value="/getAll")  
	public @ResponseBody List<SysXy> getAllList(){
		List<SysXy> list = sysXyService.getAllList();
		return list;
	}
	
	/**
	 * 添加学院
	 * @param sysXy
	 * @return
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addXy(@RequestBody SysXy sysXy){//将前端json数据映射成JAVA对象
		sysXyService.addXy(sysXy);
		return "AddSuccess";
	}
	
	/**
	 * 删除学院
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delet/{id}", method = RequestMethod.GET)
	public @ResponseBody String deletXy(@PathVariable String id){
		SysXy sysXy = sysXyService.getXyById(id);
		sysXyService.deleteXy(sysXy);
		return "DeletlSuccess";
	}
	
	/**
	 * 修改学院信息
	 * @return
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyXy(@RequestBody SysXy sysXy){
		sysXyService.modifyXy(sysXy);
		return "UpdateSuccess";
	}
}
