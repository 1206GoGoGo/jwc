package com.whut.service;

import java.util.List;

import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.pojo.pyjhkcxxZhcxObjF;
import com.whut.pojo.pyjhkcxxZhcxObjM;

public interface DocProgramService {
	/**
	 * 导出培养计划课程信息综合查询结果到Excel
	 * 
	 * @param len
	 * @param filepath
	 * */
	public void pyjhkcxxZhcxToExcel(List<pyjhkcxxZhcxObj> datas,
			pyjhkcxxZhcxObjM nameobj, pyjhkcxxZhcxObjF flagobj, int len,
			String filepath);

}
