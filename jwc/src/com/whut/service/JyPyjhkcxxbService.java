package com.whut.service;

import java.util.List;

import com.whut.pojo.JyPyjhkcxxb;
import com.whut.pojo.JyZyfx;


public interface JyPyjhkcxxbService {

	public List<JyPyjhkcxxb> getAllByjxjhh(String jxjhh);

	public void modify(JyPyjhkcxxb jyPyjhkcxxb);

	public void delete(JyPyjhkcxxb jyPyjhkcxxb);

	public List<JyPyjhkcxxb> getXkc(String jxjhh);

	public JyPyjhkcxxb getXkcxx(String jxjhh, String kcmc);

	public JyPyjhkcxxb getkcxx(String jxjhh, String kcmc);

	public List<JyPyjhkcxxb> getbyjxjhh(String jxjhh);

	/**
	 * 逻辑删除jxjhh所有的课程
	 * */
	public void delJyPyjhkcxxbByJxjhh(String jxjhh);

	/**
	 * 置某专业方向相关的培养计划备用表课程信息的专业方向代码字段为null
	 * */
	public void setZyfxNullByZyfx(JyZyfx obj);

}
