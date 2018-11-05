package com.whut.service;

import java.util.List;

import com.whut.pojo.JyPyjhkcxx;
import com.whut.pojo.JyZyfx;
import com.whut.pojo.SysKc;
import com.whut.pojo.pyjhkcxxZhcxObj;


public interface JyPyjhkcxxService {
	public void addJyPyjhkcxx(JyPyjhkcxx jyPyjhkcxx);

	public void delete(JyPyjhkcxx jyPyjhkcxx);

	public List<JyPyjhkcxx> getKcxxListbyJhjhh(String jxjhh);

	public List<SysKc> getRListById(String jxjhh, String kclbdm);// dsjfsof

	public List<SysKc> getLListById(String jxjhh, String kclbdm);// dsjfsof

	public List<JyPyjhkcxx> getPyjhkcbyjxjhhandkclb(String jxjhh, String kclbdm);

	public void modify(JyPyjhkcxx jyPyjhkcxx);

	public List<JyPyjhkcxx> getZypyKcByjxjhhOrKcm(String jxjhh, String kcmc);

	public List<JyPyjhkcxx> getPyjhkcbyjxjhh(String jxjhh);

	public List<JyPyjhkcxx> getPyjhkcbyjxjhhzt6(String jxjhh);

	public List<JyPyjhkcxx> getMHKcList(int cb, String text);

	public List<SysKc> getgxkcByjxjhhAndkcmc(String jxjhh, String kcmc);

	public JyPyjhkcxx getkcByKcdm(String kcdm);

	public List<JyPyjhkcxx> getXkc(String jxjhh);

	public JyPyjhkcxx getkcxx(String jxjhh, String kcmc);

	public JyPyjhkcxx getKcxx(String jxjhh, String kcdm);

	public JyPyjhkcxx getJkcxx(String jxjhh, String kcmc);

	public List<JyPyjhkcxx> getxtkc();

	public List<JyPyjhkcxx> getxzkc(String kczwmc);

	public List<JyPyjhkcxx> getgxkc(String xydm, String zydm, String nj);

	public List<JyPyjhkcxx> gettmlist();

	public List<JyPyjhkcxx> search1(String xydm, String zydm, String nj);

	public List<JyPyjhkcxx> getPyjhkcbyjxjhhforxg(String jxjhh);

	public JyPyjhkcxx getzykcbykcmcjxjhhzt(String jxjhh, String kczwmc, int zt);

	public List<JyPyjhkcxx> getPyjhkcbyjxjhhzt16(String wjjxjhh, String jxjhh);

	public List<JyPyjhkcxx> getPyjhkcxx(String jxjhh);

	public List<JyPyjhkcxx> getPyjhkcxx(String jxjhh, int jykkxq);

	public List<JyPyjhkcxx> getPyjhkcxx(String jxjhh, int jykkxq1, int jykkxq2);

	public List<JyPyjhkcxx> getPyjhkcxx1(String jxjhh);

	public List<JyPyjhkcxx> search(String jxjhh, int xq);

	public List<JyPyjhkcxx> getZypyKcByjxjhh(String jxjhh);

	public List<JyPyjhkcxx> getZypyKcByjxjhhAndKcmc(String jxjhh, String kcmc);

	public List<JyPyjhkcxx> getkcxxByJxjhhAndZt(String jxjhh);

	public List<JyPyjhkcxx> getKcxx1(String jxjhh, String kcdm);

	public JyPyjhkcxx getPyjhkcxxById(int Bid);

	public List<JyPyjhkcxx> getPyjhkcxxByAll(String xydm, String zydm,
			String nj, String selectedxq);

	public List<String> getPyjhkcxxBydistinct(String xydm, String nj,
			String kkxq);

	/*
	 * 导出培养计划号为jxjhh、建议开课学期为xq的课程信息，按照pxfs的方式输出List
	 */
	public List<JyPyjhkcxx> getPyjhkcxxFrompldyExport(String jxjhh, String xq,
			String pxfs);

	/**
	 * 培养计划课程信息综合查询
	 * */
	public List<pyjhkcxxZhcxObj> pyjhkcxxZhcx(String whatString,
			String whereString);

	/**
	 * 拷贝课程
	 * */
	public void copy(String xjxjhh, JyPyjhkcxx jyPyjhkcxx);

	/**
	 * 参数：学院代码 xydm:为"0"表示任意学院 专业代码：zydm：为"0"表示任意专业 年级：nj为"0"表示任意学年
	 * 学期：xq：1、2、3、4、5、6、7、8组成的字符串
	 * */
	public List<JyPyjhkcxx> search(String xydm, String zydm, String nj,
			String xq);

	public int countPyjhkcxxActiveInZyfx(String zyfxdm);

	public int countPyjhkcxxInZyfx(String zyfxdm);

	/**
	 * 逻辑删除jxjhh所有的课程
	 * */
	public void delJyPyjhkcxxByJxjhh(String jxjhh);

	/**
	 * 置某专业方向相关的培养计划课程信息的专业方向代码字段为null
	 * */
	public void setZyfxNullByZyfx(JyZyfx obj);
	/*
	 * 获取该们课程的先修课程
	 */
	public List<JyPyjhkcxx> getXxkcList(JyPyjhkcxx jyPyjhkcxx);

}
