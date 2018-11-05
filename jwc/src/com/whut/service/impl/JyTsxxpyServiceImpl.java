package com.whut.service.impl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;

import com.whut.pojo.JyTsxxpy;
import com.whut.service.JyTsxxpyService;


import com.whut.pojo.JyTsxxkcjsdyb;
import com.whut.pojo.SysKc;
import com.whut.service.SysKcService;

@Service
public class JyTsxxpyServiceImpl implements JyTsxxpyService {

	@Autowired
	private BaseHibernateDAO dao;
	@Autowired
	private SysKcService sysKcService;


	@Override
	public List<JyTsxxpy> getTsxxpyjhByTsxxpydm(String tsxxpydm) {
		// TODO Auto-generated method stub
		String hql = new String();
		hql = "from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.tsxxpydm='"
				+ tsxxpydm + "'";
		return dao.search(hql);
	}

	@Override
	public List<JyTsxxpy> getList() {
		@SuppressWarnings("rawtypes")
		List<String> tsxxpydmList = dao
				.search("select distinct tsxxpydm from JyTsxxpy ");
		List<JyTsxxpy> listtemp = dao
				.search("from JyTsxxpy where tsxxpydm in (select distinct tsxxpydm from JyTsxxpy ) order by tsxxpydm desc");
		Map<String, JyTsxxpy> jytsxxpyMap = new HashMap<String, JyTsxxpy>();
		for (JyTsxxpy jytsxxpy : listtemp) {
			if (tsxxpydmList.contains(jytsxxpy.getTsxxpydm())) {
				if (jytsxxpyMap.get(jytsxxpy.getTsxxpydm()) == null) {
					jytsxxpyMap.put(jytsxxpy.getTsxxpydm(), jytsxxpy);
				}
			}
		}
		List<JyTsxxpy> jytsxxpyList = new ArrayList<JyTsxxpy>();
		if (jytsxxpyMap != null && jytsxxpyMap.size() > 0) {
			jytsxxpyList.addAll(jytsxxpyMap.values());
		}
		return jytsxxpyList;
	}

	@Override
	public List<SysKc> getLListById(String tsxxpydm, String xydm) {
		List<SysKc> rList = getRListById(tsxxpydm, xydm);
		List<SysKc> lList = sysKcService.getAll();
		lList.removeAll(rList);
		return lList;
	}

	@Override
	public List<SysKc> getRListById(String tsxxpydm, String xydm) {
		@SuppressWarnings("unchecked")
		List<JyTsxxpy> rList = dao
				.search("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.tsxxpydm='"
						+ tsxxpydm + "' and n.sysXy.xydm='" + xydm + "'");
		SysKc sysKc = new SysKc();
		List<SysKc> kcList = new ArrayList<SysKc>();
		for (int i = 0; i < rList.size(); i++) {
			sysKc = rList.get(i).getSysKc();
			kcList.add(sysKc);
		}
		return kcList;
	}

	@Override
	public void delJyTsxxpy(JyTsxxpy jyTsxxpy) {
		jyTsxxpy.setZt(0);
		dao.modify(jyTsxxpy);
	}


	@Override
	public void addJyTsxxpy(JyTsxxpy jyTsxxpy) {
		List tslist = dao.search("from JyTsxxpy as n where n.nj = '"
				+ jyTsxxpy.getNj() + "' and n.sysKc.kcdm = '"
				+ jyTsxxpy.getSysKc().getKcdm() + "'");
		if (tslist != null && tslist.size() > 0) {
			JyTsxxpy jyTsxxpy1 = (JyTsxxpy) tslist.get(0);
			jyTsxxpy.setId(jyTsxxpy1.getId());
			dao.modify(jyTsxxpy);
		} else {
			int id = getmaxid();
			jyTsxxpy.setId(id);
			dao.add(jyTsxxpy);
		}
	}

	@SuppressWarnings("unchecked")
	public int getmaxid() {
		String hql = "select id from JyTsxxpy as n";
		List<Integer> list = dao.search(hql);
		int maxid = 0;
		for (int id : list) {
			if (id > maxid) {
				maxid = id;
			}
		}
		return maxid + 1;
	}

	@Override
	public void modifyTsxxpy(JyTsxxpy jyTsxxpy) {
		dao.modify(jyTsxxpy);
	}

	@Override
	public JyTsxxpy getPyjhById(String id) {
		String hql = "from JyTsxxpy as n where n.id=" + id;
		return (JyTsxxpy) dao.getObject(hql);
	}

	@Override
	public List<JyTsxxpy> getPyjhByxy(String xydm) {
		String hql = "from JyTsxxpy as n where n.sysXy.xydm=" + xydm;
		List<JyTsxxpy> list = dao.search(hql);
		return list;
	}

	// public List<JyTsxxpy> getListByNj(String nj) {
	// String hql = "from JyTsxxpy as n where n.nj like '" + nj + "%'";
	// return dao.search(hql);
	// }

	@Override
	public List<JyTsxxpy> searchxvsn(String xydm, String nj) {
		String hql = new String();
		if (xydm.equals("0") && nj.equals("0")) {
			hql = "from JyTsxxpy as n where n.zt!=0";
		} else if (!xydm.equals("0") && nj.equals("0")) {
			hql = "from JyTsxxpy as n where n.zt!=0 and n.sysXy.xydm='" + xydm
					+ "'";
		} else if (xydm.equals("0") && !nj.equals("0")) {
			hql = "from JyTsxxpy as n where n.zt!=0 and n.nj like '" + nj
					+ "%'";
		} else if (!xydm.equals("0") && !nj.equals("0")) {
			hql = "from JyTsxxpy as n where n.zt!=0 and n.sysXy.xydm='" + xydm
					+ "' and n.nj like'" + nj + "%'";
		}
		List<JyTsxxpy> list = dao.search(hql);
		return list;
	}

	@Override
	public List<SysKc> getLListById(String tsxxpydm) {
		// TODO Auto-generated method stub
		List<SysKc> rList = getRListById(tsxxpydm);
		List<SysKc> lList = sysKcService.getAllListByKclb("2");
		lList.removeAll(rList);
		return lList;
	}

	@Override
	public List<SysKc> getRListById(String tsxxpydm) {
		@SuppressWarnings("unchecked")
		List<JyTsxxpy> rList = dao
				.search("from JyTsxxpy as n where n.zt=6 and n.tsxxpydm='"
						+ tsxxpydm + "'");
		SysKc sysKc = new SysKc();
		List<SysKc> kcList = new ArrayList<SysKc>();
		for (int i = 0; i < rList.size(); i++) {
			sysKc = rList.get(i).getSysKc();
			kcList.add(sysKc);
		}
		return kcList;
	}

	@Override
	public List<JyTsxxpy> getJyTsxxpyList(String tsxxpydm) {
		List<JyTsxxpy> list = dao
				.search("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.tsxxpydm='"
						+ tsxxpydm + "'");
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<JyTsxxpy> getTsInitList() {
		@SuppressWarnings("rawtypes")
		List listtemp = dao
				.search("select distinct tsxxpydm,sysXy.xydm from JyTsxxpy order by tsxxpydm desc");
		@SuppressWarnings("unchecked")
		List<JyTsxxpy> list = new ArrayList();
		List<JyTsxxpy> list0 = new ArrayList();
		Iterator it = listtemp.iterator();
		while (it.hasNext()) {
			Object[] ob = (Object[]) it.next();
			String tsxxpydm = (String) ob[0];
			String xydm = (String) ob[1];
			System.out.print("tsxxpydm：" + tsxxpydm + "xydm：" + xydm);
			// String hql =
			// "from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.id=(select min(id) from JyTsxxpy as m where m.tsxxpydm='"+tsxxpydm+"' and m.sysXy.xydm='"+xydm+"')";
			// JyTsxxpy jyTsxxpy =(JyTsxxpy)dao.getObject(hql);
			String hql = "from JyTsxxpy as n where n.tsxxpydm='" + tsxxpydm
					+ "' and n.sysXy.xydm='" + xydm
					+ "' and n.zt!=5 and n.zt!=2 and n.zt!=0";
			list0 = dao.search(hql);
			if (list0.size() != 0) {
				list.add(list0.get(0));
			}
		}
		return list;
	}

	@Override
	public List<JyTsxxpy> searchxvsn1(String xydm, String nj){

		new String();
		List<JyTsxxpy> list = new ArrayList();
		List<JyTsxxpy> temp = new ArrayList();
		JyTsxxpy jyTsxxpy = new JyTsxxpy();
		if (xydm.equals("0") && nj.equals("0")) {
			list = getTsInitList();
		} else if (!xydm.equals("0") && nj.equals("0")) {
			temp = getTsInitList();
			for (int i = 0; i < temp.size(); i++) {
				jyTsxxpy = temp.get(i);
				if (jyTsxxpy.getSysXy().getXydm().equals(xydm)) {
					list.add(jyTsxxpy);
				}
			}
		} else if (xydm.equals("0") && !nj.equals("0")) {
			temp = getTsInitList();
			for (int i = 0; i < temp.size(); i++) {
				jyTsxxpy = temp.get(i);
				if (jyTsxxpy.getTsxxpydm().equals(nj)) {
					list.add(jyTsxxpy);
				}
			}
		} else if (!xydm.equals("0") && !nj.equals("0")) {
			jyTsxxpy = (JyTsxxpy) dao
					.getObject("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.id=(select min(id) from JyTsxxpy as m where m.tsxxpydm='"
							+ nj + "' and m.sysXy.xydm='" + xydm + "')");
			list.add(jyTsxxpy);
		}
		return list;
	}


	@Override
	public List<SysKc> getLListByNjXy(String xydm, String nj) {
		List<SysKc> rList = getRListByNjXy(xydm, nj);
		List<SysKc> lList = sysKcService.getAllListByKclb("2");
		lList.removeAll(rList);
		return lList;
	}

	@Override
	public List<SysKc> getRListByNjXy(String xydm, String nj) {
		List<JyTsxxpy> rList = dao
				.search("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.sysXy.xydm='"
						+ xydm + "' and n.nj='" + nj + "'");
		SysKc sysKc = new SysKc();
		List<SysKc> kcList = new ArrayList<SysKc>();
		for (int i = 0; i < rList.size(); i++) {
			sysKc = rList.get(i).getSysKc();
			kcList.add(sysKc);
		}
		return kcList;
	}

	@Override
	public List<JyTsxxpy> getTsxxpyListByXyNj(String xydm, String nj) {
		String hql = "from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.sysXy.xydm='"
				+ xydm + "' and n.tsxxpydm='" + nj + "'";
		List<JyTsxxpy> list = dao.search(hql);
		return list;
	}

	@Override
	public List<JyTsxxpy> gettspykcByXyNjMc(String xydm, String tsxxpydm,
			String kcmc) {
		if (kcmc.equals("")) {
			String hql = "from JyTsxxpy as n where n.sysXy.xydm='" + xydm
					+ "' and n.tsxxpydm = '" + tsxxpydm
					+ "' and n.zt!=5 and n.zt!=2 and n.zt!=0";
			List<JyTsxxpy> list = dao.search(hql);
			return list;
		} else {
			String hql = "from JyTsxxpy as n where n.sysXy.xydm='" + xydm
					+ "' and n.tsxxpydm = '" + tsxxpydm
					+ "' and n.sysKc.kczwmc like '%" + kcmc
					+ "%' and n.zt!=5 and n.zt!=2 and n.zt!=0";
			List<JyTsxxpy> list = dao.search(hql);
			return list;
		}

	}

	@Override
	public List<String> getTsxxpyListByXydm(String xydm) {
		List<String> list = dao
				.search("select distinct tsxxpydm from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.sysXy.xydm='"
						+ xydm + "'");
		return list;
	}

	@Override
	public List<JyTsxxpy> getPyjhBytsdmAndnj(String tsxxpydm, String nj) {

		String hql = new String();
		if (tsxxpydm.equals("ZERO") && nj.equals("ZERO")) {
			hql = "from JyTsxxpy as n where n.zt!=0";
		}

		else if (!tsxxpydm.equals("ZERO") && nj.equals("ZERO")) {
			hql = "from JyTsxxpy as n where n.zt!=0 and n.tsxxpydm='"
					+ tsxxpydm + "'";
		}

		else if (tsxxpydm.equals("ZERO") && !nj.equals("ZERO")) {
			hql = "from JyTsxxpy as n where n.zt!=0 and n.nj='" + nj + "'";
		}

		else {
			hql = "from JyTsxxpy as n where n.zt!=0 and n.tsxxpydm='"
					+ tsxxpydm + "'and n.nj='" + nj + "'";
		}
		List<JyTsxxpy> list = dao.search(hql);

		Iterator it = list.iterator();
		String Jsmc = "";
		new ArrayList<JyTsxxpy>();
		while (it.hasNext()) {
			JyTsxxpy all = (JyTsxxpy) it.next();
			for (JyTsxxkcjsdyb Getjsmc : GetKcJsList(all.getId())) {
				// System.out.println("++++++++++Getjsmc.getSysJs()教师姓名：="+Getjsmc.getSysJs().getXm());
				Jsmc = Jsmc + Getjsmc.getSysJs().getXm() + ",";
			}
			// System.out.println("+*********所有的="+Jsmc);
			all.setShhf(Jsmc);
		}
		return list;
	}

	public List<JyTsxxkcjsdyb> GetKcJsList(int pyid) {
		String hql = "from JyTsxxkcjsdyb as n where n.zt=1 and n.jyTsxxpy.id="
				+ pyid;
		List<JyTsxxkcjsdyb> list = dao.search(hql);
		return list;
	}

	@Override
	public List<SysKc> getMHKcList(int cb, String text, String tsxxpydm) {
		String hql = new String();
		// System.out.println("---"+cb+"---"+text);
		switch (cb) {
		case 1:
			hql = "from SysKc as n where n.kczwmc like '%" + text + "%'";
			break;
		case 2:
			hql = "from SysKc as n where n.xydm like '%" + text + "%'";
			break;
		case 3:
			hql = "from SysKc as n where n.kcdm like '%" + text + "%'";
			break;
		case 4:
			hql = "from SysKc as n where n.sysKclb.kclbmc like '%" + text
					+ "%'";
			break;
		}
		List<SysKc> rList = getRListById(tsxxpydm);
		List<SysKc> lList = dao.search(hql);
		lList.removeAll(rList);
		return lList;
	}

	@Override
	public List<SysKc> getMHKcList1(int cb, String text, String tsxxpydm) {
		String hql = new String();
		// List<SysKc> rList=getRListById(tsxxpydm);
		switch (cb) {
		case 1:
			hql = "from SysKc as n where n.kczwmc like '%" + text + "%'";
			break;
		case 2:
			hql = "from SysKc as n where n.xydm like '%" + text + "%'";
			break;
		case 3:
			hql = "from SysKc as n where n.kcdm like '%" + text + "%'";
			break;
		case 4:
			hql = "from SysKc as n where n.sysKclb.kclbmc like '%" + text
					+ "%'";
			break;
		}
		List<SysKc> lList = getLListById(tsxxpydm);
		List<SysKc> list = dao.search(hql);
		list.removeAll(lList);
		return list;

	}

	@Override
	public List<JyTsxxpy> searchxvsn2(String xq, String nj)// yuanwei searchxvsn
	// zacun
	{
		new String();
		List<JyTsxxpy> list = new ArrayList();
		new ArrayList();
		JyTsxxpy jyTsxxpy = new JyTsxxpy();
		if (xq.equals("0") && nj.equals("0")) {
			list = getTsInitList();
		} else if (!xq.equals("0") && nj.equals("0")) {
			// temp=getTsInitList();
			// for(int i=0;i<temp.size();i++)
			// {
			// jyTsxxpy=(JyTsxxpy)temp.get(i);
			// if(jyTsxxpy.getJykkxq().contains(xq))
			// {
			jyTsxxpy = (JyTsxxpy) dao
					.getObject("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.id=(select min(id) from JyTsxxpy as m where m.jykkxq like '%"
							+ xq + "%')");

			list.add(jyTsxxpy);
			// }
			// }

		} else if (xq.equals("0") && !nj.equals("0")) {
			// temp=getTsInitList();
			// for(int i=0;i<temp.size();i++)
			// {
			// jyTsxxpy=(JyTsxxpy)temp.get(i);
			// if(jyTsxxpy.getTsxxpydm().equals(nj))
			// {
			jyTsxxpy = (JyTsxxpy) dao
					.getObject("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.id=(select min(id) from JyTsxxpy as m where m.tsxxpydm='"
							+ nj + "')");

			list.add(jyTsxxpy);
			// }
			// }
		} else if (!xq.equals("0") && !nj.equals("0")) {
			jyTsxxpy = (JyTsxxpy) dao
					.getObject("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.id=(select min(id) from JyTsxxpy as m where m.tsxxpydm='"
							+ nj + "' and m.jykkxq like '%" + xq + "%')");
			list.add(jyTsxxpy);
		}
		return list;
	}

	@Override
	public List<JyTsxxpy> getAllList() {
		String hql = "from JyTsxxpy as n where n.zt!=0";
		return dao.search(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JyTsxxpy> getAllTspyjhList() {
		List<JyTsxxpy> list0 = new ArrayList<JyTsxxpy>();
		String hql = "select distinct nj from JyTsxxpy as n where n.zt!=0 ";
		List<String> list = new ArrayList<String>();
		list = dao.search(hql);
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String NJ = it.next();
			Long count1 = dao
					.count("select count(*) from JyTsxxpy as n where (n.zt=4 or n.zt=5 or n.zt=6) and n.nj='"
							+ NJ + "'");
			if (count1.intValue() == 0) {
				JyTsxxpy xxpy = (JyTsxxpy) dao.search(
						"from JyTsxxpy as n where  n.zt=1 and n.nj='" + NJ
								+ "'").get(0);
				xxpy.setShhf("已通过审核");
				list0.add(xxpy);
			} else {
				JyTsxxpy xxpy = (JyTsxxpy) dao.search(
						"from JyTsxxpy as n where (n.zt=4 or n.zt=5 or n.zt=6) and nj='"
								+ NJ + "'").get(0);
				xxpy.setShhf("待审核");
				list0.add(xxpy);
			}
		}
		return list0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<JyTsxxpy> getTsxxpyListBynj1(String nj) {
		List<JyTsxxpy> list = new ArrayList<JyTsxxpy>();
		List<JyTsxxpy> list0 = new ArrayList<JyTsxxpy>();
		if (nj.equals("0")) {
			list = getAllTspyjhList();
		} else {
			String hql0 = "from JyTsxxpy as n where (n.zt=1 or n.zt=4 or n.zt=5 or n.zt=6) and n.nj='"
					+ nj + "' and n.zt!=0 order by sysKc.kczwmc desc";
			list0 = dao.search(hql0);
			int i = 0;
			Boolean flag = true;
			for (i = 0; i < list0.size(); i++) {
				JyTsxxpy jyTsxxpy = list0.get(i);
				if (jyTsxxpy.getZt() != 1) {
					jyTsxxpy.setShhf("待审核");
					list.add(jyTsxxpy);
					flag = false;
					break;
				}
			}
			if (flag == true) {
				list0.get(0).setShhf("已通过审核");
				list.add(list0.get(0));
			}
		}
		return list;
	}

	/**
	 * 
	 * */
	@Override
	public List<JyTsxxpy> getListByNj(String nj) {
		String hql = "from JyTsxxpy as n where  n.zt=1 and n.nj like '%" + nj
				+ "%'";
		return dao.search(hql);
	}

	@Override
	public List<JyTsxxpy> getListBynj(String nj) {
		String hql = "from JyTsxxpy as n where  n.zt=1 and n.nj = '" + nj
				+ "%'";
		return dao.search(hql);
	}

	@Override
	public List<JyTsxxpy> getListByNj1(String nj) {
		String hql = "from JyTsxxpy as n where (n.zt=1 or n.zt=5 or n.zt=4 or n.zt=6) and n.nj like '"
				+ nj + "%'";
		return dao.search(hql);
	}

	@Override
	public List<JyTsxxpy> getListByNj2(String nj) {
		String hql = "from JyTsxxpy as n where (n.zt=5 or n.zt=6 or n.zt=4 ) and n.nj like '%"
				+ nj + "%'";
		return dao.search(hql);
	}

	@Override
	public void shpasstspyjh(String kcdm, String tsdm, String nj) {
		// TODO Auto-generated method stub

	}

	@Override
	public JyTsxxpy getpassTskc(String kcdm, String tsdm) {
		String hql = new String();
		hql = "from JyTsxxpy as n where n.sysKc.kcdm='" + kcdm
				+ "' and n.tsxxpydm='" + tsdm + "' ";
		JyTsxxpy jyTsxxpy = (JyTsxxpy) dao.getObject(hql);
		return jyTsxxpy;
	}

	@Override
	public List<JyTsxxpy> getTsxxpydm() {
		List<JyTsxxpy> tsxxpydmList = dao
				.search("select distinct tsxxpydm from JyTsxxpy order by tsxxpydm desc ");
		return tsxxpydmList;
	}

	@Override
	public List<JyTsxxpy> getXkc1(String nj) {
		String hql = new String();
		hql = "from JyTsxxpy as n where n.nj='" + nj
				+ "' and (n.zt=2 or n.zt=4 or n.zt=6))";
		return dao.search(hql);
	}

	@Override
	public List<JyTsxxpy> getXkc(String nj) {
		String hql = new String();
		hql = "from JyTsxxpy as n where n.nj='"
				+ nj
				+ "' and (n.zt=5 or (n.zt=4 and n.sysKc.zt=1)or (n.zt=4 and n.sysKc.zt=5) or (n.zt=6 and n.sysKc.zt=4) or (n.zt=6 and n.sysKc.zt=1)  or (n.zt=6 and n.sysKc.zt=5))";
		return dao.search(hql);
	}

	@Override
	public JyTsxxpy getXkcxx(String nj, String kcmc) {
		String hql = new String();
		hql = "from JyTsxxpy as n where n.nj='"
				+ nj
				+ "' and n.sysKc.kczwmc='"
				+ kcmc
				+ "' and ((n.zt=4 and n.sysKc.zt=1) or(n.zt=4 and n.sysKc.zt=5))";
		return (JyTsxxpy) dao.getObject(hql);
	}

	@Override
	public JyTsxxpy getJkcxx(String nj, String kcmc) {
		String hql = new String();
		hql = "from JyTsxxpy as n where n.nj='"
				+ nj
				+ "' and n.sysKc.kczwmc='"
				+ kcmc
				+ "' and ((n.zt=3 and n.sysKc.zt=1) or (n.zt=6 and n.sysKc.zt=5))";
		JyTsxxpy tsxx = new JyTsxxpy();
		tsxx = (JyTsxxpy) dao.getObject(hql);
		return tsxx;
	}

	@Override
	public JyTsxxpy getkcxx(String nj, String kcmc) {
		String hql = new String();
		hql = "from JyTsxxpy as n where n.nj='"
				+ nj
				+ "' and n.sysKc.kczwmc='"
				+ kcmc
				+ "' and ((n.zt=6 and n.sysKc.zt=4) or (n.zt=6 and n.sysKc.zt=1) or (n.zt=6 and n.sysKc.zt=5) or n.zt=5)";
		return (JyTsxxpy) dao.getObject(hql);
	}

	@Override
	public JyTsxxpy getkcByKcdm(String kcdm) {
		String hql = new String();
		hql = "from JyTsxxpy as n where n.sysKc.kcdm='" + kcdm + "'";
		JyTsxxpy tsobj = (JyTsxxpy) dao.getObject(hql);
		return tsobj;
	}

	@Override
	public List<JyTsxxpy> getTsxxpyListforxg(String nj) {
		String hql = "from JyTsxxpy as n where n.nj ='" + nj
				+ "' and (n.zt=4 or n.zt=1 or n.zt=6)";
		return dao.search(hql);
	}

	@Override
	public void del(JyTsxxpy jyTsxxpy) {
		dao.delete(jyTsxxpy);
	}

	@Override
	public JyTsxxpy gettskcbykcmcidzt(String nj, String kczwmc, int zt) {
		String hql = "from JyTsxxpy as n where n.nj='" + nj
				+ "' and n.sysKc.kczwmc = '" + kczwmc + "' and n.zt = 3";
		return (JyTsxxpy) dao.getObject(hql);
	}

	@Override
	public JyTsxxpy getTsByNjAndMc(String nj, String kczwmc) {
		String hql = "from JyTsxxpy as n where n.nj='" + nj
				+ "' and n.sysKc.kczwmc = '" + kczwmc + "' and n.zt = 3";
		return (JyTsxxpy) dao.getObject(hql);
	}

	@Override
	public JyTsxxpy getpassTskc(String kcdm, String nj, int zt) {
		String hql = "from JyTsxxpy as n where   n.sysKc.kcdm='" + kcdm
				+ "' and n.nj='" + nj + "' and n.zt=" + zt;
		JyTsxxpy jyTsxxpy = (JyTsxxpy) dao.getObject(hql);
		return jyTsxxpy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JyTsxxpy> getTsxxpyListBynj(String nj) { // aaaa
		new String();
		List<JyTsxxpy> list = new ArrayList<JyTsxxpy>();
		List<JyTsxxpy> list0 = new ArrayList<JyTsxxpy>();
		if (nj.equals("0")) {
			list0 = dao
					.search("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0");
			list.add(list0.get(0));
			int i = 0;
			for (i = 1; i < list0.size(); i++) {
				Boolean flag = true;
				JyTsxxpy jyTsxxpy = list0.get(i);
				int j = 0;
				for (j = 0; j < list.size(); j++) {
					JyTsxxpy Tsxxpy = list.get(j);
					if (jyTsxxpy.getNj().equals(Tsxxpy.getNj())) {
						flag = false;
						break;
					}
				}
				if (flag == true) {
					list.add(jyTsxxpy);
				}
			}
		} else {
			list0 = dao
					.search("from JyTsxxpy as n where n.zt!=5 and n.zt!=2 and n.zt!=0 and n.nj='"
							+ nj + "'");
			if (list0.size() != 0) {
				list.add(list0.get(0));
			}
		}
		return list;
	}

	/**
	 * 
	 * */
	@Override
	public boolean hasKcInNj(String kcdm, String nj) {
		Long count = dao
				.count("select count(*) from JyTsxxpy as n where n.sysKc.kcdm = '"
						+ kcdm + "' and n.nj='" + nj + "' and n.zt!=0");
		if (count.intValue() > 0) {
			return true;
		}
		return false;
	}

}
