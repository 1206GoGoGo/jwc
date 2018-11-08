package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyXxgs;
import com.whut.service.JyXxgsService;

/**
 * 选修归属
 * @author wangql
 *
 */
@RequestMapping(value="/JyXxgs")
@Controller
public class JyXxgsController {
	
	@Autowired
	private JyXxgsService sysXxgsService;

	/**
	 * 添加选修归属
	 * @param jyXxgs
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String addDxklb(@RequestBody JyXxgs jyXxgs) {
		sysXxgsService.addXxgs(jyXxgs);
		return "AddSuccess";
	}

	/**
	 * 获取所有选修归属
	 * @return 选修归属列表
	 */
	@RequestMapping(value="/getAll")  
	public  @ResponseBody List<JyXxgs> getAllList() {
		List<JyXxgs> list = sysXxgsService.getAllList();
		return list;
	}

	/**
	 * 获取可使用的选修归属代码起始点
	 * @return
	 */
	public String getXxgsdm() {
		String xxgsdm = sysXxgsService.getXxgsdm();
		return xxgsdm;
	}

	/**
	 * 修改选修归属
	 * @param jyXxgs
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyXxgs(@RequestBody JyXxgs jyXxgs) {
		sysXxgsService.modifyXxgs(jyXxgs);
		return "UpdateSuccess";
	}

	/**
	 * 删除选修归属
	 * @param xxgsdm
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteXxgs(String xxgsdm) {
		sysXxgsService.deleteXxgs(xxgsdm);
		return "DeletlSuccess";
	}

	/**
	 * 检查某选修归属代码存在
	 * @param xxgsdm
	 * @return
	 */
	public String checkXxgsdm(String xxgsdm) {
		return sysXxgsService.checkXxgsdm(xxgsdm);
	}

	/**
	 * 通过选修归属代码获取选修归属
	 * @param xxgsdm
	 * @return
	 */
	@RequestMapping(value="/getXygs", method = RequestMethod.GET)
	public @ResponseBody JyXxgs getxxgsbyid(String xxgsdm) {
		return sysXxgsService.getxxgsbyid(xxgsdm);
	}
}
