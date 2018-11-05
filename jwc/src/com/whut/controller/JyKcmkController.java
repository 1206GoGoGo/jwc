package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyKcmk;
import com.whut.service.JyKcmkService;

/**
 * 课程模块
 * @author wangql
 *
 */
@RequestMapping(value="/JyKcmk")
@Controller
public class JyKcmkController {
	@Autowired
	private JyKcmkService jykcmkService;
	//@Autowired
	//private JyKczService jyKczService;

	public void deleteMse(JyKcmk jyKcmk) {
		jykcmkService.deleteMse(jyKcmk);
	}

	/**
	 * 添加课程模块
	 * @param jyKcmk
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addAkcmk(@RequestBody JyKcmk jyKcmk) {
		jyKcmk.setZt(1);
		jykcmkService.addKcmkInfo(jyKcmk);
		return "AddSuccess";
	}

	/**
	 * 通过课程组ID获取所有课程模块
	 * @param kczid
	 * @return
	 */
	@RequestMapping(value="/getAllBykczid", method = RequestMethod.GET)
	public @ResponseBody List<JyKcmk> getAllListByKCZID(int kczid) {
		return jykcmkService.getAllListByKCZID(kczid);
	}

	/**
	 * 更改课程模块
	 * @param jyKcmk
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modAkcmk(@RequestBody JyKcmk jyKcmk) {
		jyKcmk.setZt(1);
		jykcmkService.modAkcmk(jyKcmk);
		return "UpdateSuccess";
	}

	/**
	 * 删除课程模块
	 * @param jyKcmk
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String delAkcmk(int id) {
		JyKcmk jyKcmk = jykcmkService.getKcmkByKcmkId(id);
		jyKcmk.setZt(0);
		jykcmkService.modAkcmk(jyKcmk);
		return "DeletlSuccess";
	}

	/**
	 * 通过课程模块id获取课程模块
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public @ResponseBody JyKcmk getKcmkByKcmkId(int id) {
		JyKcmk Kcmk = jykcmkService.getKcmkByKcmkId(id);
		return Kcmk;
	}

	/**
	 * 是否存在某课程模块
	 * */
	public boolean hasKc(JyKcmk kcmk) {
		return jykcmkService.hasKc(kcmk);
	}

}
