package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.DmKclb;
import com.whut.service.DmKclbService;


@Service
public class DmKclbServiceImpl implements DmKclbService {

	@Autowired
	private BaseHibernateDAO dao;

	@Override
	public void addDkclb(DmKclb dmKclb) {
		dao.add(dmKclb);
	}

	@Override
	public List<DmKclb> getAllList() {
		String hql = "from DmKclb as n where n.zt=1 order by kclbmc ASC";
		return dao.search(hql);
	}

	/*@Override
	public String getKclbdm() {
		// TODO Auto-generated method stub
		int max = 0;
		char temp[];
		List<DmKclb> list = dao.search("from DmKclb ");
		for (int i = 0; i < list.size(); i++) {
			temp = (list.get(i).getKclbdm()).toCharArray();
			int c = temp[0];
			if (max < c) {
				max = c;
			}
		}
		char d = (char) (max + 1);
		return String.valueOf(d);
	}*/
	
	@Override
	public String getKclbdm() { //wql更改
		// TODO Auto-generated method stub
		char max = '0';
		char temp[];
		List<DmKclb> list = dao.search("from DmKclb ");
		for (int i = 0; i < list.size(); i++) {
			temp = (list.get(i).getKclbdm()).toCharArray();
			char c = temp[0];
			if (max < c) {
				max = c;
			}
		}
		char d = (char) (max + 1);

		if(max == '9') {  //10为A
			d = 'A';
		}
		return String.valueOf(d);
	}

	@Override
	public int getIndex(String kclbdm) {
		// TODO Auto-generated method stub
		List<DmKclb> list = dao.search("from DmKclb as n where n.zt=1 order by kclbdm ASC");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKclbdm().equals(kclbdm)) {

				return i;
			}
		}
		return -1;
	}

	@Override
	public String checkKclbdm(String kclbdm) {
		// TODO Auto-generated method stub
		String hql = "from DmKclb";
		List<DmKclb> list = dao.search(hql);
		Iterator<DmKclb> it = list.iterator();
		while (it.hasNext()) {
			DmKclb all = it.next();
			if (all.getKclbdm().equals(kclbdm)) {
				return "exist";
			}
		}
		return "noexist";

	}

	@Override
	public void modifyKclb(DmKclb dmKclb) {
		// TODO Auto-generated method stub
		dao.modify(dmKclb);
	}

	@Override
	public void deleteKclb(DmKclb dmKclb) {
		// TODO Auto-generated method stub
		dmKclb.setZt(0);
		dao.modify(dmKclb);
	}

	@Override
	public void setZt(String Kclbdm) {
		// TODO Auto-generated method stub
		String hql = "from DmKclb as n where n.kclbdm='" + Kclbdm + "'";
		List<DmKclb> list = dao.search(hql);
		if (list.size() > 0) {
			DmKclb sysKclb = list.get(0);
			sysKclb.setZt(3);
		}

	}

	@Override
	public DmKclb getkclbBykclbdm(String kclbdm) {
		String hql = "from DmKclb as n where n.kclbdm='" + kclbdm + "'";
		return (DmKclb) dao.getObject(hql);
	}

}
