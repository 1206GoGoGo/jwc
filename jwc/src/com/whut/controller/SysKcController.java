package com.whut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.SysKc;
import com.whut.service.SysKcService;

@RequestMapping(value="/SysKc")
@Controller
public class SysKcController {
	
	@Autowired
	private SysKcService sysKcService;

	@RequestMapping(value="/modify", method=RequestMethod.POST, consumes= "application/json")
	public @ResponseBody void modify(@RequestBody SysKc sysKc) {
		sysKcService.modifyKecheng(sysKc);
	}
	
}
