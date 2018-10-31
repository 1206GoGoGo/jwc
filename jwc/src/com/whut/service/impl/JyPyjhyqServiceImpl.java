package com.whut.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyPyjhyq;
import com.whut.service.JyPyjhyqService;

//import config.Jdbc;

@Service
public class JyPyjhyqServiceImpl implements JyPyjhyqService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public List<JyPyjhyq> getpyListByZydm(String id) {
		String hql = "from JyPyjhyq as n where n.jyZyxx.sysZy.zydm='" + id
				+ "'";
		return dao.search(hql);
	}

	@Override
	public void addPyjhyqInfo(JyPyjhyq jyPyjhyq) {
		JyPyjhyq pyjhyq = (JyPyjhyq) dao.getObject("from JyPyjhyq as n where n.jxjhh ='"+jyPyjhyq.getJxjhh()+"'");
		if(pyjhyq!=null){
			pyjhyq.setPyjhywmc(jyPyjhyq.getPyjhywmc());
			pyjhyq.setZt(1);
			dao.modify(pyjhyq);
		}else{
			JyPyjhyq o = new JyPyjhyq();
			o.setJxjhh(jyPyjhyq.getJxjhh());
			o.setPyjhzwmc(jyPyjhyq.getPyjhzwmc());
			o.setZt(1);
			dao.add(o);
		}	
		
	}

	@Override
	public List<JyPyjhyq> getAllList() {
		String hql = "from JyPyjhyq as n where n.zt=1";
		return dao.search(hql);
	}

	@Override
	public List<JyPyjhyq> getAll1346List() {
		String hql = "from JyPyjhyq as n where (n.zt=1 or n.zt=3 or n.zt=6)";
		return dao.search(hql);
	}

	// public List<JyPyjhyq> getpyListByXydm(String xydm) {
	// String
	// hql="from JyPyjhyq as n where n.jyZyxx.sysZy.sysX.sysXy.xydm='"+xydm+"'";
	// return dao.search(hql);
	// }

	@Override
	public List<JyPyjhyq> getpyListByXydm(String xydm) {
		List<JyPyjhyq> list = dao
				.search("from JyPyjhyq as n where n.zt!=3 and n.zt!=0 and n.jyZyxx.sysZy.xydm ='"
						+ xydm + "'");
		return list;
	}

	@Override
	public JyPyjhyq getPyByJxjhh(String jxjhh) {
		String hql = "from JyPyjhyq as n where n.jxjhh='" + jxjhh + "'";
		return (JyPyjhyq) dao.getObject(hql);
	}

	@Override
	public JyPyjhyq getPyBynj(String nj) {

		String hql = "from JyPyjhyq as n where n.jxjhh like'" + nj
				+ "%' and n.zt=1";
		return (JyPyjhyq) dao.getObject(hql);
	}

	@Override
	public List<JyPyjhyq> getPyjhyqBynj(String nj) {

		List<JyPyjhyq> list;
		String hql = "from JyPyjhyq as n where n.jxjhh like'" + nj
				+ "%' and n.zt=1";
		list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhyq> getPyjhyqByNj(String nj) {

		List<JyPyjhyq> list;
		String hql = "from JyPyjhyq as n where n.jxjhh like'" + nj + "%'";
		list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhyq> search(String zydm, String nj) {

		List<JyPyjhyq> list;
		String hql = "";
		if (zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.zt=6 order by jyZyxx.nj desc";
		}
		if (zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.jyZyxx.nj like'" + nj
					+ "%' and n.zt=6 order by jyZyxx.nj desc";
		}
		if (!zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.jyZyxx.sysZy.zydm='" + zydm
					+ "' and n.zt=6 order by jyZyxx.nj desc";
		}
		if (!zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.jyZyxx.sysZy.zydm='" + zydm
					+ "'and n.jyZyxx.nj like '" + nj
					+ "%' and n.zt=6 order by jyZyxx.nj desc";
		}
		list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhyq> MHsearch(int cb, String text) {
		List<JyPyjhyq> list;
		String hql = "";
		switch (cb) {
		case 1:
			hql = "from JyPyjhyq as n where n.jxjhh like '%" + text
					+ "%' and n.zt=6";
			break;
		case 2:
			hql = "from JyPyjhyq as n where n.pyjhzwmc like '%" + text
					+ "%' and n.zt=6";
			break;
		case 3:
			hql = "from JyPyjhyq as n where n.jyZyxx.sysZy.sysX.sysXy.xymc like '%"
					+ text + "%' and n.zt=6";
			break;
		case 4:
			hql = "from JyPyjhyq as n where n.jyZyxx.nj like '%" + text
					+ "%' and n.zt=6";
			break;
		}
		list = dao.search(hql);
		return list;
	}

	/**
	 * 根据查询条件进行查询
	 * 
	 * 如果某项条件没有指定，则为“0”
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<JyPyjhyq> search(String xydm, String zydm, String nj) {
		List<JyPyjhyq> list;
		String hql = "from JyPyjhyq as n where ( n.zt=3 or n.zt=6 or n.zt=5 or n.zt=4 or n.zt=1)";
		if (!xydm.equals("0")) {
			hql += " and n.jyZyxx.sysZy.xydm='" + xydm + "'";
		}
		if (!zydm.equals("0")) {
			hql += " and n.jyZyxx.sysZy.zydm='" + zydm + "'";
		}
		if (!nj.equals("0")) {
			hql += " and n.jyZyxx.nj='" + nj + "'";
		}
		hql += " order by n.jxjhh desc";
		list = dao.search(hql);
		return list;
	}

	/**
	 * 更新一个JyPyjhyq
	 * */
	@Override
	public void modifyPyjhyq(JyPyjhyq jyPyjhyq) {
		dao.modify(jyPyjhyq);
	}

	//??????????????????????????
	@Override
	public void updatePyjhyq(JyPyjhyq jyPyjhyq) {
		
		/*Jdbc jdbc = new Jdbc();
		Connection connection = jdbc.getConnection();
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("UPDATE JY.JY_PYJHYQ  SET YWPYMBZW='"
					+ jyPyjhyq.getYwpymbzw() + "',YWPYMBYW='"
					+ jyPyjhyq.getYwpymbyw() + "',YWPYYQZW='"
					+ jyPyjhyq.getYwpyyqzw() + "',YWPYYQYW='"
					+ jyPyjhyq.getYwpyyqyw() + "'WHERE JXJHH='"
					+ jyPyjhyq.getJxjhh() + "'");
			st.close();
			jdbc.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public List<JyPyjhyq> search1346(String xydm, String zydm, String nj) {

		List<JyPyjhyq> list;
		String hql = "";
		if (xydm.equals("0") && zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.zt=3 or n.zt=6 or n.zt=1 or n.zt=4 order by jyZyxx.nj desc";
		}
		if (xydm.equals("0") && zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.jyZyxx.nj='" + nj
					+ "'  and n.zt!=2 and n.zt!=0 order by jyZyxx.nj desc";
		}
		if (!zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.jyZyxx.sysZy.zydm='"
					+ zydm
					+ "' and (n.zt=3 or n.zt=6 or n.zt=1 or n.zt=4) order by jyZyxx.nj desc";
		}
		if (!zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.jyZyxx.sysZy.zydm='"
					+ zydm
					+ "'and n.jyZyxx.nj = '"
					+ nj
					+ "' and (n.zt=3 or n.zt=6 or n.zt=1 or n.zt=4) order by jyZyxx.nj desc";
		}
		if (!xydm.equals("0") && zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.jyZyxx.sysZy.xydm='"
					+ xydm
					+ "' and (n.zt=3 or n.zt=6 or n.zt=1 or n.zt=4) order by jyZyxx.nj desc";
		}
		if (!xydm.equals("0") && zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhyq as n where n.jyZyxx.sysZy.xydm='"
					+ xydm
					+ "'and n.jyZyxx.nj = '"
					+ nj
					+ "' and (n.zt=3 or n.zt=6 or n.zt=1 or n.zt=4) order by jyZyxx.nj desc";
		}
		list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhyq> getZt1356List() {
		String hql = "from JyPyjhyq as n where (n.zt=1 or n.zt=3 or n.zt=4 or n.zt=5 or n.zt=6) and rownum<=11 order by n.jxjhh desc";
		return dao.search(hql);
	}

	/**
	 * 逻辑删除某培养计划要求
	 * */
	@Override
	public void delAJyPyjhyq(String jxjhh) {
		JyPyjhyq pyjhyq = (JyPyjhyq) dao
				.getObject("from JyPyjhyq as n where n.jxjhh='" + jxjhh + "'");
		if (pyjhyq != null) {
			pyjhyq.setZt(0);
			dao.modify(pyjhyq);
		}
	}
	
}
