package com.whut.service;

import java.util.List;

import com.whut.pojo.JyXxtx;

public interface JyXxtxService {

	List<JyXxtx> getXxtxByjsf(String jsf, String sj1, String sj2);
	
	List<JyXxtx> getListByjsf(String xymc);
	
	void afterviewMse(JyXxtx jyXxtx);
	
	JyXxtx getXxtxByxxdm(int xxdm);
	
	JyXxtx getdelXxtxByxxdm(String xxdm);

	void deleteMse(JyXxtx jyXxtx);
	
	List<JyXxtx> getListByfsf(String xymc);
	
	List<JyXxtx> getXxtxByfsf(String fsf, String sj1, String sj2);

	List<JyXxtx> getdelXxtxByfsforjsf(String fsf, String sj1, String sj2);

	List<JyXxtx> getdelListByfsforjsf(String xymc);

	void RealDeleteMse(JyXxtx jyXxtx);

	List<JyXxtx> getAllList();
	
	public void addXxtx(JyXxtx jyXxtx);

	
}
