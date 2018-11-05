package com.whut.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.SysKc;
import com.whut.service.SysKcService;

@Service
public class SysKcServiceImpl implements SysKcService {
	
	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public void modifyKecheng(SysKc sysKc) {
		dao.modify(sysKc);
	}

	
}
