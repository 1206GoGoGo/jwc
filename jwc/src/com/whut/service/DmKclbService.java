package com.whut.service;

import java.util.List;

import com.whut.pojo.DmKclb;


public interface DmKclbService {
	public void addDkclb(DmKclb sysKclb);

	public List<DmKclb> getAllList();

	public String getKclbdm();

	public void modifyKclb(DmKclb sysKclb);

	public void deleteKclb(DmKclb sysKclb);

	public int getIndex(String kclbdm);

	public String checkKclbdm(String kclbdm);

	public void setZt(String Kclbdm);

	public DmKclb getkclbBykclbdm(String kclbdm);
}
