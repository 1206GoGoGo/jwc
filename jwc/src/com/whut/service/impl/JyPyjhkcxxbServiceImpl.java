package com.whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyPyjhkcxxb;
import com.whut.pojo.JyZyfx;
import com.whut.service.JyPyjhkcxxbService;

@Service
public class JyPyjhkcxxbServiceImpl implements JyPyjhkcxxbService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public void modify(JyPyjhkcxxb jyPyjhkcxxb) {
		dao.modify(jyPyjhkcxxb);
	}

	@Override
	public void delete(JyPyjhkcxxb jyPyjhkcxxb) {
		dao.delete(jyPyjhkcxxb);
	}

	@Override
	public List<JyPyjhkcxxb> getXkc(String jxjhh) {
		String hql = "from JyPyjhkcxxb as n where n.jxjhh='" + jxjhh
				+ "'  and (n.zt=2 or n.zt=6 or n.zt=0)";
		List<JyPyjhkcxxb> list = dao.search(hql);
		return list;
	}

	@Override
	public JyPyjhkcxxb getXkcxx(String jxjhh, String xkcdm) {
		String hql = new String();
		hql = "from JyPyjhkcxxb as n where n.jxjhh='" + jxjhh
				+ "' and n.sysKc.kcdm='" + xkcdm + "' and n.zt=2";
		return (JyPyjhkcxxb) dao.getObject(hql);
	}

	@Override
	public JyPyjhkcxxb getkcxx(String jxjhh, String xkcdm) {
		String hql = new String();
		hql = "from JyPyjhkcxxb as n where n.jxjhh='" + jxjhh
				+ "' and n.sysKc.kcdm='" + xkcdm + "' and (n.zt!=1 or n.zt!=2)";
		return (JyPyjhkcxxb) dao.getObject(hql);
	}

	/**
	 * 通过教学计划号jxjhh查找“培养计划课程信息”**备用表**里面的带审核课程List<JyPyjhkcxxb>
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public List<JyPyjhkcxxb> getbyjxjhh(String jxjhh) {
		String hql = "from JyPyjhkcxxb as n where n.jxjhh='" + jxjhh
				+ "' and (n.zt=0 or n.zt=2 or n.zt=6 )";
		List<JyPyjhkcxxb> list = dao.search(hql);
		return list;
	}

	/**
	 * 
	 * 
	 * */
	@Override
	public List<JyPyjhkcxxb> getAllByjxjhh(String jxjhh) {
		String hql = "from JyPyjhkcxxb as n where n.jxjhh='" + jxjhh
				+ "' and (n.zt=2 or n.zt=0 or n.zt=6 or n.zt=1) ";
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxxb> list = dao.search(hql);
		return list;
	}

	/**
	 * 逻辑删除jxjhh所有的课程
	 * */
	@Override
	public void delJyPyjhkcxxbByJxjhh(String jxjhh) {
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxxb> kcxxbList = dao
				.search("from JyPyjhkcxxb as n where n.jxjhh = '" + jxjhh + "'");
		for (JyPyjhkcxxb jyPyjhkcxxb : kcxxbList) {
			jyPyjhkcxxb.setZt(0);
			dao.modify(jyPyjhkcxxb);
		}
	}

	/**
	 * 置某专业方向相关的培养计划备用表课程信息的专业方向代码字段为null
	 * */
	@Override
	public void setZyfxNullByZyfx(JyZyfx obj) {
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxxb> kcxxbList = dao
				.search("from JyPyjhkcxxb as n where n.jxjhh = '" + obj.getNj()
						+ obj.getSysZy().getZydm() + "' and n.zyfxdm = '"
						+ obj.getZyfxdm() + "'");
		for (JyPyjhkcxxb jyPyjhkcxxb : kcxxbList) {
			jyPyjhkcxxb.setZyfxdm(null);
			dao.modify(jyPyjhkcxxb);
		}
	}

}
