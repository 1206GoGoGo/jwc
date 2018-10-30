package com.whut.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyQx;
import com.whut.pojo.JyYhqx;
import com.whut.pojo.SysJs;
import com.whut.pojo.SysJwyh;
import com.whut.service.JyQxService;


@RequestMapping(value="/JyQx")
@Controller
public class JyQxController {

	@Autowired
	private JyQxService quanXianService;

	@RequestMapping(value="/getAllqx")
	public @ResponseBody List<JyQx> getAllqx() {
		return quanXianService.getAllqx();
	}
	
	@RequestMapping(value="/getyhID",method = RequestMethod.GET)
	public @ResponseBody List<JyYhqx> getyhID(String yhid) {
		List<JyYhqx> list = quanXianService.getyhID(yhid);
		return list;
	}
	
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public @ResponseBody List<SysJs> search(String xm) {
		List<SysJs> list = quanXianService.search(xm);
		return list;
	}

	@RequestMapping(value="/getAll")
	public @ResponseBody List<SysJs> getAll() {
		return quanXianService.getAll();
	}

	@RequestMapping(value="/search_JW",method = RequestMethod.GET)
	public @ResponseBody List<SysJwyh> search_JW(String xm) {
		List<SysJwyh> list = quanXianService.search_JW(xm);
		return list;
	}

	@RequestMapping(value="/searchAll_JW")
	public @ResponseBody List<SysJwyh> searchAll_JW() {
		return quanXianService.searchAll_JW();
	}

	@RequestMapping(value="/mofifyQX",method = RequestMethod.GET)
	public @ResponseBody void mofifyQX(String yhid,int jyQx) {
		BigDecimal bigDecimal = new BigDecimal(jyQx);
		quanXianService.mofifyQX(yhid, bigDecimal);
	}

	@RequestMapping(value="/mofifyJY_YHqX",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody void mofifyJY_YHqX(@RequestBody JyYhqx jyYhqx) {
		quanXianService.mofifyJY_YHqX(jyYhqx);
	}

	@RequestMapping(value="/updateQX")
	public @ResponseBody void updateQX() {
		quanXianService.updateQX();
	}
	
	@RequestMapping(value="/addQx",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody void addQx(@RequestBody JyYhqx jyYhqx) {
		quanXianService.addQx(jyYhqx);
	}
}
