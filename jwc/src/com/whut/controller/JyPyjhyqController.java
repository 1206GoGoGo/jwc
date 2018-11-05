package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyPyjhyq;
import com.whut.service.JyPyjhyqService;

@RequestMapping(value="/JyPyjhyq")
@Controller
public class JyPyjhyqController {
	
	@Autowired
	private JyPyjhyqService jyPyjhyqService;
	
	/**
	 * 根据查询条件进行查询
	 * 
	 * 如果某项条件没有指定，则为“0”
	 * */
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public @ResponseBody List<JyPyjhyq> search(String xydm, String zydm, String nj) {
		List<JyPyjhyq> list = jyPyjhyqService.search(xydm, zydm, nj);
		return list;
	}

}
