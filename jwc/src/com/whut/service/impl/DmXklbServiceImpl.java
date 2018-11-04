package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.DmKcxz;
import com.whut.pojo.DmXklb;
import com.whut.service.DmXklbService;

@Service
public class DmXklbServiceImpl implements DmXklbService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public String checkXklbdm(String xklbdm) {
		String hql = "from DmXklb";
		List<DmXklb> list = dao.search(hql);
		Iterator<DmXklb> it = list.iterator();
		while (it.hasNext()) {
			DmXklb all = it.next();
			if (all.getXklbdm().equals(xklbdm)) {
				return "exist";
			}
		}
		return "noexist";
	}

	@Override
	public String getXklbdm() {
		int max = 0;
		int temp = 0;
		List<DmXklb> list = dao.search("from DmXklb");
		for (int i = 0; i < list.size(); i++) {
			temp = Integer.parseInt(list.get(i).getXklbdm());
			if (max < temp) {
				max = temp;
			}
		}
		return String.valueOf(max + 1);
	}

	@Override
	public void deleteXklb(DmXklb sysXklb) {
		sysXklb.setZt(0);
		dao.modify(sysXklb);
	}

	@Override
	public void addXklb(String xklbdm) {

	}

	@Override
	public void modifyXklb(DmXklb sysXklb) {
		dao.modify(sysXklb);
	}

	@Override
	public List<DmXklb> getAllList() {
		return dao.search("from DmXklb as n where n.zt=1 order by xklbdm ASC");
	}
	
	//新添加（通过学科类别代码获取学科类别）
	public DmXklb getXklbById(String xklbdm) {
		String hql = "from DmXklb as n where n.xklbdm = '" + xklbdm + "'";
		return (DmXklb) dao.getObject(hql);
	}

	@Override
	public void addDxklb(DmXklb sysXklb) {
		dao.add(sysXklb);
	}
}
