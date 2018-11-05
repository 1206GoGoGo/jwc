package com.whut.service;

import java.util.List;

import com.whut.pojo.SysKc;


public interface SysKcService {

	/**
	 * 添加课程
	 * @param sysKc 课程信息对象
	 */
	public void addKecheng(SysKc sysKc);

	/**
	 * 获取所有课程
	 * @return 返回课程列表
	 */
	public List<SysKc> getAll();
	
	
	/**
	 * @param xdm 课程代码
	 * @return
	 */
	public String recommend(String xdm);

	/**
	 * 修改课程
	 * @param sysKc 课程对象
	 */
	public void modifyKecheng(SysKc sysKc);

	/**
	 * 删除课程
	 * @param sysKc 课程对象
	 */
	public void deleteKecheng(SysKc sysKc);

	/**
	 * 通过id获取课程信息
	 * @param id 课程代码
	 * @return 返回课程对象
	 */
	public SysKc getKechengById(String id);

	public List<SysKc> getAllListByKclb(String kclbdm);

	public List<SysKc> getKcListbyXy(String xydm, String kclbdm);

	public List<SysKc> searchKcList(String xydm, String kclbdm, int zt);

	public List<SysKc> getInitKcList(String kkbmid);

	/**
	 * 按条件字段cd模糊查询text
	 * @param cb 查询字段   1.按课程中文名称   2.系代码   3.课程代码   4.课程类别名称
	 * @param text 查询条件
	 * @return 课程列表
	 */
	public List<SysKc> getMHKcList(int cb, String text);

	/**
	 * 
	 * 获取10个课程
	 * @return 查询的课程列表
	 */
	public List<SysKc> get10SysKc();

	/**
	 * 通过学院代码或系代码获取按照规则生成的课程代码
	 * @param flag  标识是学院代码还是系代码
	 * @param dm 代码
	 * @return 按照规则生成课程代码前七位数
	 */
	public String recommendBydm(String flag, String dm);

	/**
	 * 
	 * 拒绝课程修改
	 * @param syskc 课程对象
	*/
	public void del(SysKc syskc);

	/**
	 * 是否已经存在指定的课程代码
	 * @param kcdm 课程代码
	 * @return 返回有(has)或者null
	 */
	public String IfContainKcdm(String kcdm);

	/**
	 * 获取变更过的课程
	 * @param xydm 学院代码
	 * @param kczwmc 学院中文名称
	 * @param state 课程状态
	 * @return 返回变更过的课程列表
	 */
	public List<SysKc> getKcListforbg(String xydm, String kczwmc, int state);

	/**
	 * 课程修改通过
	 * @param syskc 课程对象
	 */
	public void passforkcsh(SysKc syskc);

	/**
	 * 查询满足条件的课程
	 * @param all hql语句
	 * @return 返回课程列表
	 */
	public List<SysKc> kcSearch(String all);

	public void importKcjj(List<SysKc> kcList);
	
	/**
	 * 弃用指定课程代码的课程
	 * @param kcdm 课程代码
	 * @return 0 弃用成功    1 课程恢复正常
	 */
	public int depKc(String kcdm);
	//heyuqi 2016.6.8
	public SysKc getKechengByIdAndSfqy(String id);
	public List<SysKc> getByKcmcAndSfqy(String kczwmc);
 
}
