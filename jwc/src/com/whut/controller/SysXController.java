package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.SysX;
import com.whut.service.SysXService;

/**
 * 系
 * @author wangql
 *
 */
@RequestMapping(value="/SysX")
@Controller
public class SysXController {
	@Autowired
	private SysXService sysXService;

	public String checkXdm(String xdm) {
		return sysXService.checkXdm(xdm);
	}

	public void addDxydm(SysX sysX) {
		sysXService.addDxdm(sysX);
	}

	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public @ResponseBody List<SysX> getAllList() {
		List<SysX> list = sysXService.getAllList();
		return list;
	}

	public List<SysX> getListByxydm(String xydm) {
		List<SysX> list = sysXService.getListByxydm(xydm);
		return list;
	}

	public void modifyX(SysX sysX) {
		sysXService.modifyX(sysX);
	}

	public void deleteX(String xdm) {
		sysXService.deleteX(xdm);

	}

	public String getXdmByxydm(String xydm) {
		return sysXService.getXdmByxydm(xydm);
	}

	public void setZt(String xdm) {
		sysXService.setZt(xdm);
	}

	public int getIndex(String xdm) {
		return sysXService.getIndex(xdm);
	}

	/**
	 * 通过系代码获取系
	 * @param xdm 系代码
	 * @return 系
	 */
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public @ResponseBody SysX getxyByxdm(String xdm) {
		SysX sysX = sysXService.getxyByxdm(xdm);
		return sysX;
	}
}
