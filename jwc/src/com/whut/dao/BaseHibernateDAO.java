package com.whut.dao;



import java.io.Serializable;
import java.util.List;

import com.whut.pojo.pyjhkcxxZhcxObj;

/**
 * Data access interface for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public interface BaseHibernateDAO {
	
	public void add(Object obj);

	public void modify(Object obj);

	public void delete(Object obj);

	public void deleteByHql(String hql);

	public Object getObject(Class clazz, Serializable id);

	public Object getObject(String hql);

	public List search(String sql);

	public List getObjects(Class clazz);

	public List getLimitObjects(Class clazz, int start, int pageSize);

	public int getSize(Class clazz, String param);

	public Long count(String hql);

	public Long getmaxid(String table, String idString);

	/**
	 * 培养计划课程信息综合查询
	 * */
	public List<pyjhkcxxZhcxObj> pyjhkcxxZhcx(String sql);

}