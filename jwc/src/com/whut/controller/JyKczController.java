package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyKcz;
import com.whut.service.JyKczService;
import com.whut.service.SysZyService;

/**
 * 课程组管理
 * @author wangql
 */
@RequestMapping(value="/JyKcz")
@Controller
public class JyKczController {

	@Autowired
	private JyKczService jyKczService;
	@Autowired
	private SysZyService sysZyService;

	/**
	 * 通过课程组代码获取课程组
	 * @param kczdm
	 * @return
	 */
	@RequestMapping(value="/getKczBykczdm", method = RequestMethod.GET)
	public @ResponseBody JyKcz getKczBykczdm(String kczdm) { //数据库中kczdm有点重复的，只返回一个？？
		JyKcz jyKcz = jyKczService.getKczBykczdm(kczdm);
		return jyKcz;
	}

	/**
	 * 删除课程组
	 * @param jyKcz
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteMse(String kczdm) {
		JyKcz jyKcz = jyKczService.getKczBykczdm(kczdm);
		jyKcz.setZt(0);
		jyKczService.deleteMse(jyKcz);
		return "DeletlSuccess";
	}
	
	/**
	 * 通过教学计划号获取所有的课程组
	 * @param zydm
	 * @return
	 */	
	@RequestMapping(value="/getAllKczByjxjhh", method = RequestMethod.GET)
	public @ResponseBody List<JyKcz> getAllListByjxjhh(String jxjhh) {
		return jyKczService.getAllListByjxjhh(jxjhh);
	}

	/**
	 * 添加课程组
	 * @param jyKcz
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addAkcz(@RequestBody JyKcz jyKcz) {
		jyKcz.setZt(1);
		jyKczService.addKczInfo(jyKcz);
		return "AddSuccess";
	}

	/**
	 * 修改课程组
	 * @param jyKcz
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public  @ResponseBody String modAkcz(@RequestBody JyKcz jyKcz) {
		jyKczService.modAkcz(jyKcz);
		return "UpdateSuccess";
	}

	public boolean hasMK(JyKcz kcz) {
		return jyKczService.hasMK(kcz);
	}

}
