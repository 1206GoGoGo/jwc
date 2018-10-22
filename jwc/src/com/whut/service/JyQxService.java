package com.whut.service;

import java.math.BigDecimal;
import java.util.List;

import com.whut.pojo.JyQx;
import com.whut.pojo.JyYhqx;
import com.whut.pojo.SysJs;
import com.whut.pojo.SysJwyh;

public interface JyQxService {

	public List<SysJs> search(String xm);

	public List<SysJs> getAll();

	public List<SysJwyh> search_JW(String xm);

	public List<SysJwyh> searchAll_JW();

	public List<JyQx> getAllqx();

	public List<JyYhqx> getyhID(String yhid);

	public void mofifyQX(String yhid, BigDecimal jyQx);

	public void mofifyJY_YHqX(JyYhqx jyYhqx);

	public void updateQX();
	
	public void addQx(JyYhqx jyYhqx);
}
