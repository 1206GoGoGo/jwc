package com.whut.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyTsxxpy;
import com.whut.service.JyTsxxpyService;

@RequestMapping(value="/JyTsxxpy")
@Controller
public class JyTsxxpyController {
	
	@Autowired
	private JyTsxxpyService jyTsxxpyService;

	@RequestMapping(value="/searchxvsn1", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> searchxvsn1(String xydm, String nj) {
		List<JyTsxxpy> list = jyTsxxpyService.searchxvsn1(xydm, nj);
		return list;
	}
	
	@RequestMapping(value="/gettspykcByXyNjMc", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxpy> gettspykcByXyNjMc(String xydm, String tsxxpydm,
			String kcmc) {
		List<JyTsxxpy> list = jyTsxxpyService.gettspykcByXyNjMc(xydm, tsxxpydm,
				kcmc);
		return list;
	}
}
