package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyPyjhkcxx;
import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.service.JyPyjhkcxxService;


@RequestMapping(value="/JyPyjhkcxx")
@Controller
public class JyPyjhkcxxController {
	
	@Autowired
	private JyPyjhkcxxService jyPyjhkcxxService;
	
	@RequestMapping(value="/pyjhkcxxZhcx",method = RequestMethod.GET)
	public @ResponseBody List<pyjhkcxxZhcxObj> pyjhkcxxZhcx(String whatString, String whereString) {
		
		//whatString是查询要显示的字段、whereString是查询条件
		return jyPyjhkcxxService.pyjhkcxxZhcx(whatString, whereString);
		
	}
	
	@RequestMapping(value="/getZypyKcByjxjhhAndKcmc",method = RequestMethod.GET)
	public @ResponseBody List<JyPyjhkcxx> getZypyKcByjxjhhAndKcmc(String jxjhh, String kcmc) {

		List<JyPyjhkcxx> list = jyPyjhkcxxService.getZypyKcByjxjhhAndKcmc(jxjhh, kcmc);
		return list;
	}
	
	@RequestMapping(value="/getZypyKcByjxjhh",method = RequestMethod.GET)
	public @ResponseBody List<JyPyjhkcxx> getZypyKcByjxjhh(String jxjhh) {
		
		List<JyPyjhkcxx> list = jyPyjhkcxxService.getZypyKcByjxjhh(jxjhh);
		return list;
	}

	
}
