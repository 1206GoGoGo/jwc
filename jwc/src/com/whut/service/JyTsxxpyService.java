package com.whut.service;

import java.util.List;

import com.whut.pojo.JyTsxxpy;

import com.whut.pojo.SysKc;

public interface JyTsxxpyService {
	// 按学院，年级查询 2012计算机通识培养计划表


	public List<JyTsxxpy> searchxvsn1(String xydm, String nj);

	public List<JyTsxxpy> getTsInitList();
	
	public List<JyTsxxpy> gettspykcByXyNjMc(String xydm, String tsxxpydm,
			String kcmc);
	
	

	public List<JyTsxxpy> searchxvsn(String xydm, String nj);

	public void delJyTsxxpy(JyTsxxpy jyTsxxpy);

	public List<JyTsxxpy> getList();

	

	// public List<JyTsxxpy> getPyjhBytsxxpydm(String tsxxpydm);

	public List<SysKc> getLListById(String tsxxpydm, String xydm);

	public List<SysKc> getRListById(String tsxxpydm, String xydm);

	public List<JyTsxxpy> getTsxxpyjhByTsxxpydm(String tsxxpydm);

	public void addJyTsxxpy(JyTsxxpy jyTsxxpy);

	public JyTsxxpy getPyjhById(String id);

	

	public List<SysKc> getLListById(String tsxxpydm);

	public List<SysKc> getRListById(String tsxxpydm);

	

	public List<JyTsxxpy> searchxvsn2(String xq, String nj);

	public void modifyTsxxpy(JyTsxxpy jyTsxxpy);

	public List<JyTsxxpy> getJyTsxxpyList(String tsxxpydm);

	public List<SysKc> getLListByNjXy(String xydm, String nj);

	public List<SysKc> getRListByNjXy(String xydm, String nj);

	public List<JyTsxxpy> getTsxxpyListByXyNj(String xydm, String nj);


	public List<String> getTsxxpyListByXydm(String xydm);

	public List<JyTsxxpy> getPyjhByxy(String xydm);

	public List<JyTsxxpy> getPyjhBytsdmAndnj(String tsdm, String nj);

	public List<SysKc> getMHKcList(int cb, String text, String tsxxpydm);

	public List<SysKc> getMHKcList1(int cb, String text, String tsxxpydm);

	public List<JyTsxxpy> getAllList();

	public List<JyTsxxpy> getAllTspyjhList(); // /

	public List<JyTsxxpy> getTsxxpyListBynj(String nj);

	public List<JyTsxxpy> getListByNj(String nj);

	public void shpasstspyjh(String kcdm, String tsdm, String nj);

	public JyTsxxpy getpassTskc(String kcdm, String tsdm);

	public List<JyTsxxpy> getTsxxpydm();

	public List<JyTsxxpy> getXkc1(String nj);

	public List<JyTsxxpy> getXkc(String nj);

	public JyTsxxpy getXkcxx(String nj, String kcmc);

	public JyTsxxpy getJkcxx(String nj, String kcmc);

	public JyTsxxpy getkcxx(String nj, String kcmc);

	public List<JyTsxxpy> getListByNj1(String nj);

	public List<JyTsxxpy> getListBynj(String nj);

	public List<JyTsxxpy> getListByNj2(String nj);

	public JyTsxxpy getkcByKcdm(String kcdm);

	public List<JyTsxxpy> getTsxxpyListforxg(String nj);

	public void del(JyTsxxpy jyTsxxpy);

	public JyTsxxpy gettskcbykcmcidzt(String nj, String kczwmc, int zt);

	public List<JyTsxxpy> getTsxxpyListBynj1(String nj);

	public JyTsxxpy getpassTskc(String kcdm, String tsdm, int zt);

	public JyTsxxpy getTsByNjAndMc(String nj, String kczwmc);

	public boolean hasKcInNj(String kcdm, String nj);

}
