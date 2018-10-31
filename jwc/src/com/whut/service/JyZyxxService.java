package com.whut.service;

import java.util.List;

import com.whut.pojo.JyZyxx;


public interface JyZyxxService {
	public void addZyxx(JyZyxx jyZyxx);

	public List<JyZyxx> search(String xydm, String xqdm, String nj);

	public List<JyZyxx> search(String xydm, String xqdm, String nj, String ZT);

	public List<JyZyxx> getAllList();

	public JyZyxx getZyxxListByjxjhh(String id);

	public void modifyZyxx(JyZyxx jyZyxx);

	public void deleteZyxx(String zyxxdm);

	public List<JyZyxx> MHsearch(int Tj, String text);

	public List<JyZyxx> getZyxxListByNj(String nj);

	public String checkJxjhh(String jxjhh);

	public JyZyxx getZyxx(String jxjhh);
	
	public void deleteZt2();
}