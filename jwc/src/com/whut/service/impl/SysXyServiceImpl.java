package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.SysXy;
import com.whut.service.SysXyService;

@Service
public class SysXyServiceImpl implements SysXyService {
	
	@Autowired
	private BaseHibernateDAO dao;


	public void addXy(SysXy sysXy) {
		dao.add(sysXy);
	}

	public String checkXydm(String xydm) {
		String hql = "from SysXy order by xydm ASC";
		List list = dao.search(hql);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			SysXy all = (SysXy) it.next();
			if (all.getXydm().equals(xydm)) {
				return "exist";
			}
		}
		return "noexist";

	}

	@SuppressWarnings("unchecked")
	public List<SysXy> getAllList() {
		String hql = "from SysXy as n where n.zt=1 order by xymc ASC";
		return dao.search(hql);
	}


	public void modifyXy(SysXy sysXy) {
		dao.modify(sysXy);
	}

	public void deleteXy(SysXy sysXy) {
		sysXy.setZt(0);
		dao.modify(sysXy);
	}

	public SysXy getXyIdByMc(String name) {
		String hql = "from SysXy as n where n.xymc like '%" + name + "%'";
		return (SysXy) dao.getObject(hql);
	}

	public SysXy getXyById(String id) {
		String hql = "from SysXy as n where n.xydm = '" + id + "'";
		return (SysXy) dao.getObject(hql);
	}

	public int getCount(Class clazz, String param) {
		return dao.getSize(clazz, param);
	}

	public List getLimitCount(int start, int pageSize) {
		return dao.getLimitObjects(SysXy.class, start, pageSize);
	}

	public String getXymcById(String id) {
		String hql = "from SysXy as n where n.xydm ='" + id + "' and zt=1";
		SysXy sysXy = null;
		sysXy = (SysXy) dao.getObject(hql);
		String xymc = sysXy.getXymc();
		return xymc;
	}

	public List<SysXy> getxylistbymc(String xymc) {
		String hql = "from SysXy as n where n.xymc like '%" + xymc + "%'";
		return dao.search(hql);
	}
}
