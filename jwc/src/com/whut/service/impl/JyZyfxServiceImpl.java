package com.whut.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyZyfx;
import com.whut.service.JyZyfxService;


@Service
public class JyZyfxServiceImpl implements JyZyfxService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public List<JyZyfx> getAllListByzydm(String zydm) {
		String hql = "from JyZyfx as n where n.sysZy.zydm='" + zydm + "'";
		return dao.search(hql);
	}

	@Override
	public JyZyfx getJyZyfxByall(String zyfxdm, String zydm, String nj) {
		String hql = "from JyZyfx as n where n.zyfxdm='" + zyfxdm
				+ "' and n.sysZy.zydm='" + zydm + "' and n.nj='" + nj
				+ "' and n.zt=1";
		JyZyfx yZyfx = (JyZyfx) dao.getObject(hql);
		return yZyfx;
	}

	@Override
	public JyZyfx getJyZyfxBydm(String zyfxdm) {
		String hql = "from JyZyfx as n where n.zyfxdm='" + zyfxdm + "'";
		JyZyfx yZyfx = (JyZyfx) dao.getObject(hql);
		return yZyfx;
	}

	@Override
	public List<JyZyfx> getAllListByzydm(String zydm, String nj) {
		String hql = "from JyZyfx as n where n.sysZy.zydm = '" + zydm + "' and n.nj = '" + nj + "' and n.zt=1";
		return dao.search(hql);
	}

	@Override
	public Map getAllListByZydmAndNj(String nj) {
		String hql = "from JyZyfx as n where n.nj='" + nj + "'";
		List<JyZyfx> zyfxList = dao.search(hql);
		Iterator it = zyfxList.iterator();
		Map map = new HashMap();
		while (it.hasNext()) {
			JyZyfx aa = (JyZyfx) it.next();
			map.put(aa.getZyfxdm(), aa.getZyfxzwmc());
		}
		return map;
	}

	@Override
	public List<JyZyfx> getAllListByNj(String nj) {
		String hql = "from JyZyfx as n where n.nj='" + nj + "'";
		List<JyZyfx> zyfxList = dao.search(hql);
		return zyfxList;
	}

	@Override
	public List<JyZyfx> getAllList() {
		String hql = "from JyZyfx as n where n.zt=1";
		List<JyZyfx> zyfxList = dao.search(hql);
		return zyfxList;
	}

	@Override
	public void delete(JyZyfx obj) {
		String hql = "delete from JyZyfx where zyfxdm = '" + obj.getZyfxdm()
				+ "' and nj = '" + obj.getNj() + "' and sysZy.zydm = '"
				+ obj.getSysZy().getZydm() + "'";
		dao.deleteByHql(hql);
	}

	@Override
	public void modify(JyZyfx obj) {
		dao.modify(obj);
	}

	@Override
	public void add(JyZyfx obj) {
		dao.add(obj);
	}

	/**
	 * 获取某专业所有的专业方向的《代码、名称》对应
	 * */
	@Override
	public List<JyZyfx> getZyfxMapByZydm(String zydm) {
		List<JyZyfx> list = new ArrayList<JyZyfx>();
		String hql = "select n.zyfxdm , n.zyfxzwmc from JyZyfx as n where n.sysZy.zydm = '"
				+ zydm + "' and n.zt = 1 group by (n.zyfxdm,n.zyfxzwmc)";
		@SuppressWarnings("unchecked")
		List<Object[]> re = dao.search(hql);
		for (Object[] object : re) {
			JyZyfx o = new JyZyfx();
			String name = (String) object[0];
			String passwd = (String) object[1];
			o.setZyfxdm(name);
			o.setZyfxzwmc(passwd);
			list.add(o);
		}
		return list;
	}

	
}
