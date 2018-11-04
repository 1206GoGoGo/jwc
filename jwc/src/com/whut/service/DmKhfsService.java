package com.whut.service;

import java.util.List;

import com.whut.pojo.DmKhfs;


public interface DmKhfsService {
	public void addDkhfs(DmKhfs sysKhfs);

	public List<DmKhfs> getAllList();

	public String getKhfsdm();

	public void modifyKhfs(DmKhfs sysKhfs);

	public void deleteKhfs(DmKhfs sysKhfs);

	public String checkKhfsdm(String khfsdm);

	public DmKhfs getDmKhfsBydm(String khfsdm);

}
