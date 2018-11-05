package com.whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyKcmk;
import com.whut.service.JyKcmkService;


@Service
public class JyKcmkServiceImpl implements JyKcmkService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public void deleteMse(JyKcmk jyKcmk) {
		dao.modify(jyKcmk);
	}

	// 20130629

	@Override
	public void addKcmkInfo(JyKcmk obj) {
		dao.add(obj);
	}

	@Override
	public List<JyKcmk> getAllListByKCZID(int kczid) {
		String hql = "from JyKcmk as n where n.jyKcz.id='" + kczid
				+ "'and n.zt=1";
		return dao.search(hql);
	}

	@Override
	public void modAkcmk(JyKcmk jyKcmk) {
		// TODO Auto-generated method stub
		dao.modify(jyKcmk);
	}

	@Override
	public JyKcmk getKcmkByKcmkId(int id) {
		String hql = new String();
		hql = "from JyKcmk as n where n.zt=1 and n.id=" + id;
		JyKcmk KcmkObj = (JyKcmk) dao.getObject(hql);
		return KcmkObj;
	}
	
	@Override
	public boolean hasKc(JyKcmk kcmk) {
		Long count1 = dao
				.count("select count(*) from JyPyjhkcxx as n where n.jyKcmk.id = "
						+ kcmk.getId() + " and n.zt = 1");
		return count1.intValue() >= 1;
	}

}
