package com.whut.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyPyjhkcxx;
import com.whut.pojo.JyZyfx;
import com.whut.pojo.SysKc;
import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.service.JyPyjhkcxxService;
import com.whut.service.SysKcService;

@Service
public class JyPyjhkcxxServiceImpl implements JyPyjhkcxxService {

	@Autowired
	private BaseHibernateDAO dao;
	@Autowired
	private SysKcService sysKcService;

	@Override
	public void delete(JyPyjhkcxx jyPyjhkcxx) {
		jyPyjhkcxx.setZt(0);
		dao.modify(jyPyjhkcxx);
	}

	@Override
	public List<JyPyjhkcxx> getKcxxListbyJhjhh(String jxjhh) {
		return dao.search("from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "'and n.zt=1 order by id ASC");
	}

	/**
	 * 有则覆盖，没有则添加
	 * */
	@Override
	public void addJyPyjhkcxx(JyPyjhkcxx jyPyjhkcxx) {
		// 2013 09 03
		// 今天系统更新后，以前实现了的功能现在不能用了。
		// 如：刚在船舶与海洋（余）2010级第5学期加入课程代码4140190111，加了两遍，再进入系统后，看不到该课程。
		// 请以后升级系统的时候，仔细检查，不要出现此种情况。
		if (jyPyjhkcxx.getJyKcmk() != null && (jyPyjhkcxx.getJyKcmk().getId() == 0 || jyPyjhkcxx.getJyKcmk().getZt() == 0)) {
			jyPyjhkcxx.setJyKcmk(null);
		}
		JyPyjhkcxx o = (JyPyjhkcxx) dao.getObject("from JyPyjhkcxx as n where n.jxjhh = '" + jyPyjhkcxx.getJxjhh() + "' and n.sysKc.kcdm = '"
				+ jyPyjhkcxx.getSysKc().getKcdm() + "' and n.zyfxdm = '" + jyPyjhkcxx.getZyfxdm() + "'");
		if (o == null) {
			int id = getmaxid();
			jyPyjhkcxx.setId(id);
			dao.add(jyPyjhkcxx);
		} else {
			jyPyjhkcxx.setId(o.getId());
			dao.modify(jyPyjhkcxx);
		}
	}

	public int getmaxid() {
		String hql = new String();
		// hql = "select id from JyPyjhkcxx";
		hql = "select id from JyPyjhkcxx as n where n > 73000";
		int maxid = 0;
		int temp;
		List<Integer> list = dao.search(hql);
		list.size();
		for (int syskc : list) {
			int id = syskc;
			temp = id;
			if (maxid <= temp) {
				maxid = temp + 1;
			}
		}
		return maxid;
	}

	@Override
	public void modify(JyPyjhkcxx jyPyjhkcxx) {
		dao.modify(jyPyjhkcxx);
	}

	@Override
	public List<SysKc> getRListById(String jxjhh, String kclbdm) {
		@SuppressWarnings("unchecked")
		List<SysKc> rlist = dao.search("select sysKc from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.sysKc.dmKclb.kclbdm='" + kclbdm
				+ "' and n.zt=1");
		return rlist;
	}

	@Override
	public List<SysKc> getLListById(String jxjhh, String kclbdm) {
		// List<SysKc> rList=getRListById(jxjhh,kclbdm);
		List<SysKc> rList = dao.search("select sysKc from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.sysKc.dmKclb.kclbdm='" + kclbdm
				+ "' and n.zt=1");
		List<SysKc> lList = sysKcService.getAllListByKclb(kclbdm);
		lList.removeAll(rList);
		return lList;
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcbyjxjhhandkclb(String jxjhh, String kclbdm) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.sysKc.dmKclb.kclbdm='" + kclbdm + "' and n.zt=1";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getZypyKcByjxjhhOrKcm(String jxjhh, String kcmc) {
		if (kcmc.equals("")) {
			String hql = "from JyPyjhkcxx as n where n.jxjhh ='" + jxjhh + "' and n.zt = 1";
			List<JyPyjhkcxx> list = dao.search(hql);
			return list;
		} else {
			String hql = "from JyPyjhkcxx as n where n.jxjhh = '" + jxjhh + "' and n.sysKc.kczwmc like '%" + kcmc + "%' and n.zt=1";
			List<JyPyjhkcxx> list = dao.search(hql);
			return list;
		}

	}

	@Override
	public List<JyPyjhkcxx> getZypyKcByjxjhh(String jxjhh) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh = '" + jxjhh + "'  and n.zt=1";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;

	}

	@Override
	public List<JyPyjhkcxx> getZypyKcByjxjhhAndKcmc(String jxjhh, String kcmc) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh = '" + jxjhh + "' and n.sysKc.kczwmc like '%" + kcmc + "%' and n.zt=1";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcbyjxjhh(String jxjhh) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.zt=1";
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcbyjxjhhforxg(String jxjhh) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and (n.zt=1 or n.zt=3 or n.zt=6)";
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcbyjxjhhzt6(String jxjhh) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and (n.zt=6)";
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcbyjxjhhzt16(String wjjxjhh, String jxjhh) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + wjjxjhh + "' and (n.zt=1)";
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		List<JyPyjhkcxx> list1 = dao.search(hql);
		String hql1 = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and (n.zt=6)";
		List<JyPyjhkcxx> list2 = dao.search(hql1);
		list1.addAll(list2);
		return list1;
	}

	@Override
	public List<JyPyjhkcxx> getMHKcList(int cb, String text) {
		String hql = new String();
		switch (cb) {
		case 1:
			hql = "from JyPyjhkcxx as n where n.jxjhh like '%" + text + "%'";
			break;
		case 2:
			hql = "from JyPyjhkcxx as n where n.sysKc.kczwmc like '%" + text + "%'";
			break;
		case 3:
			hql = "from JyPyjhkcxx as n where n.kclb like '%" + text + "%'";
			break;
		case 4:
			hql = "from JyPyjhkcxx as n where n.jykkxq like '%" + text + "%'";
			break;
		}
		return dao.search(hql);
	}

	@Override
	public List<SysKc> getgxkcByjxjhhAndkcmc(String jxjhh, String kcmc) {
		if (kcmc.equals("")) {
			String hql = "select sysKc from JyPyjhkcxx as n where n.jxjhh ='" + jxjhh + "' and n.zt = 1 and n.sfgxkc = 1";
			List<SysKc> list = dao.search(hql);
			return list;
		} else {
			String hql = "select sysKc from JyPyjhkcxx as n where n.jxjhh = '" + jxjhh + "' and n.sysKc.kczwmc like '%" + kcmc
					+ "%' and n.zt=1 and n.sfgxkc = 1";
			List<SysKc> list = dao.search(hql);
			return list;
		}
	}

	@Override
	public JyPyjhkcxx getkcByKcdm(String kcdm) {
		String hql = new String();
		hql = "from JyPyjhkcxx as n where n.sysKc.kcdm='" + kcdm + "'";
		JyPyjhkcxx tsObj = (JyPyjhkcxx) dao.getObject(hql);
		return tsObj;
	}

	@Override
	public List<JyPyjhkcxx> getXkc(String jxjhh) {
		String hql = new String();
		hql = "from JyPyjhkcxx as n where n.jxjhh='"
				+ jxjhh
				+ "' and (n.zt=4 or (n.zt=6 and n.sysKc.zt=4) or (n.zt=6 and n.sysKc.zt=1) or (n.zt=3 and n.sysKc.zt=6) or (n.zt=3 and n.sysKc.zt=1))";
		return dao.search(hql);
	}

	@Override
	public JyPyjhkcxx getJkcxx(String jxjhh, String kcdm) {
		String hql = new String();
		hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.sysKc.kcdm='" + kcdm + "' and n.zt=1";
		return (JyPyjhkcxx) dao.getObject(hql);
	}

	@Override
	public JyPyjhkcxx getkcxx(String jxjhh, String kcmc) {
		String hql = new String();
		hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.sysKc.kczwmc='" + kcmc + "' and n.zt=1 ";
		return (JyPyjhkcxx) dao.getObject(hql);
	}

	@Override
	public List<JyPyjhkcxx> getxtkc() {
		String hql = "from JyPyjhkcxx as n where n.sysKc.zt=4";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getxzkc(String kczwmc) {
		String hql = new String();
		hql = "from JyPyjhkcxx as n where n.sysKc.kczwmc='" + kczwmc + "' and n.sysKc.zt=4";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getgxkc(String xydm, String zydm, String nj) {
		String hql = new String();
		if (xydm.equals("0") && zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.sfgxkc=1 and n.zt=1";
		} else if (!xydm.equals("0") && zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.sfgxkc=1 and n.jxjhh like '" + nj + xydm + "%' and n.zt=1";
		} else if (xydm.equals("0") && zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.sfgxkc=1 and n.jxjhh like '%" + nj + "%' and n.zt=1";
		} else if (!xydm.equals("0") && zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.sfgxkc=1 and n.jxjhh like '%" + xydm + "%' and n.zt=1";
		} else if (!xydm.equals("0") && !zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.sfgxkc=1 and n.jxjhh like '%" + zydm + "%' and n.zt=1";
		} else if (!xydm.equals("0") && !zydm.equals("0") && !nj.equals("0")) {
			String jxjhh = nj + zydm;
			hql = "from JyPyjhkcxx as n where n.sfgxkc=1 and n.jxjhh=" + jxjhh + " and n.zt=1";
		}
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> gettmlist() {
		String hql = new String();
		hql = "from JyPyjhkcxx as n where n.sysKc.zt= 4  ";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> search1(String xydm, String zydm, String nj) {
		List<JyPyjhkcxx> list1;
		List<JyPyjhkcxx> list = new ArrayList();
		String hql = "";
		if (xydm.equals("0") && zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.zt=3 or n.zt=6 or n.zt=1";
		}
		if (xydm.equals("0") && zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.jyZyxx.nj='" + nj + "' and (n.zt=3 or n.zt=6 or n.zt=1)";
		}
		if (!zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.jyZyxx.sysZy.zydm='" + zydm + "' and (n.zt=3 or n.zt=6 or n.zt=1)";
		}
		if (!zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.jyZyxx.sysZy.zydm='" + zydm + "'and n.jyZyxx.nj = '" + nj + "' and (n.zt=3 or n.zt=6 or n.zt=1)";
		}
		if (!xydm.equals("0") && zydm.equals("0") && nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.jyZyxx.sysZy.xydm='" + xydm + "' and (n.zt=3 or n.zt=6 or n.zt=1)";
		}
		if (!xydm.equals("0") && zydm.equals("0") && !nj.equals("0")) {
			hql = "from JyPyjhkcxx as n where n.jyZyxx.sysZy.xydm='" + xydm + "'and n.jyZyxx.nj = '" + nj + "' and (n.zt=3 or n.zt=6 or n.zt=1)";
		}
		list1 = dao.search(hql);
		list.add(list1.get(0));
		int i = 0;
		for (i = 1; i < list1.size(); i++) {
			Boolean flag = true;
			JyPyjhkcxx jyPyjhkcxx = list1.get(i);
			int j = 0;
			for (j = 0; j < list.size(); j++) {
				JyPyjhkcxx Pyjhkcxx = list.get(j);
				if (jyPyjhkcxx.getJxjhh().equals(Pyjhkcxx.getJxjhh())) {
					list.set(j, Pyjhkcxx);
					flag = false;
					break;
				}
			}
			if (flag == true) {
				list.add(jyPyjhkcxx);
			}
		}
		return list;
	}

	@Override
	public JyPyjhkcxx getzykcbykcmcjxjhhzt(String jxjhh, String kczwmc, int zt) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.sysKc.kczwmc = '" + kczwmc + "' and n.zt = 2";
		return (JyPyjhkcxx) dao.getObject(hql);
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcxx(String jxjhh) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.zt=1 order by n.sysKc.kczwmc ASC ";
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcxx(String jxjhh, int jykkxq) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.jykkxq<" + jykkxq + "and n.zt=1 order by n.jykkxq ASC ";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcxx(String jxjhh, int jykkxq1, int jykkxy2) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.jykkxq>=" + jykkxq1 + " and n.jykkxq<=" + jykkxy2
				+ " and n.zt=1 order by n.jykkxq ASC ";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcxx1(String jxjhh) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and (n.zt=1 or n.zt=2 or n.zt=6 ) order by n.sysKc.kczwmc ASC ";
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	public JyPyjhkcxx del(int id) {
		String hql = "from JyPyjhkcxx as n where n.id = 76523";
		return (JyPyjhkcxx) dao.getObject(hql);
	}

	@Override
	public List<JyPyjhkcxx> search(String jxjhh, int xq) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.jykkxq=" + xq;
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyPyjhkcxx> getkcxxByJxjhhAndZt(String jxjhh) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.zt=4 ";
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public JyPyjhkcxx getKcxx(String jxjhh, String kcdm) {
		String hql = new String();
		hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.sysKc.kcdm='" + kcdm + "' and n.zt=1";
		return (JyPyjhkcxx) dao.getObject(hql);
	}

	@Override
	public List<JyPyjhkcxx> getKcxx1(String jxjhh, String kcdm) {
		String hql = "from JyPyjhkcxx as n where n.jxjhh='" + jxjhh + "' and n.sysKc.kcdm='" + kcdm + "' and n.zt=1 ";
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public JyPyjhkcxx getPyjhkcxxById(int Bid) {
		String hql = "from JyPyjhkcxx as n where n.zt=1 and n.id=" + Bid;
		// String hql = "from JyPyjhkcxx as n where n.jxjhh='"+jxjhh+"' ";
		return (JyPyjhkcxx) dao.getObject(hql);
	}

	@Override
	public List<JyPyjhkcxx> getPyjhkcxxByAll(String xydm, String zydm, String nj, String selectedxq) {
		String hql = new String();
		/* 全不选 */
		if (xydm.equals("0") && zydm.equals("0") && nj.equals("0") && selectedxq.equals("0")) {
			hql = "from JyPyjhkcxx as n where  n.zt=1 ";
		}
		/* 只选一个 */
		else if (!xydm.equals("0") && zydm.equals("0") && nj.equals("0") && selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n where n.zt=1 and n.jxjhh like '%" + xydm + "%' ";
		} else if (xydm.equals("0") && !zydm.equals("0") && nj.equals("0") && selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n where n.zt=1 and n.jxjhh like '%" + zydm + "' ";
		} else if (xydm.equals("0") && zydm.equals("0") && !nj.equals("0") && selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n where n.zt=1 and n.jxjhh like '" + nj + "%'";
		} else if (xydm.equals("0") && zydm.equals("0") && nj.equals("0") && !selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n  where n.zt=1 and n.jykkxq =" + selectedxq;
		}
		/* 选两个 */
		else if (xydm.equals("0") && zydm.equals("0") && !nj.equals("0") && !selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n where n.zt=1 and n.jxjhh like  '" + nj + "%' and n.jykkxq =" + selectedxq;
		} else if (xydm.equals("0") && !zydm.equals("0") && nj.equals("0") && !selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n where n.zt=1 and n.jxjhh like  '%" + zydm + "' and n.jykkxq =" + selectedxq;
		} else if (!xydm.equals("0") && zydm.equals("0") && nj.equals("0") && !selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n   where n.zt=1 and n.jxjhh like  '%" + xydm + "%' and n.jykkxq =" + selectedxq;
		} else if (xydm.equals("0") && !zydm.equals("0") && !nj.equals("0") && selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n  where n.zt=1 and n.jxjhh ='" + nj + zydm + "' ";
		} else if (!xydm.equals("0") && zydm.equals("0") && !nj.equals("0") && selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n  where n.zt=1 and n.jxjhh like '" + nj + xydm + "%' ";
		} else if (!xydm.equals("0") && !zydm.equals("0") && nj.equals("0") && selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n where n.zt=1 and n.jxjhh like '%" + zydm + "' ";
		}
		/* 选三个 */
		else if (!xydm.equals("0") && !zydm.equals("0") && !nj.equals("0") && selectedxq.equals("0")) {
			hql = "from JyPyjhkcxx as n  where n.zt=1 and n.jxjhh ='" + nj + zydm + "' order by kcxz ASC";
		} else if (!xydm.equals("0") && !zydm.equals("0") && nj.equals("0") && !selectedxq.equals("0")) {
			hql = "from JyPyjhkcxx as n C where n.zt=1 and n.jxjhh like '%" + zydm + "' and n.jykkxq=" + selectedxq + " order by kcxz ASC  ";
		} else if (xydm.equals("0") && !zydm.equals("0") && !nj.equals("0") && !selectedxq.equals("0")) {
			hql = "from JyPyjhkcxx as n  where n.zt=1 and n.jxjhh = '" + nj + zydm + "' and n.jykkxq=" + selectedxq + " order by kcxz ASC";
		} else if (!xydm.equals("0") && zydm.equals("0") && !nj.equals("0") && !selectedxq.equals("0")) {

			hql = "from JyPyjhkcxx as n where n.zt=1 and n.jxjhh like '" + nj + xydm + "%' and n.jykkxq=" + selectedxq + " order by kcxz ASC ";
		}
		/* 选四个 */
		else if (!xydm.equals("0") && !zydm.equals("0") && !nj.equals("0") && !selectedxq.equals("0")) {
			hql = "from JyPyjhkcxx as n  where n.zt=1 and n.jxjhh = '" + nj + zydm + "' and n.jykkxq=" + selectedxq + " order by kcxz ASC";
		}
		System.out.println(hql);
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	@Override
	public List<String> getPyjhkcxxBydistinct(String xydm, String nj, String selectedxq) {
		String hql = "select distinct jxjhh from JyPyjhkcxx as n where (n.zt=1 or n.zt=2) ";
		if (!xydm.equals("0")) {
			hql += " and n.jxjhh like '%" + xydm + "%'";
		}
		if (!nj.equals("0")) {
			hql += " and n.jxjhh like '%" + nj + "%'";
		}
		if (!selectedxq.equals("0")) {
			hql += " and n.jykkxq=" + selectedxq;
		}
		List<String> list = dao.search(hql);
		return list;
	}

	// 20130703

	/*
	 * 导出培养计划号为jxjhh、建议开课学期为xq的课程信息，按照pxfs的方式输出List
	 */
	@Override
	public List<JyPyjhkcxx> getPyjhkcxxFrompldyExport(String jxjhh, String xq, String pxfs) {
		String hql = "from JyPyjhkcxx as n where n.zt=1 and n.jxjhh='" + jxjhh + "' ";
		if (!xq.equals("0")) {
			hql += " and n.jykkxq=" + xq + " ";
		}
		hql += " order by jykkxq ,n." + pxfs;
		System.out.println(hql);
		List<JyPyjhkcxx> list = dao.search(hql);
		return list;
	}

	/**
	 * 培养计划课程信息综合查询
	 * */
	@Override
	public List<pyjhkcxxZhcxObj> pyjhkcxxZhcx(String whatString, String whereString) {
		whatString = whatString.trim();     	//.trim()是字符串所有起始和结尾的空格都被删除
		if (whatString.charAt(0) == ',') {
			whatString = whatString.substring(1);	//如果第一个字符是','则从第2个字符开始取
		}
		whereString = whereString.trim();
		if (whereString.length() == 0) {
			whereString = "1=1";			//没有查询条件就全部查询
		}
		String sql = "select " + whatString + " from jwxt.JY_PYJHKCXX a " + "left join jwxt.sys_kc kec on a.kcdm=kec.kcdm "
				+ "left join jwxt.sys_xy kkxy on kec.xydm=kkxy.xydm " + "left join jwxt.sys_xy skxy on skxy.xydm=substr(a.jxjhh,5,3) "
				+ "left join jwxt.sys_zy skzy on skzy.zydm=substr(jxjhh,5,4) " + "left join jwxt.jy_kcmk kcmk on a.mkid = kcmk.id "
				+ "left join jwxt.jy_kcz kcz on kcz.id=kcmk.kczid "
				+ "left join jwxt.jy_zyfx zyfx on a.zyfxdm=zyfx.zyfxdm WHERE (a.zyfxdm is null or substr(a.jxjhh,1,4) = zyfx.nj) and " + whereString;

		List<pyjhkcxxZhcxObj> list = dao.pyjhkcxxZhcx(sql);
		return list;
	}

	/**
	 * 拷贝一门课程到一个新的教学计划
	 * */
	@Override
	public void copy(String xjxjhh, JyPyjhkcxx jyPyjhkcxx) {
		JyPyjhkcxx Xcunzai = (JyPyjhkcxx) dao.getObject("from JyPyjhkcxx as n where n.jxjhh = '" + xjxjhh + "' and n.sysKc.kcdm = '"
				+ jyPyjhkcxx.getSysKc().getKcdm() + "'");
		if (Xcunzai != null) {
			Xcunzai.setZt(1);
			dao.modify(Xcunzai);
		} else {
			jyPyjhkcxx.setId(getmaxid());
			jyPyjhkcxx.setJxjhh(xjxjhh);
			jyPyjhkcxx.setZt(1);
			jyPyjhkcxx.setZyfxdm(null);
			jyPyjhkcxx.setKczdm(null);
			jyPyjhkcxx.setJyKcmk(null);
			dao.add(jyPyjhkcxx);
		}
	}

	/**
	 * 参数：学院代码 xydm:为"0"表示任意学院 专业代码：zydm：为"0"表示任意专业 年级：nj为"0"表示任意学年
	 * 学期：xq：1、2、3、4、5、6、7、8组成的字符串
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<JyPyjhkcxx> search(String xydm, String zydm, String nj, String xq) {
		List<JyPyjhkcxx> kcxx_list = new ArrayList();
		String hql = "from  JyPyjhkcxx as n where n.zt=1 and n.jykkxq in (" + xq.substring(0, xq.length() - 1) + ")";
		if (!nj.equals("0")) {
			hql += " and substr(n.jxjhh,1,4) = '" + nj + "'";
		}
		if (!zydm.equals("0")) {
			hql += " and substr(n.jxjhh,5,4) = '" + zydm + "'";
		} else {
			if (!xydm.equals("0")) {
				hql += " and substr(n.jxjhh,5,3) = '" + xydm + "'";
			}
		}
		kcxx_list = dao.search(hql);
		return kcxx_list;
	}

	@Override
	public int countPyjhkcxxInZyfx(String zyfxdm) {
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxx> kcxxs = dao.search("from JyPyjhkcxx as n where n.zyfxdm = '" + zyfxdm + "'");
		return kcxxs.size();
	}

	@Override
	public int countPyjhkcxxActiveInZyfx(String zyfxdm) {
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxx> kcxxs = dao.search("from JyPyjhkcxx as n where n.zyfxdm = '" + zyfxdm + "' and n.zt = 1");
		return kcxxs.size();
	}

	/**
	 * 逻辑删除jxjhh所有的课程
	 * */
	@Override
	public void delJyPyjhkcxxByJxjhh(String jxjhh) {
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxx> kcxxList = dao.search("from JyPyjhkcxx as n where n.jxjhh = '" + jxjhh + "'");
		for (JyPyjhkcxx jyPyjhkcxx : kcxxList) {
			jyPyjhkcxx.setZt(0);
			dao.modify(jyPyjhkcxx);
		}
	}

	/**
	 * 置某专业方向相关的培养计划课程信息的专业方向代码字段为null
	 * */
	@Override
	public void setZyfxNullByZyfx(JyZyfx obj) {
		@SuppressWarnings("unchecked")
		List<JyPyjhkcxx> kcxxList = dao.search("from JyPyjhkcxx as n where n.jxjhh = '" + obj.getNj() + obj.getSysZy().getZydm()
				+ "' and n.zyfxdm = '" + obj.getZyfxdm() + "'");
		for (JyPyjhkcxx jyPyjhkcxx : kcxxList) {
			jyPyjhkcxx.setZyfxdm(null);
			dao.modify(jyPyjhkcxx);
		}
	}

	@Override
	public List<JyPyjhkcxx> getXxkcList(JyPyjhkcxx jyPyjhkcxx) {
		List<JyPyjhkcxx> list = new ArrayList<JyPyjhkcxx>();
		if (jyPyjhkcxx.getXxkc() != null) {
			String[] arr = jyPyjhkcxx.getXxkc().split("-");
			for (int i = 0; i < arr.length; i++) {

			}
		}
		return null;
	}

}
