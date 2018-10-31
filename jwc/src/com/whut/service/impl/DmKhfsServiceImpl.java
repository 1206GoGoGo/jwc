package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.DmKhfs;
import com.whut.service.DmKhfsService;


@Service
public class DmKhfsServiceImpl implements DmKhfsService {
	@Autowired
	private BaseHibernateDAO dao;
	
	@Override
	public String checkKhfsdm(String khfsdm) {
		String hql = "from DmKhfs";
		List list = dao.search(hql);
		Iterator<DmKhfs> it = list.iterator();
		while (it.hasNext()) {
			DmKhfs all = it.next();
			if (all.getKhfsdm().equals(khfsdm)) {
				return "exist";
			}
		}
		return "noexist";

	}

	@Override
	public void addDkhfs(DmKhfs sysKhfs) {
		dao.add(sysKhfs);

	}

	@Override
	public List<DmKhfs> getAllList() {
		String hql = "from DmKhfs as n where n.zt=1  order by khfsdm ASC";
		return dao.search(hql);
	}

	@Override
	public String getKhfsdm() {
		int max = 0;
		int temp = 0;
		List<DmKhfs> list = dao.search("from DmKhfs");
		for (int i = 0; i < list.size(); i++) {
			temp = Integer.parseInt(list.get(i).getKhfsdm());
			if (max < temp) {
				max = temp;
			}
		}
		return String.valueOf(max + 1);
	}

	@Override
	public void modifyKhfs(DmKhfs sysKhfs) {
		dao.modify(sysKhfs);
	}

	@Override
	public void deleteKhfs(DmKhfs sysKhfs) {
		sysKhfs.setZt(0);
		dao.modify(sysKhfs);
	}

	@Override
	public DmKhfs getDmKhfsBydm(String khfsdm) {
		String hql = "from DmKhfs as n where n.khfsdm='" + khfsdm + "'";
		DmKhfs dmKhfs = (DmKhfs) dao.getObject(hql);
		return dmKhfs;
	}
}
