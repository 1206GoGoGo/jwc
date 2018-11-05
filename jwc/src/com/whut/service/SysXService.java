package com.whut.service;

import java.util.List;

import com.whut.pojo.SysX;


public interface SysXService {

	public void addDxdm(SysX sysX);

	public List<SysX> getAllList();

	public List<SysX> getListByxydm(String xydm);

	public void modifyX(SysX sysX);

	public void deleteX(String xdm);

	public String getXdmByxydm(String xydm);

	public int getIndex(String xdm);

	public String checkXdm(String xdm);

	public void setZt(String xdm);

	public SysX getxyByxdm(String xdm);

}
