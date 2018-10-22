package com.whut.service;

import java.util.List;

import com.whut.pojo.SysXy;

public interface SysXyService {
	
	/**
	 * 添加学院
	 * @param sysXy 学院对象
	 */
	public void addXy(SysXy sysXy);

	/**
	 * 获取所有学院
	 * @return
	 */
	public List<SysXy> getAllList();

	/**
	 * 修改学院
	 * @param sysXy
	 */
	public void modifyXy(SysXy sysXy);

	/**
	 * 删除学院
	 * @param sysXy
	 */
	public void deleteXy(SysXy sysXy);

	/**
	 * 检查学院代码是否存在
	 * @param xydm
	 * @return
	 */
	public String checkXydm(String xydm);

	public SysXy getXyIdByMc(String name);

	/**
	 * 通过id获取学院
	 * @param id
	 * @return
	 */
	public SysXy getXyById(String id);

	/**
	 * 通过id获取学院名称
	 * @param id
	 * @return
	 */
	public String getXymcById(String id);

	
	public List<SysXy> getxylistbymc(String xymc);
}
