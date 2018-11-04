package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyXxgs;
import com.whut.service.JyXxgsService;

@Service
public class JyXxgsServiceImpl implements JyXxgsService {
	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public void addXxgs(JyXxgs jyXxgs) {
		dao.add(jyXxgs);
	}

	@Override
	public String checkXxgsdm(String xxgsdm) {
		String hql = "from JyXxgs";
		List list = dao.search(hql);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String all = (String) it.next();
			if (all.equals(xxgsdm)) {
				return "exist";
			}
		}
		return "noexist";
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<JyXxgs> getAllList() {
		String hql = "from JyXxgs  as n where n.zt=1 order by xxgsdm ASC ";
		return dao.search(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getXxgsdm() {
		List<JyXxgs> list = dao.search("from JyXxgs ");
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			String xxgsdm = list.get(i).getXxgsdm();
			if (max < Integer.parseInt(xxgsdm)) {
				max = Integer.parseInt(xxgsdm);
			}

		}
		return String.valueOf(max + 1);

	}

	@Override
	public void modifyXxgs(JyXxgs jyXxgs) {
		dao.modify(jyXxgs);
	}

	@Override
	public void deleteXxgs(String xxgsdm) {
		JyXxgs jyXxgs = (JyXxgs) dao
				.getObject("from JyXxgs as n where n.xxgsdm='" + xxgsdm + "'");
		jyXxgs.setZt(0);
		dao.modify(jyXxgs);
	}

	@Override
	public JyXxgs getxxgsbyid(String xxgsdm) {
		String hql = "from JyXxgs as n where n.xxgsdm = '" + xxgsdm + "'";
		return (JyXxgs) dao.getObject(hql);
	}

}
