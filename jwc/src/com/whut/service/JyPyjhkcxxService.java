package com.whut.service;

import java.util.List;



import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.pojo.JyPyjhkcxx;
import com.whut.pojo.JyZyfx;
import com.whut.pojo.SysKc;

public interface JyPyjhkcxxService {
	
	public List<pyjhkcxxZhcxObj> pyjhkcxxZhcx(String whatString,
			String whereString);

	/**
	 * 逻辑删除jxjhh所有的课程
	 * */
	public void delJyPyjhkcxxByJxjhh(String jxjhh);
	
	public List<JyPyjhkcxx> getZypyKcByjxjhhAndKcmc(String jxjhh, String kcmc);
	
	public List<JyPyjhkcxx> getZypyKcByjxjhh(String jxjhh);
}
