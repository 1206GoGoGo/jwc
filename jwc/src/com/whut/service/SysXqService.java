package com.whut.service;

import java.util.List;
import com.whut.pojo.SysXq;


public interface SysXqService {
	public void addDxqdm(SysXq sysXq);

	public List<SysXq> getAllList();

	public void modifyXq(SysXq sysXq);

	public void deleteXq(String xqdm);

	public String getXqdm();

	public String checkXqdm(String xqdm);

	public SysXq getXqByXqdm(String xqdm);
}
