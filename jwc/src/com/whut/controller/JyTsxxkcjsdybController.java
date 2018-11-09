package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyTsxxkcjsdyb;
import com.whut.service.JyTsxxkcjsdybService;

@RequestMapping(value="/JyTsxxkcjsdyb")
@Controller
public class JyTsxxkcjsdybController {

	@Autowired
	private JyTsxxkcjsdybService jyTsxxkcjsdybService;


	@RequestMapping(value="/getAllList", method=RequestMethod.GET)
	public @ResponseBody List<JyTsxxkcjsdyb> getAllList() {
		List<JyTsxxkcjsdyb> list = jyTsxxkcjsdybService.getAllList();
		return list;
	}

	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public @ResponseBody void modify(JyTsxxkcjsdyb jytsxxkcjsdyb) {

		jyTsxxkcjsdybService.modify(jytsxxkcjsdyb);
	}

	public void addJyXzjs(JyTsxxkcjsdyb jytsxxkcjsdyb) {

		jyTsxxkcjsdybService.addJyXzjs(jytsxxkcjsdyb);
	}

	public List<JyTsxxkcjsdyb> GetKcJsList(int pyid) {
		return jyTsxxkcjsdybService.GetKcJsList(pyid);
	}

	public List<JyTsxxkcjsdyb> getDyByxmAndkc(String kcmc, String jsxm) {
		List<JyTsxxkcjsdyb> list = jyTsxxkcjsdybService.getDyByxmAndkc(kcmc,
				jsxm);
		return list;

	}

	public List<JyTsxxkcjsdyb> GetThisKcJsList(String ThisKc, int pyid) {
		return jyTsxxkcjsdybService.GetThisKcJsList(ThisKc, pyid);
	}

}
