package com.whut.service;

import java.util.List;

import com.whut.pojo.DmKcxz;


public interface DmKcxzService {
	public void addDkcxz(DmKcxz sysKcxz);

	public List<DmKcxz> getAllList();
	
	public DmKcxz getKcxzById(String kcxzdm);//通过课程性质代码获取课程性质

	public String getKcxzdm();

	public void modifyKcxz(DmKcxz sysKcxz);

	public void deleteKcxz(DmKcxz sysKcxz);

	public String checkKcxzdm(String kcxzdm);
}
