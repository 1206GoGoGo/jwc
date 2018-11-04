package com.whut.service;

import java.util.List;

import com.whut.pojo.JyXxgs;


public interface JyXxgsService {
	public void addXxgs(JyXxgs sysXxgs);

	/**
	 * 获取选修归属列表
	 * @return 选修归属列表
	 */
	public List<JyXxgs> getAllList();

	public String getXxgsdm();

	public void modifyXxgs(JyXxgs sysXxgs);

	public void deleteXxgs(String xxgsdm);

	public String checkXxgsdm(String xxgsdm);

	public JyXxgs getxxgsbyid(String xxgsdm);
}
