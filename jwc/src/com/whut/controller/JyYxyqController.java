package com.whut.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyYxyq;
import com.whut.pojo.SysKc;
import com.whut.service.JyYxyqService;

@RequestMapping(value="/JyYxyq")
@Controller
public class JyYxyqController {
	
	@Autowired
	private JyYxyqService jyYxyqService;
	
	@RequestMapping(value="/getxykcByyxdmAndKc", method=RequestMethod.GET)
	public @ResponseBody List<JyYxyq> getxykcByyxdmAndKc(String yxyqdm, String kcdm) {
		List<JyYxyq> list = jyYxyqService.getxykcByyxdmAndKc(yxyqdm, kcdm);
		return list;
	}
	
	public List<SysKc> getyxyqListByJxjhh(String jxjhh, String kcdm) {
		List<JyYxyq> yxyql = jyYxyqService.getyxyqListByJxjhh(jxjhh, kcdm);
		// System.out.println("##############"+yxyql.size());
		List<SysKc> list = new ArrayList();
		for (int i = 0; i < yxyql.size(); i++) {
			SysKc kc = new SysKc();
			kc.setKcdm(yxyql.get(i).getSysKcByYxkcdm().getKcdm());
			kc.setKczwmc(yxyql.get(i).getSysKcByYxkcdm().getKczwmc());
			list.add(kc);
		}
		return list;
	}

	public void addJyYxyq(JyYxyq jyYxyq) {
		jyYxyqService.addJyYxyq(jyYxyq);
	}

	public void addJyYxyqList(Collection<JyYxyq> jyYxyqC) {
		Collection<JyYxyq> data = jyYxyqC;
		Iterator<JyYxyq> it = data.iterator();
		while (it.hasNext()) {
			JyYxyq obj = it.next();
			jyYxyqService.addJyYxyq(obj);
		}
	}
	
	
}
