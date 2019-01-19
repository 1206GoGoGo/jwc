package com.whut.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.JyGdxfdz;
import com.whut.pojo.SysKc;
import com.whut.service.JyGdxfdzService;

@Service
public class JyGdxfdzServiceImpl implements JyGdxfdzService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public List<JyGdxfdz> getAllList() {
		List<SysKc> syskcList = dao.search("from SysKc as n where n.zt!=0");
		Iterator it1 = syskcList.iterator();
		Map map = new HashMap();
		while (it1.hasNext()) {
			SysKc all = (SysKc) it1.next();
			map.put(all.getKcdm(), all);
		}
		List<JyGdxfdz> list1 = dao.search("from  JyGdxfdz as n where n.zt!=0");
		Iterator it2 = list1.iterator();
		while (it2.hasNext()) {
			JyGdxfdz jygdxfdz = (JyGdxfdz) it2.next();
			SysKc jkc = (SysKc) map.get(jygdxfdz.getKcdm());
			// SysKc xkc=(SysKc) map.get(jygdxfdz.getSysKcByXkcdm());
			SysKc xkc = (SysKc) map.get(jygdxfdz.getXkcdm());
			jygdxfdz.setSysKcByKcdm(jkc);
			jygdxfdz.setSysKcByXkcdm(xkc);

		}
		return list1;
	}

	/**
	 * 根据课程名称查找高低学分记录中的数据
	 * */
	public List<JyGdxfdz> search(String kcm) {

		String hql = "from  JyGdxfdz as n where n.sysKcByKcdm.kczwmc like'"
				+ kcm + "%' and n.zt != 0";
		List<JyGdxfdz> list = dao.search(hql);
		return list;
	}

	/**
	 * 
	 * */
	@Override
	public JyGdxfdz findById(Number id) {
		return (JyGdxfdz) dao.getObject("from JyGdxfdz where id=" + id);
	}

	/**
	 * 增加课程对照
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public void addGdfxdz(JyGdxfdz obJyGdxfdz) {
		List<JyGdxfdz> list = dao.search("from JyGdxfdz where kcdm='"
				+ obJyGdxfdz.getSysKcByKcdm().getKcdm() + "' and xkcdm='"
				+ obJyGdxfdz.getSysKcByXkcdm().getKcdm() + "'");
		if (list.isEmpty()) {
			List<JyGdxfdz> list2 = dao.search("from JyGdxfdz where kcdm='"
					+ obJyGdxfdz.getSysKcByKcdm().getKcdm()
					+ "' and xkcdm is null");
			if (list2.isEmpty()) {
				int maxid = dao.getmaxid("JyGdxfdz", "id").intValue();
				obJyGdxfdz.setKcdm(obJyGdxfdz.getSysKcByKcdm().getKcdm());
				obJyGdxfdz.setXkcdm(obJyGdxfdz.getSysKcByXkcdm().getKcdm());
				BigDecimal idBigDecimal = new BigDecimal(maxid + 1);
				obJyGdxfdz.setId(idBigDecimal);
				obJyGdxfdz.setZt("1");
				dao.add(obJyGdxfdz);
			} else {
				JyGdxfdz obj = list2.get(0);
				obj.setSysKcByKcdm(obJyGdxfdz.getSysKcByKcdm());
				obj.setSysKcByXkcdm(obJyGdxfdz.getSysKcByXkcdm());
				obj.setXkcdm(obJyGdxfdz.getSysKcByXkcdm().getKcdm());
				obj.setZt("1");
				dao.modify(obj);
			}
		} else {
			obJyGdxfdz = list.get(0);
			if (obJyGdxfdz.getZt() == "0") {
				obJyGdxfdz.setZt("1");
				dao.modify(obJyGdxfdz);
			}
		}
	}

	/**
	 * 取消某课程的课程高低学分对照
	 * */
	@Override
	public void clearDZ(int id) {
		JyGdxfdz obj = (JyGdxfdz) dao.getObject("from JyGdxfdz where id = '"
				+ id + "'");
		obj.setXkcdm(null);
		obj.setSysKcByXkcdm(null);
		obj.setZt("0"); //清除后将状态设置为0  wangql
		dao.modify(obj);

	}

}
