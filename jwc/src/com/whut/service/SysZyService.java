package com.whut.service;

import java.util.List;

import com.whut.pojo.SysZy;


public interface SysZyService {

	public List<SysZy> getzyListByXdm(String id);

	public List<SysZy> getzyListByXydm(String id);

	public List<SysZy> getAllZyList();

	public void modifyZy(SysZy sysZy);

	public String getZydmByXydm(String xydm);

	public void addZy(SysZy sysZy);

	public SysZy getZyByzydm(String zydm);

	public void deleteZy(String zydm);

	public String checkZydm(String zydm);

	public List<SysZy> WhSearch(String ssxydm, String zymc);

	public List<SysZy> getzyListByxydm(String xydm);
}
