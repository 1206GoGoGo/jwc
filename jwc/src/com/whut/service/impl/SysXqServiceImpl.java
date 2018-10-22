package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.SysXq;
import com.whut.service.SysXqService;

@Service
public class SysXqServiceImpl implements SysXqService {
	
	@Autowired
	private BaseHibernateDAO dao;
	
	public String checkXqdm(String xqdm) {
		String hql = "select xqdm from SysXq ";
		List list = dao.search(hql);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String all = (String) it.next();
			if (all.equals(xqdm)) {
				return "exist";
			}
		}
		return "noexist";

	}

	public void addDxqdm(SysXq sysXq) {
		dao.add(sysXq);
	}

	public List<SysXq> getAllList() {
		String hql = "from SysXq as n where n.zt=1 order by xqdm ASC";
		return dao.search(hql);
	}

	public void modifyXq(SysXq sysXq) {
		dao.modify(sysXq);
	}

	public void deleteXq(String xqdm) {
		SysXq dmXq = (SysXq) dao.getObject("from SysXq  as n where n.xqdm='"
				+ xqdm + "'");
		dmXq.setZt("0");
		dao.modify(dmXq);
	}

	public String getXqdm() {
		List<SysXq> list = dao.search("from SysXq");
		int max = 0;
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {

			temp = Integer.parseInt(list.get(i).getXqdm());
			if (max < temp)
				max = temp;
		}
		return String.valueOf(max + 1);
	}

	public SysXq getXqByXqdm(String xqdm) {
		String hql = "from SysXq as n where n.zt='1' and n.xqdm='" + xqdm + "'";
		return (SysXq) dao.getObject(hql);
	}

}
