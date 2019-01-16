package com.whut.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyQx;
import com.whut.pojo.JyYhqx;
import com.whut.pojo.SysJs;
import com.whut.pojo.SysJwyh;
import com.whut.service.JyQxService;

@Service
public class JyQxServiceImpl implements JyQxService {

	@Autowired
	private BaseHibernateDAO dao;

	public List<JyQx> getAllqx() {
		return dao.search("from JyQx");
	}
	
	public List<JyYhqx> getyhID(String yhid) {
		String hql = "";
		List<JyYhqx> list = new ArrayList<JyYhqx>();
		if (!yhid.equals("")) {
			hql = "from JyYhqx as n where n.yhid='" + yhid + "' and  n.zt='"
					+ 1 + "' order by yhid desc ";
		}
		list = dao.search(hql);
		return list;
	}
	
	public List<SysJs> search(String xm) {
		String hql = "";
		List<SysJs> list = new ArrayList<SysJs>();
		if (!xm.equals("")) {
			hql = "select n from SysJs as n where n.xm like '%" + xm
					+ "%'  order by xm desc ";
		}
		if (xm.equals("")) {
			hql = "from SysJs";
		}
		list = dao.search(hql);
		Iterator it = list.iterator();
		List<JyYhqx> listJyYhqx = new ArrayList<JyYhqx>();
		listJyYhqx = getAllJyYhqx();
		while (it.hasNext()) {
			SysJs all = (SysJs) it.next();
			all.setXl("6");
			for (int k = 0; k < listJyYhqx.size(); k++) {
				if (listJyYhqx.get(k).getYhid().toString()
						.equals(all.getZgh().toString())) {
					all.setXl(listJyYhqx.get(k).getJyQx().getQxid().toString());
				}

			}
		}
		return list;
	}
	
	public List<JyYhqx> getAllJyYhqx() {
		String hql = "";
		List<JyYhqx> list = new ArrayList<JyYhqx>();
		hql = "from JyYhqx as n where  n.zt='" + 1 + "'";
		list = dao.search(hql);
		return list;
	}
	
	public List<SysJs> getAll() {
		List<SysJs> list = new ArrayList<SysJs>();
		list = dao.search("from SysJs");
		/*Iterator it = list.iterator();
		List<JyYhqx> listJyYhqx = new ArrayList<JyYhqx>();
		listJyYhqx = getAllJyYhqx();
		Iterator Qxit = listJyYhqx.iterator();
		Map tempQx = new HashMap();
		while (Qxit.hasNext()) {
			JyYhqx Qx = (JyYhqx) Qxit.next();
			tempQx.put(Qx.getYhid(), Qx.getJyQx().getQxid());
		}
		while (it.hasNext()) {
			SysJs all = (SysJs) it.next();
			all.setXl("6");
			all.setXl(tempQx.get(all.getZgh().toString()).toString());
			
		}*/
		return list;
	}
	
	public List<SysJwyh> search_JW(String xm) {
		String hql = "";
		List<SysJwyh> list_JW = new ArrayList<SysJwyh>();
		if (!xm.equals("")) {
			hql = "select n from SysJwyh as n where n.xm like '%" + xm
					+ "%'  order by xm desc ";
		}
		list_JW = dao.search(hql);
		Iterator it = list_JW.iterator();
		List<JyYhqx> listJyYhqx = new ArrayList<JyYhqx>();
		listJyYhqx = getAllJyYhqx();
		while (it.hasNext()) {
			SysJwyh all = (SysJwyh) it.next();
			all.setJs("6");
			for (int k = 0; k < listJyYhqx.size(); k++) {
				if (listJyYhqx.get(k).getYhid().toString()
						.equals(all.getYhm().toString())) {
					all.setJs(listJyYhqx.get(k).getJyQx().getQxid().toString());
				}

			}
		}
		return list_JW;
	}
	
	public List<SysJwyh> searchAll_JW() {
		List<SysJwyh> list_JW = new ArrayList<SysJwyh>();
		list_JW = dao.search("from SysJwyh");
		Iterator it = list_JW.iterator();
		List<JyYhqx> listJyYhqx = new ArrayList<JyYhqx>();
		listJyYhqx = getAllJyYhqx();
		while (it.hasNext()) {
			SysJwyh all = (SysJwyh) it.next();
			all.setJs("6");
			for (int k = 0; k < listJyYhqx.size(); k++) {
				if (listJyYhqx.get(k).getYhid().toString()
						.equals(all.getYhm().toString())) {
					all.setJs(listJyYhqx.get(k).getJyQx().getQxid().toString());
				}

			}
		}
		return list_JW;
	}
	
	public void mofifyQX(String yhid, BigDecimal jyQx) {
		JyYhqx jyYhqx = (JyYhqx) dao
				.getObject("from JyYhqx as n where n.yhid='" + yhid
						+ "' and n.zt= 1");
		JyQx jyQxtemp = (JyQx) dao.getObject("from JyQx as n where n.qxid ='"
				+ jyQx + "'");
		jyYhqx.setJyQx(jyQxtemp);
		jyYhqx.setZt("1");
		dao.modify(jyYhqx);
	}
	
	public void mofifyJY_YHqX(JyYhqx jyYhqx) {
		dao.modify(jyYhqx);
	}
	
	public void updateQX() {
		List<JyYhqx> listqx = dao.search("from JyYhqx as n where  n.zt='" + 1
				+ "'");
		Iterator it = listqx.iterator();
		Map map = new HashMap(); // 存放已有用户map
		while (it.hasNext()) {
			JyYhqx all = (JyYhqx) it.next();
			map.put(all.getYhid(), "false");
		}
		List<String> list = dao.search("select n.xh from XjXxb n");
		List<String> newxslist = new LinkedList();
		Iterator its = list.iterator();
		while (its.hasNext()) {
			String xs = (String) its.next();
			if (map.containsKey(xs)) {
			} else {
				newxslist.add(xs);
			}
		}
		List<String> listjs = dao.search("select n.zgh from SysJs n");
		List<String> newjslist = new LinkedList();
		Iterator itt = listjs.iterator();
		while (itt.hasNext()) { // 教师
			String js = (String) itt.next();
			if (map.containsKey(js)) {
			} else {
				newjslist.add(js);
			}
		}
		List<SysJwyh> jwyhList = dao.search("from SysJwyh n where n.ty = 0");
		List<String> newjwlist = new LinkedList(); // 教务处其他
		List<String> xyjwcList = new LinkedList(); // 学院教务处
		Iterator itjw = jwyhList.iterator();
		while (itjw.hasNext()) {
			SysJwyh jw = (SysJwyh) itjw.next();
			if (map.containsKey(jw.getYhm())) {
			} else if (jw.getJs().equals("教务处")) {
				newjwlist.add(jw.getYhm());
			} else {
				xyjwcList.add(jw.getYhm());
			}
		}
		for (String tmp : newxslist) {
			addQX_new(tmp, new BigDecimal(2));// 学生2
		}
		for (String tmp : newjslist) {
			addQX_new(tmp, new BigDecimal(1));// 教师1
		}
		for (String tmp : newjwlist) {
			addQX_new(tmp, new BigDecimal(4));
		}
		for (String tmp : xyjwcList) {
			addQX_new(tmp, new BigDecimal(5));
		}
	}
	
	public void addQX_new(String yhid, BigDecimal jyQx) {// /两个数据库同步时使用这个modify
		JyYhqx jyYhqx = new JyYhqx();
		JyQx jyQxtemp = (JyQx) dao.getObject("from JyQx as n where n.qxid ='"
				+ jyQx + "'");
		jyYhqx.setYhid(yhid);
		jyYhqx.setJyQx(jyQxtemp);
		jyYhqx.setZt("1");
		dao.add(jyYhqx);
	}

	public void addQx(JyYhqx jyYhqx) {
		// TODO Auto-generated method stub
		dao.add(jyYhqx);
	}
	
}
