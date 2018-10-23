package com.whut.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.DmKclb;
import com.whut.pojo.DmKcxz;
import com.whut.service.DmKcxzService;

@Service
public class DmKcxzServiceImpl implements DmKcxzService {
	
	@Autowired
	private BaseHibernateDAO dao;
	
	@Override
	public void addDkcxz(DmKcxz sysKcxz) {
		// TODO Auto-generated method stub
		dao.add(sysKcxz);

	}

	@Override
	public List<DmKcxz> getAllList() {
		String hql = "from DmKcxz as n where n.zt=1 order by kcxzmc ASC";
		return dao.search(hql);
	}
	
	//新添加（通过课程性质代码获取课程性质）
	public DmKcxz getKcxzById(String kcxzdm) {
		String hql = "from DmKcxz as n where n.kcxzdm = '" + kcxzdm + "'";
		return (DmKcxz) dao.search(hql);
	}

	@Override
	public String checkKcxzdm(String kcxzdm) {
		// TODO Auto-generated method stub
		String hql = "from DmKclb";
		@SuppressWarnings("unchecked")
		List<DmKclb> list = dao.search(hql);
		Iterator<DmKclb> it = list.iterator();
		while (it.hasNext()) {
			DmKclb all = it.next();
			if (all.getKclbdm().equals(kcxzdm)) {
				return "exist";
			}
		}
		return "noexist";
	}

	@Override
	public String getKcxzdm() {
		// TODO Auto-generated method stub
		int max = 0;
		int temp = 0;
		List<DmKcxz> list = dao.search("from DmKcxz");
		for (int i = 0; i < list.size(); i++) {
			temp = Integer.parseInt(list.get(i).getKcxzdm());
			if (max < temp) {
				max = temp;
			}
		}
		return String.valueOf(max + 1);
	}

	@Override
	public void modifyKcxz(DmKcxz sysKcxz) {
		// TODO Auto-generated method stub
		dao.modify(sysKcxz);
	}

	@Override
	public void deleteKcxz(DmKcxz sysKcxz) {
		// TODO Auto-generated method stub
		sysKcxz.setZt(0);
		dao.modify(sysKcxz);
	}

}
