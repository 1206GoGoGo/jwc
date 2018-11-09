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
	
	/*
	 * 教学计划批量打印：pldyExport（）
	 * 
	 * 打印培养计划课程信息表中”教学计划号“数组”jxjhhArray“中的 and
	 * ”开课学期“为”xq“的课程，并按”排序方式pxfs“导出到excel文件中
	 */
	public void pldyExport(String[] jxjhhArray, String xq, String pxfs,
			String filepath);
}
