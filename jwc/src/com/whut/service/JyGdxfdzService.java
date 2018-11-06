package com.whut.service;

import java.util.List;

import com.whut.pojo.JyGdxfdz;


public interface JyGdxfdzService {

	public List<JyGdxfdz> getAllList();

	/**
	 * 获取高低学分对照列表
	 * @param kcm 课程名称
	 * @return 高低学分对照表
	 */
	public List<JyGdxfdz> search(String kcm);

	/**
	 * 清除高低学分对照
	 * @param jyGdxfdz  高低学分对照对象
	 */
	public void clearDZ(JyGdxfdz jyGdxfdz);

	public JyGdxfdz findById(Number id);

	public void addGdfxdz(JyGdxfdz obJyGdxfdz);

	// public JyGdxfdz search(String kcm);
}
