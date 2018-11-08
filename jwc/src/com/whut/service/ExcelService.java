package com.whut.service;

public interface ExcelService {

	/**
	 * 导入课程简介
	 * @param path 课程简介文件路径
	 * @return 导入的数据条数
	 */
	public String importKcjj(String path);
}
