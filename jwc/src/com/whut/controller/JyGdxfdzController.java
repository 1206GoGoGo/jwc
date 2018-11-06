package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyGdxfdz;
import com.whut.service.JyGdxfdzService;

@RequestMapping(value="/JyGdxfdz")
@Controller
public class JyGdxfdzController {

	@Autowired
	private JyGdxfdzService jyGdxfdzService;

	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public @ResponseBody List<JyGdxfdz> getAllList() {
		List<JyGdxfdz> list = jyGdxfdzService.getAllList();
		return list;
	}

	/**
	 * 通过课程名称获取高低学分对照列表
	 * @param kcm 课程名称
	 * @return 高低学分对照表
	 */
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public @ResponseBody List<JyGdxfdz> search(String kcm) {
		List<JyGdxfdz> list = jyGdxfdzService.search(kcm);
		return list;
	}


	public JyGdxfdz findById(Number id) {
		JyGdxfdz obj = jyGdxfdzService.findById(id);
		return obj;
	}

	
	/**
	 * 增加课程对照
	 * @param obJyGdxfdz 课程对照对象
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addGdfxdz(@RequestBody JyGdxfdz obJyGdxfdz) {
		jyGdxfdzService.addGdfxdz(obJyGdxfdz);
		return "AddSuccess";
	}

	/**
	 * 清除高低学分对照
	 * @param jyGdxfdz 高低学分对照对象
	 */
	@RequestMapping(value="/clear",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String clearDZ(@RequestBody JyGdxfdz jyGdxfdz) {
		jyGdxfdzService.clearDZ(jyGdxfdz);
		return "clearSuccess";
	}

}
