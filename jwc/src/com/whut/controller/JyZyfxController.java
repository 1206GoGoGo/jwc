package com.whut.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyZyfx;
import com.whut.pojo.SysZy;
import com.whut.service.JyPyjhkcxxService;
import com.whut.service.JyPyjhkcxxbService;
import com.whut.service.JyZyfxService;
import com.whut.service.SysZyService;
import com.whut.service.impl.JyPyjhkcxxServiceImpl;
import com.whut.service.impl.JyPyjhkcxxbServiceImpl;
import com.whut.service.impl.SysZyServiceImpl;


@RequestMapping(value="/JyZyfx")
@Controller
public class JyZyfxController {
	
	@Autowired
	private JyZyfxService jyZyfxService;


	public List<JyZyfx> getAllListByzydm(String zydm) {
		return jyZyfxService.getAllListByzydm(zydm);
	}

	public JyZyfx getJyZyfxByall(String zyfxdm, String zydm, String nj) {
		JyZyfx jyZyfx = jyZyfxService.getJyZyfxByall(zyfxdm, zydm, nj);
		return jyZyfx;
	}

	public JyZyfx getJyZyfxBydm(String zyfxdm) {
		JyZyfx jyZyfx = jyZyfxService.getJyZyfxBydm(zyfxdm);
		return jyZyfx;
	}
    
	@RequestMapping(value="/getAllListByzydm", method=RequestMethod.GET)
	public @ResponseBody List<JyZyfx> getAllListByzydm(String zydm, String nj) {
		return jyZyfxService.getAllListByzydm(zydm, nj);
	}

	public Map getAllListByZydmAndNj(String nj) {
		return jyZyfxService.getAllListByZydmAndNj(nj);
	}

	public List<JyZyfx> getAllListByNj(String nj) {
		return jyZyfxService.getAllListByNj(nj);
	}

	public List<JyZyfx> getAllList() {
		return jyZyfxService.getAllList();
	}

	public String add(JyZyfx obj, String zydm) {
		List<JyZyfx> list = new ArrayList<JyZyfx>();
		list.addAll(getAllListByzydm(zydm, obj.getNj()));
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (obj.getZyfxzwmc().equals(list.get(i).getZyfxzwmc()))
				count++;
		}// 重复专业方向中文名称计数
		JyZyfx existobj = getJyZyfxByall(obj.getZyfxdm(), zydm, obj.getNj());
		if (existobj != null || count != 0) {
			return "专业方向代码重复或者专业方向名称重复";
		} else {
			SysZyService zyservice = new SysZyServiceImpl();
			SysZy sysZy = zyservice.getZyByzydm(zydm);
			obj.setSysZy(sysZy);
			jyZyfxService.add(obj);
			return "添加成功！";
		}
	}

	/**
	 * 删除专业方向，以及置空相关的专业方向代码
	 * */
	public void del(JyZyfx obj) {
		JyPyjhkcxxService jyPyjhkcxxService = new JyPyjhkcxxServiceImpl();
		JyPyjhkcxxbService jyPyjhkcxxbService = new JyPyjhkcxxbServiceImpl();
		jyPyjhkcxxbService.setZyfxNullByZyfx(obj);
		jyPyjhkcxxService.setZyfxNullByZyfx(obj);
		jyZyfxService.delete(obj);
	}

	public String mod(JyZyfx obj) {
		List<JyZyfx> list = new ArrayList<JyZyfx>();
		list.addAll(getAllListByzydm(obj.getSysZy().getZydm(), obj.getNj()));
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (obj.getZyfxzwmc().equals(list.get(i).getZyfxzwmc()))
				count++;
		}// 重复专业方向中文名称计数
		if (count != 0) {
			return "存在相同的专业方向中文名称";
		} else {
			jyZyfxService.modify(obj);
			return "修改成功";
		}
	}

	/**
	 * 获取某专业所有的专业方向的《代码、名称》对应
	 * */
	public List<JyZyfx> getZyfxMapByZydm(String zydm) {
		List<JyZyfx> list = jyZyfxService.getZyfxMapByZydm(zydm);
		return list;
	}
}
