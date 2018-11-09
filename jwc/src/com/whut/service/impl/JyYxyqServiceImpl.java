package com.whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyYxyq;
import com.whut.service.JyYxyqService;

@Service
public class JyYxyqServiceImpl implements JyYxyqService {

	@Autowired
	private BaseHibernateDAO dao;



	@Override
	public List<JyYxyq> getyxyqListByJxjhh(String jxjhh, String kcdm) {
		String hql = "from JyYxyq as n where n.yxyqdm='" + jxjhh
				+ "' and n.sysKcByKcdm.kcdm='" + kcdm + "'";
		return dao.search(hql);
	}

	@Override
	public void addJyYxyq(JyYxyq jyYxyq) {
		dao.add(jyYxyq);
	}

	@Override
	public List<JyYxyq> getxykcByyxdmAndKc(String yxyqdm, String kcdm) {
		String hql = "from JyYxyq as n where n.yxyqdm='" + yxyqdm
				+ "' and n.sysKcByKcdm.kcdm='" + kcdm + "'";
		return dao.search(hql);
	}
}
