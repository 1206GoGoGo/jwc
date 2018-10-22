package com.whut.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.service.JyPyjhkcxxService;

@Service
public class JyPyjhkcxxServiceImpl implements JyPyjhkcxxService {

	@Autowired
	private BaseHibernateDAO dao;
	
	public List<pyjhkcxxZhcxObj> pyjhkcxxZhcx(String whatString, String whereString) {
		// TODO Auto-generated method stub
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

	
}
