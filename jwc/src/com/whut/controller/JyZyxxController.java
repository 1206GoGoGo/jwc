package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyZyxx;
import com.whut.service.JyPyjhkcxxService;
import com.whut.service.JyPyjhyqService;
import com.whut.service.JyZyxxService;


@RequestMapping(value="/JyZyxx")
@Controller
public class JyZyxxController {

	@Autowired
	private JyZyxxService jyZyxxService;  //专业信息
	@Autowired
	private JyPyjhyqService jyPyjhyqService; //培养计划要求
	@Autowired
	private JyPyjhkcxxService jyPyjhkcxxService; // 培养计划课程信息
	//private JyPyjhkcxxbService jyPyjhkcxxbService; //培养计划课程信息b ？？？？？？？？？？？？？？？？

	/**
	 * 添加或覆盖专业信息
	 * @param jyZyxx
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addZyxx(@RequestBody JyZyxx jyZyxx) {
		JyZyxx o = jyZyxxService.getZyxx(jyZyxx.getJxjhh());
		if (o == null) {
			jyZyxxService.addZyxx(jyZyxx);
		} else {
			o.setZt(1);
			jyZyxxService.modifyZyxx(o);
		}
		return "AddSuccess";
	}

	/**
	 * 通过学院的代码、校区代码、年级查询专业信息
	 * @param xydm 学院代码
	 * @param xqdm 校区代码
	 * @param nj 年级
	 * @return
	 */
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public @ResponseBody List<JyZyxx> search(String xydm, String xqdm, String nj) {
		List<JyZyxx> list = jyZyxxService.search(xydm, xqdm, nj);
		return list;
	}

	/**
	 * 通过学院的代码、校区代码、年级、状态查询专业信息
	 * @param xydm 学院代码
	 * @param xqdm 校区代码
	 * @param nj 年级
	 * @param ZT 状态
	 * @return
	 */
	@RequestMapping(value="/search2",method = RequestMethod.GET)
	public @ResponseBody List<JyZyxx> search(String xydm, String xqdm, String nj, String ZT) {
		List<JyZyxx> list = jyZyxxService.search(xydm, xqdm, nj, ZT);
		return list;
	}

	/**
	 * 获取所有专业信息
	 * @return
	 */
	@RequestMapping(value="/getAll") 
	public @ResponseBody List<JyZyxx> getAllList() {
		return jyZyxxService.getAllList();
	}

	/**
	 * 通过教学计划号查询专业信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public @ResponseBody JyZyxx getZyxxListByjxjhh(String jxjhh) {
		return jyZyxxService.getZyxxListByjxjhh(jxjhh);
	}

	/**
	 * 修改专业信息
	 * @param jyZyxx
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyZyxx(@RequestBody JyZyxx jyZyxx) {
		
		jyZyxxService.modifyZyxx(jyZyxx);
		return "UpdateSuccess";
	}

	/**
	 * 逻辑删除专业信息，及，其他的相关数据
	 * */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteZyxx(String jxjhh) {
		//jyPyjhkcxxbService.delJyPyjhkcxxbByJxjhh(jxjhh);   //？？？？？？？？？？？？？？？？？？？？？
		jyPyjhkcxxService.delJyPyjhkcxxByJxjhh(jxjhh);
		jyPyjhyqService.delAJyPyjhyq(jxjhh);
		jyZyxxService.deleteZyxx(jxjhh);
		return "DeleteSuccess";
	}

	public List<JyZyxx> MHsearch(int Tj, String text) {
		List<JyZyxx> list = jyZyxxService.MHsearch(Tj, text);
		return list;
	}

	/**
	 * 通过教学计划号复制专业信息
	 * @param Jnj
	 * @param Xnj
	 * @param jxjhh
	 */
	@RequestMapping(value="/copy", method = RequestMethod.GET) //未测试
	public @ResponseBody String copy(String Jnj, String Xnj, String jxjhh) {
		JyZyxx jyZyxx = jyZyxxService.getZyxxListByjxjhh(jxjhh);
		jyZyxx.setNj(Xnj);
		String Xjxjhh;
		String zydm = jyZyxx.getJxjhh().substring(4);
		Xjxjhh = Xnj + zydm;
		jyZyxx.setJxjhh(Xjxjhh);
		jyZyxxService.addZyxx(jyZyxx);
		return "CopySuccess";
	}

	/**
	 * 全年级复制
	 * */
	@RequestMapping(value="/copyAll", method = RequestMethod.GET)//未测试
	public @ResponseBody String copyAll(String Jnj, String Xnj) { 
		List<JyZyxx> list = jyZyxxService.getZyxxListByNj(Jnj);
		JyZyxx zyxx = null;
		int i = 0;
		for (i = 0; i < list.size(); i++) {
			zyxx = list.get(i);
			zyxx.setNj(Xnj);
			String Xjxjhh = "";
			String zydm = zyxx.getJxjhh().substring(4);
			Xjxjhh = Xnj + zydm;
			zyxx.setJxjhh(Xjxjhh);
			jyZyxxService.addZyxx(zyxx);
		}
		return "CopyAllSuccess";
	}

	/**
	 * 检查是否有状态为1的相应zyxx
	 * */
	public String checkJxjhh(String jxjhh) {
		return jyZyxxService.checkJxjhh(jxjhh);
	}

	/**
	 * 将zyxxb拷贝到zyxx中
	 * */
	// public void copy(String jxjhh)
	// {
	// jyZyxxService.copy(jxjhh);
	// }
	

	//删除测试专业信息
	public void deleteZt2() {
		jyZyxxService.deleteZt2();
	}

}
