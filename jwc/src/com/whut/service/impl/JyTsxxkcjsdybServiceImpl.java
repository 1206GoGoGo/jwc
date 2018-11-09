package com.whut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyTsxxkcjsdyb;
import com.whut.service.JyTsxxkcjsdybService;

@Service
public class JyTsxxkcjsdybServiceImpl implements JyTsxxkcjsdybService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	@SuppressWarnings("unchecked")
	public List<JyTsxxkcjsdyb> getAllList() {
		String hql = "from JyTsxxkcjsdyb as n where n.zt !=0";
		return dao.search(hql);
	}

	@Override
	public void addJyXzjs(JyTsxxkcjsdyb jytsxxkcjsdyb) {

		dao.add(jytsxxkcjsdyb);
	}

	@Override
	public void modify(JyTsxxkcjsdyb jytsxxkcjsdyb) {

		dao.modify(jytsxxkcjsdyb);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<JyTsxxkcjsdyb> GetKcJsList(int pyid) {
		String hql = "from JyTsxxkcjsdyb as n where n.zt != 0 and n.jyTsxxpy.id="
				+ pyid;
		List<JyTsxxkcjsdyb> list = dao.search(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JyTsxxkcjsdyb> getDyByxmAndkc(String kcmc, String jsxm) {
		String hql = "";
		List<JyTsxxkcjsdyb> list = new ArrayList<JyTsxxkcjsdyb>();

		if (kcmc.equals("") && jsxm.equals("")) {
			hql = "from JyTsxxkcjsdyb as n where n.zt !=0 order by zt desc";
		}

		if (!kcmc.equals("") && jsxm.equals("")) {
			hql = "from JyTsxxkcjsdyb as n where n.zt !=0 and n.jyTsxxpy.sysKc.kczwmc like '%"
					+ kcmc + "%' order by zt desc";
		}

		if (kcmc.equals("") && !jsxm.equals("")) {
			hql = "from JyTsxxkcjsdyb as n where n.zt !=0 and n.sysJs.xm like '%"
					+ jsxm + "%' order by zt desc";
		}

		if (!kcmc.equals("") && !jsxm.equals("")) {
			hql = "from JyTsxxkcjsdyb as n where n.zt !=0 and n.sysJs.xm like '%"
					+ jsxm
					+ "%' and n.jyTsxxpy.sysKc.kczwmc like '%"
					+ kcmc
					+ "%' order by zt desc";
		}

		list = dao.search(hql);

		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<JyTsxxkcjsdyb> GetThisKcJsList(String ThisKc, int pyid) {

		String hql = "from JyTsxxkcjsdyb as n where n.jyTsxxpy.id='" + pyid
				+ "'  and n.zt!= 0 and n.jyTsxxpy.sysKc.kczwmc='" + ThisKc
				+ "'";
		List<JyTsxxkcjsdyb> list = dao.search(hql);
		return list;
	}

}
