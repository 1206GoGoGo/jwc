package com.whut.service;

import java.util.List;

import com.whut.pojo.JyPyjhyq;


public interface JyPyjhyqService {
	public List<JyPyjhyq> getpyListByZydm(String id);

	public void addPyjhyqInfo(JyPyjhyq jyPyjhyq);

	// public List<JyPyjhyq> getpyListByXydm(String xydm);
	public JyPyjhyq getPyByJxjhh(String string);

	public List<JyPyjhyq> getAllList();

	public List<JyPyjhyq> getAll1346List();

	public List<JyPyjhyq> getpyListByXydm(String xydm);

	public List<JyPyjhyq> search(String xydm, String zydm, String nj);

	public List<JyPyjhyq> search(String zydm, String nj);

	public List<JyPyjhyq> MHsearch(int cb, String text);

	public void modifyPyjhyq(JyPyjhyq jyPyjhyq);

	public void updatePyjhyq(JyPyjhyq jyPyjhyq);

	public JyPyjhyq getPyBynj(String nj);

	public List<JyPyjhyq> getPyjhyqBynj(String nj);

	public List<JyPyjhyq> getPyjhyqByNj(String nj);

	public List<JyPyjhyq> search1346(String xydm, String zydm, String nj);

	public List<JyPyjhyq> getZt1356List();

	public void delAJyPyjhyq(String jxjhh);// 删除某专业培养计划要求

}
