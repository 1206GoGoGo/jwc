package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value="/getPyjhkcxx1",method = RequestMethod.GET)
	public @ResponseBody List<JyPyjhkcxx> getPyjhkcxx1(String jxjhh) {
		return jyPyjhkcxxService.getPyjhkcxx1(jxjhh);
	}
	
	@RequestMapping(value="/addJyPyjhkcxx",method = RequestMethod.GET)
	public @ResponseBody void addJyPyjhkcxx(JyPyjhkcxx jyPyjhkcxx) {
		jyPyjhkcxxService.addJyPyjhkcxx(jyPyjhkcxx);
	}
	
	@RequestMapping(value="/checkXxyq",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String checkXxyq(@RequestBody JyPyjhkcxx jyPyjhkcxx) {
		int flag = 1;
		String result = "";
		List<JyPyjhkcxx> list = jyPyjhkcxxService.getPyjhkcxx(jyPyjhkcxx.getJxjhh(), jyPyjhkcxx.getJykkxq(), 10);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getXxkc() != null) {
				String[] arr = list.get(i).getXxkc().split("-");
				for (int j = 0; j < arr.length; j++) {
					if (arr[j].equals(jyPyjhkcxx.getSysKc().getKcdm())) {
						result = result + list.get(i).getSysKc().getKcdm() + " ";
						flag = 0;
					}
				}
			}
		}
		result = result + "以上课程的先修课程有这门课程";
		if (flag == 1) {
			result = "success";
		}
		return result;
	}
	
	@RequestMapping(value="/getPyjhkcxxBydistinct",method = RequestMethod.GET)
	public @ResponseBody List<String> getPyjhkcxxBydistinct(String xydm, String nj, String selectedxq) {
		return jyPyjhkcxxService.getPyjhkcxxBydistinct(xydm, nj, selectedxq);
	}
	
	@RequestMapping(value="/getgxkc",method = RequestMethod.GET)
	public @ResponseBody List<JyPyjhkcxx> getgxkc(String xydm, String zydm, String nj) {
		List<JyPyjhkcxx> list = jyPyjhkcxxService.getgxkc(xydm, zydm, nj);
		return list;
	}
}
