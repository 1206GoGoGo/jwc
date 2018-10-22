package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.service.JyPyjhkcxxService;


@RequestMapping(value="/JyPyjhkcxx")
@Controller
public class JyPyjhkcxxController {
	
	@Autowired
	private JyPyjhkcxxService jyPyjhkcxxService;
	
	@RequestMapping(value="/pyjhkcxxZhcx/{whatString}/{whereString}",method = RequestMethod.GET)
	public @ResponseBody List<pyjhkcxxZhcxObj> pyjhkcxxZhcx(@PathVariable("whatString") String whatString, @PathVariable("whereString") String whereString) {
		return jyPyjhkcxxService.pyjhkcxxZhcx(whatString, whereString);
	}
}
