package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.DmKcxz;
import com.whut.service.DmKcxzService;


@RequestMapping(value="/DmKcxz")
@Controller
public class DmKcxzController {
	@Autowired
	private DmKcxzService dmKcxzService;

	
	/**
	 * 添加课程性质
	 * @param dmKcxz
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addDkcxz(@RequestBody DmKcxz dmKcxz) {
		dmKcxzService.addDkcxz(dmKcxz);
		return "AddSuccess";
	}

	/**
	 * 获取所有的课程性质信息
	 * @return
	 */
	@RequestMapping(value="/getAll")  
	public @ResponseBody List<DmKcxz> getAllList() {
		List<DmKcxz> list = dmKcxzService.getAllList();
		return list;
	}

	/**
	 * 获取可使用的课程性质代码起始点
	 * @return
	 */
	@RequestMapping(value="/getKcxzdm", method = RequestMethod.GET)
	public @ResponseBody String getKcxzdm() {
		return dmKcxzService.getKcxzdm();
	}

	/**
	 * 修改课程性质
	 * @param dmKcxz
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyKcxz(@RequestBody DmKcxz dmKcxz) {
		dmKcxzService.modifyKcxz(dmKcxz);
		return "UpdateSuccess";
	}

	/**
	 * 删除课程性质
	 * @param dmKcxz
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteKcxz(String id) {
		DmKcxz dmKcxz = dmKcxzService.getKcxzById(id);
		dmKcxzService.deleteKcxz(dmKcxz);
		return "DeleteSuccess";
	}

	/**
	 * 检查某课程性质代码是否已存在
	 * @param kcxzdm
	 * @return
	 */
	public String checkKcxzdm(String kcxzdm) {
		return dmKcxzService.checkKcxzdm(kcxzdm);
	}

}
