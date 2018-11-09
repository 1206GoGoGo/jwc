package com.whut.service;

import java.util.List;
import java.util.Map;

import com.whut.pojo.JyZyfx;

public interface JyZyfxService {
	public List<JyZyfx> getAllListByzydm(String zydm);

	public JyZyfx getJyZyfxByall(String zyfxdm, String zydm, String nj);

	public JyZyfx getJyZyfxBydm(String zyfxdm);

	public List<JyZyfx> getAllListByzydm(String zydm, String nj);

	public Map getAllListByZydmAndNj(String nj);

	public List<JyZyfx> getAllListByNj(String nj);

	public List<JyZyfx> getAllList();

	public void modify(JyZyfx obj);

	public void delete(JyZyfx obj);

	public void add(JyZyfx obj);

	/**
	 * 获取某专业所有的专业方向的《代码、名称》对应
	 * */
	public List<JyZyfx> getZyfxMapByZydm(String zydm);

}
