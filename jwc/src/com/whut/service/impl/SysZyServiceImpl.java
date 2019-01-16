package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.SysZy;
import com.whut.service.SysZyService;

@Service
public class SysZyServiceImpl implements SysZyService {

	@Autowired
	private BaseHibernateDAO dao;
	
	@Override
	public List<SysZy> getzyListByXdm(String id) {
		String hql = "from SysZy as n where n.sysX.xdm='" + id + "'";
		return dao.search(hql);
	}

	@Override
	public List<SysZy> getzyListByXydm(String id) {
		List<SysZy> list;
		String hql;
		if (id.equals("0")) {
			hql = "from SysZy";
		} else {
			hql = "from SysZy as n where n.xydm='" + id + "'";
		}
		list = dao.search(hql);
		return list;
	}

	@Override
	public List<SysZy> getAllZyList() {
		String hql = "from SysZy as n where n.zt!=0 order by zymc ASC";
		return dao.search(hql);
	}

	@Override
	public String checkZydm(String zydm) {
		String hql = "from SysZy";
		List list = dao.search(hql);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			SysZy all = (SysZy) it.next();
			if (all.getZydm().equals(zydm)) {
				return "exist";
			}

		}
		return "noexist";
	}

	@Override
	public void modifyZy(SysZy sysZy) {
		dao.modify(sysZy);
	}

	public String getZydmByXydm(String xydm) {
		String hql = "from SysZy as n where n.xydm='" + xydm + "'";
		List<SysZy> list = dao.search(hql);

		String last = "0";
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			last = list.get(i).getZydm();
			char[] b = last.toCharArray();
			int c = b[3];
			if (max < c)
				max = c;
			System.out.printf(i + ":" + c + "------");
		}
		char d = (char) (max + 1);

		String e = xydm.substring(0, 3) + String.valueOf(d);
		return e;
	}

	@Override
	public void addZy(SysZy sysZy) {
		dao.add(sysZy);
	}

	@Override
	public SysZy getZyByzydm(String zydm) {
		String hql = "from SysZy as n where n.zydm='" + zydm + "'";
		SysZy sysZy = (SysZy) dao.getObject(hql);
		return sysZy;
	}

	@Override
	public void deleteZy(String zydm) {
		SysZy sysZy = (SysZy) dao.getObject("from SysZy as n where n.zydm='"
				+ zydm + "' and n.zt=1");
		sysZy.setZt(0);
		dao.modify(sysZy);
	}

	@Override
	public List<SysZy> WhSearch(String ssxydm, String zymc) {
		String hql = "";
		if (ssxydm.equals("0") && zymc == "") {
			hql = "from SysZy as n where n.zt=1 order by zymc ASC";
		} else if (!ssxydm.equals("0") && zymc == "") {
			hql = "from SysZy as n where n.xydm='" + ssxydm
					+ "' and n.zt=1 order by zymc ASC";
		} else if (ssxydm.equals("0") && zymc != "") {
			hql = "from SysZy as n where n.zymc like '%" + zymc
					+ "%' and n.zt=1 order by zymc ASC";
		} else if (!ssxydm.equals("0") && zymc != "") {
			hql = "from SysZy as n where n.zymc like '%" + zymc
					+ "%' and n.xydm='" + ssxydm
					+ "' and n.zt=1 order by zymc ASC";
		}
		List<SysZy> list = dao.search(hql);
		return list;
	}

	@Override
	public List<SysZy> getzyListByxydm(String id) {
		List<SysZy> list;
		String hql;
		if (id.equals("0")) {
			hql = "from SysZy";
		} else {
			hql = "from SysZy as n where n.xydm='" + id + "' and n.zt=1";
		}
		list = dao.search(hql);
		return list;
	}
}
