package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyPyjhyq;
import com.whut.pojo.JyZyxx;
import com.whut.service.JyZyxxService;

@Service
public class JyZyxxServiceImpl implements JyZyxxService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public void addZyxx(JyZyxx jyZyxx) {
		dao.add(jyZyxx);
	}

	@Override
	public List<JyZyxx> search(String xydm, String xqdm, String nj) {
		String hql = "from JyZyxx as n where 1=1";
		if (nj != null && !nj.equals("0") && !nj.equals("")) {
			hql += " and n.nj like '" + nj + "%'";
		}
		if (xqdm != null && !xqdm.equals("ZERO")&&  !xqdm.equals("")) {
			hql += " and n.ssxqdm = '" + xqdm + "'";
		}
		if (xydm != null && !xydm.equals("ZERO")&& !xydm.equals("")) {
			hql += " and n.sysZy.xydm ='" + xydm + "'";
		}
		hql += " order by jxjhh ASC";
		List<JyZyxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyZyxx> search(String xydm, String xqdm, String nj, String ZT) {
		String hql = "";
		if (ZT.equals("正常")) {
			/* 全不选 */
			if (xydm.equals("ZERO") && xqdm.equals("ZERO") && nj.equals("0")) {
				hql = "from JyZyxx as n where n.zt=1 order by jxjhh ASC";
			}
			/* 选一个 */
			if (xydm.equals("ZERO") && xqdm.equals("ZERO") && !nj.equals("0")) {
				hql = "from JyZyxx as n where n.zt=1 and n.nj like'" + nj
						+ "%' order by jxjhh ASC";
			}

			if (xydm.equals("ZERO") && !xqdm.equals("ZERO") && nj.equals("0")) {
				hql = "from JyZyxx as n where  n.zt=1 and n.ssxqdm ='" + xqdm
						+ "' order by jxjhh ASC";
			}
			if (!xydm.equals("ZERO") && xqdm.equals("ZERO") && nj.equals("0")) {
				hql = "from JyZyxx as n where  n.zt=1 and n.sysZy.xydm ='"
						+ xydm + "' order by jxjhh ASC";
			}
			/* 选两个 */
			if (xydm.equals("ZERO") && !xqdm.equals("ZERO") && !nj.equals("0")) {
				hql = "from JyZyxx as n where  n.zt=1 and n.ssxqdm ='" + xqdm
						+ "' and n.nj like'" + nj + "%' order by jxjhh ASC";
			}
			if (!xydm.equals("ZERO") && !xqdm.equals("ZERO") && nj.equals("0")) {
				hql = "from JyZyxx as n where  n.zt=1 and n.sysZy.xydm ='"
						+ xydm + "' and n.ssxqdm ='" + xqdm
						+ "' order by jxjhh ASC";
			}
			if (!xydm.equals("ZERO") && xqdm.equals("ZERO") && !nj.equals("0")) {
				hql = "from JyZyxx as n where n.zt=1 and n.sysZy.xydm ='"
						+ xydm + "' and n.nj like'" + nj
						+ "%' order by jxjhh ASC";
			}
			/* 选三个 */
			if (!xydm.equals("ZERO") && !xqdm.equals("ZERO") && !nj.equals("0")) {
				hql = "from JyZyxx as n where n.zt=1 and n.sysZy.xydm ='"
						+ xydm + "' and n.nj like'" + nj + "%' and n.ssxqdm ='"
						+ xqdm + "' order by jxjhh ASC";
			}
		} else if (ZT.equals("停用")) {
			/* 全不选 */
			if (xydm.equals("ZERO") && xqdm.equals("ZERO") && nj.equals("0")) {
				hql = "from JyZyxx as n where n.zt=0 order by jxjhh ASC";
			}
			/* 选一个 */
			if (xydm.equals("ZERO") && xqdm.equals("ZERO") && !nj.equals("0")) {
				hql = "from JyZyxx as n where n.zt=0and n.nj like'" + nj
						+ "%' order by jxjhh ASC";
			}

			if (xydm.equals("ZERO") && !xqdm.equals("ZERO") && nj.equals("0")) {
				hql = "from JyZyxx as n where  n.zt=0 and n.ssxqdm ='" + xqdm
						+ "' order by jxjhh ASC";
			}
			if (!xydm.equals("ZERO") && xqdm.equals("ZERO") && nj.equals("0")) {
				hql = "from JyZyxx as n where  n.zt=0and n.sysZy.xydm ='"
						+ xydm + "' order by jxjhh ASC";
			}
			/* 选两个 */
			if (xydm.equals("ZERO") && !xqdm.equals("ZERO") && !nj.equals("0")) {
				hql = "from JyZyxx as n where  n.zt=0 and n.ssxqdm ='" + xqdm
						+ "' and n.nj like'" + nj + "%' order by jxjhh ASC";
			}
			if (!xydm.equals("ZERO") && !xqdm.equals("ZERO") && nj.equals("0")) {
				hql = "from JyZyxx as n where  n.zt=0 and n.sysZy.xydm ='"
						+ xydm + "' and n.ssxqdm ='" + xqdm
						+ "' order by jxjhh ASC";
			}
			if (!xydm.equals("ZERO") && xqdm.equals("ZERO") && !nj.equals("0")) {
				hql = "from JyZyxx as n where n.zt=0 and n.sysZy.xydm ='"
						+ xydm + "' and n.nj like'" + nj
						+ "%' order by jxjhh ASC";
			}
			/* 选三个 */
			if (!xydm.equals("ZERO") && !xqdm.equals("ZERO") && !nj.equals("0")) {
				hql = "from JyZyxx as n where n.zt=0 and n.sysZy.xydm ='"
						+ xydm + "' and n.nj like'" + nj + "%' and n.ssxqdm ='"
						+ xqdm + "' order by jxjhh ASC";
			}
		}
		List<JyZyxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyZyxx> getAllList() {

		return dao.search("from JyZyxx as n where n.zt=1 order by nj desc");
	}

	/**
	 * 
	 * */
	@Override
	public JyZyxx getZyxxListByjxjhh(String id) {
		JyZyxx jyZyxx = new JyZyxx();
		jyZyxx = (JyZyxx) dao
				.getObject("from JyZyxx as n where n.zt=1 and n.jxjhh='" + id
						+ "'");
		return jyZyxx;
	}

	/**
	 * 
	 * */
	@Override
	public JyZyxx getZyxx(String jxjhh) {
		return (JyZyxx) dao.getObject("from JyZyxx as n where n.jxjhh = '"
				+ jxjhh + "'");
	}

	@Override
	public void deleteZyxx(String zyxxdm) {
		JyZyxx jyZyxx = (JyZyxx) dao
				.getObject("from JyZyxx as n where n.zt=1 and n.jxjhh='"
						+ zyxxdm + "'");
		if (jyZyxx != null) {
			jyZyxx.setZt(0);
			dao.modify(jyZyxx);
		}
	}

	@Override
	public void modifyZyxx(JyZyxx jyZyxx) {
		dao.modify(jyZyxx);
	}

	@Override
	public List<JyZyxx> MHsearch(int Tj, String text) {
		String hql = new String();
		switch (Tj) {
		case 1:
			hql = "from JyZyxx as n where n.zt=1 and n.jxjhh like '%" + text
					+ "%'";
			break;
		case 2:
			hql = "from JyZyxx as n where n.zt=1 and n.sysZy.zymc like '%"
					+ text + "%'";
			break;
		case 3:
			hql = "from JyZyxx as n where n.zt=1 and n.sysZy.cc like '%" + text
					+ "%'";
			break;
		case 4:
			hql = "from JyZyxx as n where n.zt=1 and n.zdbyxf like '%" + text
					+ "%'";
			break;
		}
		List<JyZyxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyZyxx> getZyxxListByNj(String nj) {
		String hql = "";
		hql = "from JyZyxx as n where n.zt=1 and n.nj='" + nj + "'";
		@SuppressWarnings("unchecked")
		List<JyZyxx> list = dao.search(hql);
		return list;
	}

	/*
	 * 检查相应教学计划号的zyxx是否存在
	 * 
	 * 2013-10-23
	 */
	@Override
	public String checkJxjhh(String jxjhh) {
		String hql = "from JyZyxx as n where n.zt = 1";
		List list = dao.search(hql);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			JyZyxx all = (JyZyxx) it.next();
			if (all.getJxjhh().equals(jxjhh)) {
				return "exist";
			}
		}
		return "noexist";

	}
	
	//删除测试专业信息
	@Override
	public void deleteZt2() {
		JyPyjhyq pyjhyq = (JyPyjhyq) dao.getObject("from JyPyjhyq as n where n.nj='2017'");
		if(pyjhyq != null) {
			dao.delete(pyjhyq);
		}
	}

}
