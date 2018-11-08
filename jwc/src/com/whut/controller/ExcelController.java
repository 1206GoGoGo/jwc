package com.whut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.service.ExcelService;

/**
 * 导入课程简介
 * @author wangql
 *
 */
@RequestMapping(value="/Excel")
@Controller
public class ExcelController {
	@Autowired
	private ExcelService excelService;
	
	
	/**
	 * 导入课程简介
	 * @param path 课程简介文件路径
	 * @return 导入的数据条数
	 */
	@RequestMapping(value="/importKcjj")  
	public @ResponseBody String importKcjj(String path){
		return this.excelService.importKcjj(path);	 //返回成功导入的条数
	}
}
