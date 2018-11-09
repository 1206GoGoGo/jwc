package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyXxtx;
import com.whut.service.JyXxtxService;



@RequestMapping(value="/JyXxtx")
@Controller
public class JyXxtxController {
	
	@Autowired
	private JyXxtxService jyXxtxService;
	
	//查询消息提醒表中的所有信息
	@RequestMapping(value="/getAllList")
	public @ResponseBody List<JyXxtx> getAllList() {
		List<JyXxtx> list = jyXxtxService.getAllList();
		return list;
	}
	
	//根据时间段查询收件箱信息
	@RequestMapping(value="/getXxtxByjsf",method = RequestMethod.GET)
	public @ResponseBody List<JyXxtx> getXxtxByjsf(String jsf,String sj1,String sj2){
		List<JyXxtx> list = jyXxtxService.getXxtxByjsf(jsf, sj1, sj2);
		return list;
	}
	
	@RequestMapping(value="/getListByjsf",method = RequestMethod.GET)
	public @ResponseBody List<JyXxtx> getListByjsf(String xymc){
		List<JyXxtx> list = jyXxtxService.getListByjsf(xymc);
		return list;
	}
	
	@RequestMapping(value="/afterviewMse",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody void afterviewMse(@RequestBody JyXxtx jyXxtx) {
		jyXxtx.setXxzt(0);	//setXxzt(0)表示这条消息已读
		jyXxtxService.afterviewMse(jyXxtx);
	}
	
	@RequestMapping(value="/getXxtxByxxdm",method = RequestMethod.GET)
	public @ResponseBody JyXxtx getXxtxByxxdm(int xxdm) {
		JyXxtx jyXxtx = jyXxtxService.getXxtxByxxdm(xxdm);
		return jyXxtx;
	}
	
	@RequestMapping(value="/getdelXxtxByxxdm",method = RequestMethod.GET)
	public @ResponseBody JyXxtx getdelXxtxByxxdm(String xxdm) {
		JyXxtx list = jyXxtxService.getdelXxtxByxxdm(xxdm);
		return list;
	}
	
	@RequestMapping(value="/deleteMse",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody void deleteMse(@RequestBody JyXxtx jyXxtx) {
		jyXxtx.setZt(0);	//setZt(0)表示这条消息删除到回收箱
		jyXxtxService.deleteMse(jyXxtx);
	}
	
	@RequestMapping(value="/getListByfsf",method = RequestMethod.GET)
	public @ResponseBody List<JyXxtx> getListByfsf(String xymc) {
		List<JyXxtx> list = jyXxtxService.getListByfsf(xymc);
		return list;
	}
	
	//根据时间段查询发件箱信息
	@RequestMapping(value="/getXxtxByfsf",method = RequestMethod.GET)
	public @ResponseBody List<JyXxtx> getXxtxByfsf(String fsf,String sj1,String sj2) {
		List<JyXxtx> list = jyXxtxService.getXxtxByfsf(fsf, sj1, sj2);
		return list;
	}
	
	@RequestMapping(value="/getdelXxtxByfsforjsf",method = RequestMethod.GET)
	public @ResponseBody List<JyXxtx> getdelXxtxByfsforjsf(String fsf,String sj1,String sj2) {
		List<JyXxtx> list = jyXxtxService.getdelXxtxByfsforjsf(fsf, sj1, sj2);
		return list;
	}
	
	@RequestMapping(value="/getdelListByfsforjsf",method = RequestMethod.GET)
	public @ResponseBody List<JyXxtx> getdelListByfsforjsf(String xymc) {
		List<JyXxtx> list = jyXxtxService.getdelListByfsforjsf(xymc);
		return list;
	}
	
	@RequestMapping(value="/RealDeleteMse",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody void RealDeleteMse(@RequestBody JyXxtx jyXxtx) {
		jyXxtx.setZt(2);// 状态为2逻辑删除回收箱不显示，1未删除，0删除回到回收箱
		jyXxtxService.RealDeleteMse(jyXxtx);
	}
	
	/*
	@RequestMapping(value="/addXxtx",method = RequestMethod.POST,consumes= "application/json")
	public void addXxtx(@RequestBody JyXxtx jyXxtx, ArrayCollection xyList) {
		List xyArrayList = xyList;
		for (int i = 0; i < xyArrayList.size(); i++) {
			jyXxtx.setJsf(xyArrayList.get(i).toString());
			jyXxtxService.addXxtx(jyXxtx);
		}
	}
	*/
	//ArrayCollection可以用什么代替[材料学院, 测试学院T, 化工学院]
}
