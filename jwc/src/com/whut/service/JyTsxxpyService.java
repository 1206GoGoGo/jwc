package com.whut.service;

import java.util.List;

import com.whut.pojo.JyTsxxpy;


public interface JyTsxxpyService {
	// 按学院，年级查询 2012计算机通识培养计划表

	public List<JyTsxxpy> searchxvsn1(String xydm, String nj);

	public List<JyTsxxpy> getTsInitList();
	
	public List<JyTsxxpy> gettspykcByXyNjMc(String xydm, String tsxxpydm,
			String kcmc);
	
	
}
