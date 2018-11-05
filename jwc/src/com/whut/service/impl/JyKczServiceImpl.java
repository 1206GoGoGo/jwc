package com.whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyKcz;
import com.whut.service.JyKczService;

@Service
public class JyKczServiceImpl implements JyKczService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public List<JyKcz> getAllListByjxjhh(String jxjhh) {
		String hql = "from JyKcz as n where n.jxjhh='" + jxjhh + "' and n.zt=1";
		return dao.search(hql);
	}

	@Override
	public void addKczInfo(JyKcz obj) {
		dao.add(obj);
	}

	@Override
	public JyKcz getKczBykczdm(String kczdm) {
		String hql = "from JyKcz as n where n.kczdm='" + kczdm + "'";
		JyKcz jyKcz = (JyKcz) dao.getObject(hql);
		return jyKcz;

	}

	@Override
	public void deleteMse(JyKcz jyKcz) {
		dao.modify(jyKcz);
	}


	@Override
	public void modAkcz(JyKcz obj) {
		dao.modify(obj);
	}

	@Override
	public boolean hasMK(JyKcz kcz) {
		Long count1 = dao
				.count("select count(*) from JyKcmk as n where n.kczid = "
						+ kcz.getId() + " and n.zt = 1");
		return count1.intValue() >= 1;
	}

}
