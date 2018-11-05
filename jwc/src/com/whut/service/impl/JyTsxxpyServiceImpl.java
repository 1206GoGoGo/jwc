package com.whut.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyTsxxpy;
import com.whut.service.JyTsxxpyService;


@Service
public class JyTsxxpyServiceImpl implements JyTsxxpyService {
	
	@Autowired
	private BaseHibernateDAO dao;
	
	@Override
	public List<JyTsxxpy> searchxvsn1(String xydm, String nj){
		new String();
		List<JyTsxxpy> list = new ArrayList();
		List<JyTsxxpy> temp = new ArrayList();
		JyTsxxpy jyTsxxpy = new JyTsxxpy();
		if (xydm.equals("0") && nj.equals("0")) {
			list = getTsInitList();
		} else if (!xydm.equals("0") && nj.equals("0")) {
			temp = getTsInitList();
			for (int i = 0; i < temp.size(); i++) {
				jyTsxxpy = temp.get(i);
				if (jyTsxxpy.getSysXy().getXydm().equals(xydm)) {
					list.add(jyTsxxpy);
				}
			}
		} else if (xydm.equals("0") && !nj.equals("0")) {
			temp = getTsInitList();
			for (int i = 0; i < temp.size(); i++) {
				jyTsxxpy = temp.get(i);
				if (jyTsxxpy.getTsxxpydm().equals(nj)) {
					list.add(jyTsxxpy);
				}
			}
		} else if (!xydm.equals("0") && !nj.equals("0")) {
			jyTsxxpy = (JyTsxxpy) dao
					.getObject("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.id=(select min(id) from JyTsxxpy as m where m.tsxxpydm='"
							+ nj + "' and m.sysXy.xydm='" + xydm + "')");
			list.add(jyTsxxpy);
		}
		return list;
	}
	
	@Override
	public List<JyTsxxpy> getTsInitList() {
		@SuppressWarnings("rawtypes")
		List listtemp = dao
				.search("select distinct tsxxpydm,sysXy.xydm from JyTsxxpy order by tsxxpydm desc");
		@SuppressWarnings("unchecked")
		List<JyTsxxpy> list = new ArrayList();
		List<JyTsxxpy> list0 = new ArrayList();
		Iterator it = listtemp.iterator();
		while (it.hasNext()) {
			Object[] ob = (Object[]) it.next();
			String tsxxpydm = (String) ob[0];
			String xydm = (String) ob[1];
			System.out.print("tsxxpydm：" + tsxxpydm + "xydm：" + xydm);
			String hql = "from JyTsxxpy as n where n.tsxxpydm='" + tsxxpydm
					+ "' and n.sysXy.xydm='" + xydm
					+ "' and n.zt!=5 and n.zt!=2 and n.zt!=0";
			list0 = dao.search(hql);
			if (list0.size() != 0) {
				list.add(list0.get(0));
			}
		}
		return list;
	}

	@Override
	public List<JyTsxxpy> gettspykcByXyNjMc(String xydm, String tsxxpydm,
			String kcmc) {
		if (kcmc.equals("")) {
			String hql = "from JyTsxxpy as n where n.sysXy.xydm='" + xydm
					+ "' and n.tsxxpydm = '" + tsxxpydm
					+ "' and n.zt!=5 and n.zt!=2 and n.zt!=0";
			List<JyTsxxpy> list = dao.search(hql);
			return list;
		} else {
			String hql = "from JyTsxxpy as n where n.sysXy.xydm='" + xydm
					+ "' and n.tsxxpydm = '" + tsxxpydm
					+ "' and n.sysKc.kczwmc like '%" + kcmc
					+ "%' and n.zt!=5 and n.zt!=2 and n.zt!=0";
			List<JyTsxxpy> list = dao.search(hql);
			return list;
		}
	}

	
	
}
