package com.whut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyXxtx;
import com.whut.service.JyXxtxService;

@Service
public class JyXxtxServiceImpl implements JyXxtxService {
	
	@Autowired
	private BaseHibernateDAO dao;


	//根据时间段查询收件箱消息
	public List<JyXxtx> getXxtxByjsf(String jsf, String sj1, String sj2) {
		// TODO Auto-generated method stub
		String hql = "";
		List<JyXxtx> list = new ArrayList<JyXxtx>();
		if (!jsf.equals("") && sj1.equals("") && sj2.equals("")) {
			hql = "from JyXxtx as n where n.jsf='" + jsf
					+ "'and n.zt =1 order by xxdm desc ";
		}
		if (!jsf.equals("") && !sj1.equals("") && sj2.equals("")) {
			hql = "from JyXxtx as n where n.jsf ='" + jsf
					+ "' and n.zt =1 and n.fssj - to_date('" + sj1
					+ "','MM/dd/yyyy') > 0 order by xxdm desc ";
		}
		if (!jsf.equals("") && sj1.equals("") && !sj2.equals("")) {
			hql = "from JyXxtx as n where n.jsf='" + jsf
					+ "' and n.zt =1 and n.fssj - to_date('" + sj2
					+ "','MM/dd/yyyy')< 0 order by xxdm desc ";
		}
		if (!jsf.equals("") && !sj1.equals("") && !sj2.equals("")) {
			hql = "from JyXxtx as n where n.jsf='" + jsf
					+ "'  and n.zt =1 and  n.fssj between to_date('" + sj1
					+ "','MM/dd/yyyy') and to_date('" + sj2
					+ "','MM/dd/yyyy') order by xxdm desc";
		}
		if (jsf.equals("") && sj1.equals("") && sj2.equals("")) {
			hql = "from JyXxtx as n where  n.zt =1 order by xxdm desc ";
		}
		if (jsf.equals("") && !sj1.equals("") && sj2.equals("")) {
			hql = "from JyXxtx as n where   n.zt =1 and n.fssj - to_date('"
					+ sj1 + "','MM/dd/yyyy') > 0 order by xxdm desc";
		}
		if (jsf.equals("") && sj1.equals("") && !sj2.equals("")) {
			hql = "from JyXxtx as n where n.fssj - to_date('" + sj2
					+ "','MM/dd/yyyy')< 0 and n.zt =1 order by xxdm desc ";
		}
		if (jsf.equals("") && !sj1.equals("") && !sj2.equals("")) {
			hql = "from JyXxtx as n where  n.fssj between to_date('" + sj1
					+ "','MM/dd/yyyy') and to_date('" + sj2
					+ "','MM/dd/yyyy') and n.zt =1 order by xxdm desc ";
		}
		list = dao.search(hql);
		return list;
	}

	public List<JyXxtx> getXxtxByfsf(String fsf, String sj1, String sj2) {
		// TODO Auto-generated method stub
		String hql = "";
		List<JyXxtx> list = new ArrayList<JyXxtx>();
		if (fsf.equals("") && sj1.equals("") && sj2.equals("")) {
			hql = "from JyXxtx  and n.zt =1 order by xxdm desc";
		}
		if (fsf.equals("") && !sj1.equals("") && sj2.equals("")) {
			hql = "from JyXxtx as n where n.fssj - to_date('" + sj1
					+ "','MM/dd/yyyy') > 0  and n.zt =1 order by xxdm desc";
		}
		if (fsf.equals("") && sj1.equals("") && !sj2.equals("")) {
			hql = "from JyXxtx as n where n.fssj - to_date('" + sj2
					+ "','MM/dd/yyyy')< 0  and n.zt =1 order by xxdm desc";
		}
		if (fsf.equals("") && !sj1.equals("") && !sj2.equals("")) {
			hql = "from JyXxtx as n where  n.fssj between to_date('" + sj1
					+ "','MM/dd/yyyy') and to_date('" + sj2
					+ "','MM/dd/yyyy') and n.zt =1 order by xxdm desc ";
		}
		if (!fsf.equals("") && sj1.equals("") && sj2.equals("")) {
			hql = "from JyXxtx as n where n.fsf='" + fsf
					+ "' and n.zt =1 order by xxdm desc ";
		}
		if (!fsf.equals("") && !sj1.equals("") && sj2.equals("")) {
			hql = "from JyXxtx as n where  n.fsf ='" + fsf
					+ "' and n.zt =1 and n.fssj - to_date('" + sj1
					+ "','MM/dd/yyyy') > 0 order by xxdm desc ";
		}
		if (!fsf.equals("") && sj1.equals("") && !sj2.equals("")) {
			hql = "from JyXxtx as n where n.fsf='" + fsf
					+ "' and n.zt =1 and n.fssj - to_date('" + sj2
					+ "','MM/dd/yyyy')< 0 and n.zt !=0 order by xxdm desc";
		}
		if (!fsf.equals("") && !sj1.equals("") && !sj2.equals("")) {
			hql = "from JyXxtx as n where n.fsf='" + fsf
					+ "' and n.zt =1 and  n.fssj between to_date('" + sj1
					+ "','MM/dd/yyyy') and to_date('" + sj2
					+ "','MM/dd/yyyy') and n.zt !=0 order by xxdm desc";
		}
		list = dao.search(hql);
		return list;
	}

	public List<JyXxtx> getListByjsf(String xymc) {
		@SuppressWarnings("unchecked")
		List<JyXxtx> list = dao.search("from JyXxtx as n where n.jsf='" + xymc
				+ "' and n.zt = 1 order by xxdm desc");
		return list;
	}

	public List<JyXxtx> getListByfsf(String xymc) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<JyXxtx> list = dao.search("from JyXxtx as n where n.fsf='" + xymc
				+ "' and n.zt = 1 order by xxdm desc");
		return list;
	}

	public JyXxtx getXxtxByxxdm(int xxdm) {
		// TODO Auto-generated method stub
		JyXxtx jyXxtx = (JyXxtx) dao.getObject("from JyXxtx as n where n.xxdm="
				+ xxdm + " and n.zt=1 order by xxdm desc");
		return jyXxtx;
	}


	public void deleteMse(JyXxtx jyXxtx) {
		dao.modify(jyXxtx);
	}

	public List<JyXxtx> getdelListByfsforjsf(String xymc) {
		@SuppressWarnings("unchecked")
		List<JyXxtx> list = dao.search("from JyXxtx as n where (n.fsf='" + xymc
				+ "' or n.jsf='" + xymc + "') and n.zt = 0 order by xxdm desc");
		return list;

	}


	@SuppressWarnings("unchecked")
	public List<JyXxtx> getdelXxtxByfsforjsf(String fsf, String sj1, String sj2) {
		String hqlString = "from JyXxtx as n where n.zt = 0 and(n.fsf='" + fsf
				+ "' or n.jsf='" + fsf + "')";
		if (!sj1.equals("")) {
			hqlString += " and n.fssj - to_date('" + sj1
					+ "','MM/dd/yyyy') > 0";
		}
		if (!sj2.equals("")) {
			hqlString += " and n.fssj - to_date('" + sj2
					+ "','MM/dd/yyyy')< 0 ";
		}
		hqlString += " order by xxdm desc";
		List<JyXxtx> list = dao.search(hqlString);
		return list;

	}


	public void afterviewMse(JyXxtx jyXxtx) {
		dao.modify(jyXxtx);
	}

	public JyXxtx getdelXxtxByxxdm(String xxdm) {
		JyXxtx list = (JyXxtx) dao
				.getObject("from JyXxtx as n where n.zt = 0 and n.xxdm= '"
						+ xxdm + "' order by xxdm desc");
		return list;
	}

	public void RealDeleteMse(JyXxtx jyXxtx) {
		dao.modify(jyXxtx);
	}

	public List<JyXxtx> getAllList() {
		// TODO Auto-generated method stub
		return dao.search("from JyXxtx");
	}

	@Override
	public void addXxtx(JyXxtx jyXxtx) {
		// TODO Auto-generated method stub
		dao.add(jyXxtx);
	}
}
