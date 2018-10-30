package com.whut.service;

import java.util.List;

import com.whut.pojo.DmKcxz;
import com.whut.pojo.DmXklb;


public interface DmXklbService {

	public List<DmXklb> getAllList();
	
	public DmXklb getXklbById(String xklbdm);

	public String getXklbdm();

	public void deleteXklb(DmXklb dmXklb);

	public void addXklb(String xklbdm);

	public void modifyXklb(DmXklb dmXklb);

	public String checkXklbdm(String xklbdm);

	public void addDxklb(DmXklb sysXklb);

}
