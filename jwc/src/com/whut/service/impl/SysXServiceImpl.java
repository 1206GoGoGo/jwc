package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.SysX;
import com.whut.service.SysXService;

@Service
public class SysXServiceImpl implements SysXService {
	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public void addDxdm(SysX sysX) {
		dao.add(sysX);
	}

	@Override
	public String checkXdm(String xdm) {
		String hql = "from SysX";
		List<SysX> list = dao.search(hql);
		Iterator<SysX> it = list.iterator();
		while (it.hasNext()) {
			SysX all = it.next();
			if (all.getXdm().equals(xdm)) {
				return "exist";
			}
		}
		return "noexist";
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SysX> getAllList() {
		String hql = "from SysX as n where n.zt=1 order by xmc ASC";
		return dao.search(hql);
	}

	@Override
	public int getIndex(String xdm) {
		@SuppressWarnings("unchecked")
		List<SysX> list = dao
				.search("from SysX as n where n.zt=1 order by xmc  ASC");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getXdm().equals(xdm)) {

				return i;
			}
		}
		return -1;
	}

	@Override
	public List<SysX> getListByxydm(String xydm) {
		String hql = "from SysX as n where n.zt=1 and n.sysXy.xydm='" + xydm
				+ "'";
		return dao.search(hql);
	}

	@Override
	public void modifyX(SysX sysX) {
		dao.modify(sysX);
	}

	@Override
	public void deleteX(String xdm) {
		SysX sysX = (SysX) dao.getObject("from SysX as n where n.xdm='" + xdm
				+ "'");
		sysX.setZt("0");
		dao.modify(sysX);
	}

	@Override
	public String getXdmByxydm(String xydm) {
		List<SysX> list = dao.search("from SysX as n where  n.sysXy.xydm='"
				+ xydm + "'");
		int max = 0;
		String xdm = "";
		for (int i = 0; i < list.size(); i++) {
			xdm = list.get(i).getXdm();
			if (max < Integer.parseInt(xdm)) {
				max = Integer.parseInt(xdm);
			}
		}
		return String.valueOf(max + 1);
	}

	@Override
	public void setZt(String xdm) {
		SysX sysX = (SysX) dao.getObject("from SysX as n where n.xdm='" + xdm
				+ "'");
		sysX.setZt("3");
		dao.modify(sysX);
	}

	@Override
	public SysX getxyByxdm(String xdm) {
		String hql = "from SysX as n where n.xdm='" + xdm + "'";
		return (SysX) dao.getObject(hql);
	}

}
