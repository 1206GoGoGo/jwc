package com.whut.service.impl;

import java.io.Console;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.SysKc;
import com.whut.service.SysKcService;

@Service
public class SysKcServiceImpl implements SysKcService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public void del(SysKc syskc) {
		dao.delete(syskc);
	}

	@Override
	public void addKecheng(SysKc sysKc) {
		dao.add(sysKc);
	}

	@Override
	public List<SysKc> getAll() { 
		return dao.search("from SysKc as n where n.zt=1 or n.zt=2 order by kczwmc ASC");

	}

	@Override
	public void modifyKecheng(SysKc sysKc) {
		dao.modify(sysKc);
	}


	@Override
	public void deleteKecheng(SysKc sysKc) {
		dao.delete(sysKc);
	}

	@Override
	public SysKc getKechengById(String id) {
		String hql = "from SysKc as n where n.kcdm='" + id + "'";
		SysKc kc = new SysKc();
		kc = (SysKc) dao.getObject(hql);
		return kc;

	}

	@Override
	public List<SysKc> getAllListByKclb(String kclbdm) {
		String hql = "from SysKc as n where n.dmKclb.kclbdm='" + kclbdm + "'";
		return dao.search(hql);
	}

	@Override
	public List<SysKc> getKcListbyXy(String xydm, String kclbdm) {
		String hql = new String();
		if (xydm.equals("ZERO") && kclbdm.equals("ZERO")) {
			hql = "from SysKc as n where n.zt!=0 order by kczwmc ASC";
		}

		else if (!xydm.equals("ZERO") && kclbdm.equals("ZERO")) {
			hql = "from SysKc as n where n.zt!=0 and n.xydm='" + xydm + "' order by kczwmc ASC";
		}

		else if (xydm.equals("ZERO") && !kclbdm.equals("ZERO")) {
			hql = "from SysKc as n where n.zt!=0 and n.dmKclb.kclbdm='" + kclbdm + "' order by kczwmc ASC";
		}

		else {
			hql = "from SysKc as n where n.zt!=0 and n.xydm='" + xydm + "'and n.dmKclb.kclbdm='" + kclbdm + "' order by kczwmc ASC";
		}
		List<SysKc> list = dao.search(hql);
		System.out.println(hql);
		return list;
	}

	@Override
	public List<SysKc> searchKcList(String xydm, String kclbdm, int zt) {
		String hql = new String();
		if (xydm.equals("ZERO") && kclbdm.equals("ZERO") && zt == 10) {
			hql = "from SysKc as n where n.zt!=0";
		} else if (!xydm.equals("ZERO") && kclbdm.equals("ZERO") && zt == 10) {
			hql = "from SysKc as n where n.zt!=0 and n.xydm='" + xydm + "'";
		} else if (xydm.equals("ZERO") && !kclbdm.equals("ZERO") && zt == 10) {
			hql = "from SysKc as n where n.zt!=0 and n.dmKclb.kclbdm='" + kclbdm + "'";
		} else if (!xydm.equals("ZERO") && !kclbdm.equals("ZERO") && zt == 10) {
			hql = "from SysKc as n where n.zt!=0 and n.xydm='" + xydm + "'and n.dmKclb.kclbdm='" + kclbdm + "'";
		} else if (xydm.equals("ZERO") && kclbdm.equals("ZERO") && zt != 10) {
			hql = "from SysKc as n where n.zt='" + zt + "'";
		} else if (!xydm.equals("ZERO") && !kclbdm.equals("ZERO") && zt != 10) {
			hql = "from SysKc as n where n.xydm='" + xydm + "'and n.dmKclb.kclbdm='" + kclbdm + "'" + "and n.zt='" + zt + "'";
		} else if (xydm.equals("ZERO") && !kclbdm.equals("ZERO") && zt != 10) {
			hql = "from SysKc as n where n.dmKclb.kclbdm='" + kclbdm + "'" + "and n.zt='" + zt + "'";
		} else if (!xydm.equals("ZERO") && kclbdm.equals("ZERO") && zt != 10) {
			hql = "from SysKc as n where n.xydm='" + xydm + "'and n.zt='" + zt + "'";
		}
		return dao.search(hql);
	}

	@Override
	public String recommend(String xdm) {
		String hql = new String();
		hql = "from SysKc as n where n.kcdm like '%" + xdm + "%'";
		double maxkcdm = 0;
		// int kcdm = Integer.valueOf();
		List<SysKc> syskcList = dao.search(hql);
		for (SysKc syskc : syskcList) {
			String kcdm = syskc.getKcdm().toString();
			kcdm = kcdm.substring(0, kcdm.length() - 3);
			double temp = Double.valueOf(kcdm);
			if (maxkcdm < temp)
				maxkcdm = temp + 1;
		}
		String kcdmString = String.valueOf(maxkcdm);
		return kcdmString.substring(0, kcdmString.lastIndexOf('.'));
	}

	@Override
	public String recommendBydm(String flag, String dm) {
		String hql = null;
		if (flag.equals("xydm")) {
			hql = "from SysKc as n where n.kcdm like '" + dm + "%'";
		} else {
			String xydm = dm.substring(0, 3);
			hql = "from SysKc as n where n.kcdm like '" + xydm + "%'";
		}
		double maxkcdm = 0;
		// int kcdm = Integer.valueOf();
		List<SysKc> syskcList = dao.search(hql);
		for (SysKc syskc : syskcList) {
			String kcdm = syskc.getKcdm().toString();
			kcdm = kcdm.substring(0, kcdm.length() - 3);
			double temp = Double.valueOf(kcdm);
			if (maxkcdm <= temp)        //选取最大的前七位
				maxkcdm = temp + 1;
		}
		String kcdmString = String.valueOf(maxkcdm);
		if (maxkcdm == 0) {
			if (flag.equals("xydm")) {
				return dm + "0000";
			} else {
				return dm + "000";
			}

		} else {
			return kcdmString.substring(0, kcdmString.lastIndexOf('.'));
		}
	}

	@Override
	public List<SysKc> getInitKcList(String kcxz) {
		// String hql = "from SysKc as n where n.kcxz='"+kcxz+"'";
		String hql = "from SysKc as n where n.dmKclb.kclbdm='" + kcxz + "' and n.zt = 1";
		return dao.search(hql);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SysKc> getMHKcList(int cb, String text) {
		String hql = new String();
		switch (cb) {
		case 1:
			hql = "from SysKc as n where n.kczwmc like '%" + text + "%'";
			break;
		case 2:
			hql = "from SysKc as n where n.xdm like '%" + text + "%'";
			break;
		case 3:
			hql = "from SysKc as n where n.kcdm like '%" + text + "%'";
			break;
		case 4:
			hql = "from SysKc as n where n.dmKclb.kclbmc like '%" + text + "%'";
			break;
		}
		return dao.search(hql);
	}

	@Override
	public List<SysKc> get10SysKc() {
		return dao.search("from SysKc as n where n.zt!=0 and rownum <=10");
	}

	@Override
	public String IfContainKcdm(String kcdm) {
		List<SysKc> syskcList = dao.search("from SysKc as n where n.zt!=0");
		Iterator it1 = syskcList.iterator();
		Map map = new HashMap();
		while (it1.hasNext()) {
			SysKc all = (SysKc) it1.next();
			map.put(all.getKcdm(), all);
		}
		if (map.containsKey(kcdm)) {
			return "has";
		} else
			return "none";
	}

	@Override
	public List<SysKc> getKcListforbg(String xydm, String kczwmc, int state) {
		String hql = new String();
		if (xydm.equals("ZERO") && kczwmc.equals("ZERO")) {
			hql = "from SysKc as n where n.zt!=0";
		}

		else if (!xydm.equals("ZERO") && kczwmc.equals("ZERO")) {
			hql = "from SysKc as n where n.zt!=0 and n.xydm='" + xydm + "'";
		}

		else if (xydm.equals("ZERO") && !kczwmc.equals("ZERO")) {
			hql = "from SysKc as n where n.zt!=0 and n.kczwmc like'%" + kczwmc + "%'";
		}

		else {
			hql = "from SysKc as n where n.zt!=0 and n.xydm='" + xydm + "'and n.kczwmc like'%" + kczwmc + "%'";
		}

		if (state == 0) {

		} else if (state == 1) {
			hql = hql + "and n.zt =4";
		} else {
			hql = hql + "and n.zt =5";
		}
		List<SysKc> list = dao.search(hql);
		return list;
	}

	@Override
	public void passforkcsh(SysKc syskc) {
		if (syskc.getZt() == 4) { //若是新建的课程
			syskc.setZt(1);      //将课程状态设置为正常
			dao.modify(syskc);
		}
		if (syskc.getZt() == 5) { //若是被修改的课程
			SysKc temp = new SysKc();
			temp.setKcdm(syskc.getKcyl1());
			temp.setDmKclb(syskc.getDmKclb());
			temp.setJyXxgs(syskc.getJyXxgs());
			temp.setKcjj(syskc.getKcjj());
			temp.setKclbmc(syskc.getKclbmc());
			temp.setKcxz(syskc.getKcxz());
			temp.setKcywjj(syskc.getKcywjj());
			temp.setKcywmc(syskc.getKcywmc());
			temp.setKczwmc(syskc.getKczwmc());
			temp.setKczyzyjmd(syskc.getKczyzyjmd());
			temp.setKwxs(syskc.getKwxs());
			temp.setLlxs(syskc.getLlxs());
			temp.setSjxs(syskc.getSjxs());
			temp.setSjxs2(syskc.getSjxs2());
			temp.setSyxs(syskc.getSyxs());
			temp.setXdm(syskc.getXdm());
			temp.setXf(syskc.getXf());
			temp.setXydm(syskc.getXydm());
			temp.setYxyqdm(syskc.getYxyqdm());
			temp.setZhxs(syskc.getZhxs());
			temp.setZycks(syskc.getZycks());
			temp.setSjzs(syskc.getSjzs());//实践周数
			temp.setZt(1);
			dao.modify(temp);
			dao.delete(syskc);
		}
	}

	@Override
	public List<SysKc> kcSearch(String all) {
		String hql = new String();
		hql = all;
		List<SysKc> list = dao.search(hql);
		return list;
	}

	@Override
	public void importKcjj(List<SysKc> kcList) {
		for (int i = 0; i <= kcList.size(); i++) {
			SysKc importKc = kcList.get(i);
			SysKc sysKc = (SysKc) dao.getObject(SysKc.class, importKc.getKcdm());
			sysKc.setKcjj(importKc.getKcjj());
			dao.modify(sysKc);

		}

	}

	@Override
	public int depKc(String kcdm) {
		SysKc sysKc = (SysKc) dao.getObject("from SysKc as n where n.kcdm = '" + kcdm + "'");
		int result = 0;
		if (sysKc != null) {
			/*if (sysKc.getZt()==1) {
				sysKc.setZt(2);
				result = 2;
			} else if (sysKc.getZt()==2) {
				sysKc.setZt(1);
				result = 1;
			}*/
			//heyuqi 2016.6.8
			if(sysKc.getSfqy().equals("1")){
				sysKc.setSfqy("0");  //课程弃用Sfqy=0   
				result = 0;
			}else{
				sysKc.setSfqy("1");  //课程恢复
				result = 1;
			}
			dao.modify(sysKc);
			System.out.println(sysKc.getKcdm());
			System.out.println(sysKc.getSfqy());
		}

		return result;

	}
	//heyuqi 2016.6.8
	@Override
	public SysKc getKechengByIdAndSfqy(String id){
		String hql = "from SysKc as n where n.kcdm='" + id + "' and sfqy='1'";
		SysKc kc = new SysKc();
		kc = (SysKc) dao.getObject(hql);
		return kc;
	}
	@Override
	public List<SysKc> getByKcmcAndSfqy(String kczwmc){
		String hql = new String();
		hql = "from SysKc as n where n.kczwmc like '%" + kczwmc + "%' and n.sfqy='1'";
		return dao.search(hql);
	}

}
