package com.whut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.SysKc;
import com.whut.service.ExcelService;
import com.whut.utils.ExcelTools;

//import config.Jdbc;
@Service
public class ExcelServiceImpl implements ExcelService{
	@Autowired
	private BaseHibernateDAO dao;
	
	private ExcelTools excelTools;
	public ExcelServiceImpl(){
		this.excelTools = new ExcelTools();
	}
	
	
	@Override
	public String importKcjj(String path) {
		List<SysKc> list=new ArrayList<SysKc>();
		list.addAll(excelTools.getKcjjList(path));
		//Jdbc jdbc = new Jdbc();
		int count = 0;
		for(int i=0;i<list.size();i++){
			String hql = "from SysKc as n where n.kcdm='"+list.get(i).getKcdm()+"'";
			SysKc sysKc = (SysKc) dao.getObject(hql);//通过课程代码从数据库中获取课程对象
			if(sysKc!=null){
				String kcjj = list.get(i).getKcjj();
				/*if(kcjj.length()>=600){
					String sql = "update jwxt.sys_kc set kcjj='"+kcjj+"'"+" where kcdm='"+list.get(i).getKcdm()+"'";
					jdbc.update(sql);					
				}else{
					sysKc.setKcjj(list.get(i).getKcjj());//设置课程的课程简介
					dao.modify(sysKc);
				}*/		
				sysKc.setKcjj(kcjj); //设置课程的课程简介
				dao.modify(sysKc);
				count++;
			}
		}
		return String.valueOf(count);
	}	
}
