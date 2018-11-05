package com.whut.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.pojo.pyjhkcxxZhcxObjF;
import com.whut.pojo.pyjhkcxxZhcxObjM;
import com.whut.service.DocProgramService;
import com.whut.service.JyPyjhkcxxService;
import com.whut.service.impl.JyPyjhkcxxServiceImpl;

@RequestMapping(value="/ExportToExcel")
@Controller
public class ExportToExcelController {

	@Autowired
	private DocProgramService docProgramService;
	@Autowired
	private JyPyjhkcxxService jyPyjhkcxxService;
	
	
	//导出Excel
	@RequestMapping(value="/pyjhkcxxZhcxToExcel",method = RequestMethod.GET)
	public @ResponseBody void pyjhkcxxZhcxToExcel(String xuanzezd,String wherezd,String filepath) {
		
		//xuanzezd是查询要显示的字段、wherezd是查询条件
		List<pyjhkcxxZhcxObj>datas = jyPyjhkcxxService.pyjhkcxxZhcx(xuanzezd,wherezd);
		
		int len = datas.size();
		pyjhkcxxZhcxObjM nameobj = new pyjhkcxxZhcxObjM();
		pyjhkcxxZhcxObjF flagobj = new pyjhkcxxZhcxObjF();
		xuanzezd += ",";
		Matcher m = Pattern.compile("as(.*?),").matcher(xuanzezd);
		while (m.find()) {
			String st = m.group(1).trim().toUpperCase();
			if (st.equals("CJXJHH")) {
				flagobj.setCJXJHHF(true);
				continue;
			}
			if (st.equals("CNJ")) {
				flagobj.setCNJF(true);
				continue;
			}
			if (st.equals("CSKXYDM")) {
				flagobj.setCSKXYDMF(true);
				continue;
			}
			if (st.equals("CSKXYMC")) {
				flagobj.setCSKXYMCF(true);
				continue;
			}
			if (st.equals("CSKZYDM")) {
				flagobj.setCSKZYDMF(true);
				continue;
			}
			if (st.equals("CSKZYMC")) {
				flagobj.setCSKZYMCF(true);
				continue;
			}
			if (st.equals("CKCDM")) {
				flagobj.setCKCDMF(true);
				continue;
			}
			if (st.equals("CKCMC")) {
				flagobj.setCKCMCF(true);
				continue;
			}
			if (st.equals("KKXYDM")) {
				flagobj.setKKXYDMF(true);
				continue;
			}
			if (st.equals("KKXYMC")) {
				flagobj.setKKXYMCF(true);
				continue;
			}
			if (st.equals("CKKXQ")) {
				flagobj.setCKKXQF(true);
				continue;
			}
			if (st.equals("CKHFS")) {
				flagobj.setCKHFSF(true);
				continue;
			}
			if (st.equals("CKCXZ")) {
				flagobj.setCKCXZF(true);
				continue;
			}
			if (st.equals("CZT")) {
				flagobj.setCZTF(true);
				continue;
			}
			if (st.equals("CSFXWK")) {
				flagobj.setCSFXWKF(true);
				continue;
			}
			if (st.equals("CSFGXKC")) {
				flagobj.setCSFGXKCF(true);
				continue;
			}
			if (st.equals("CSFDEZY")) {
				flagobj.setCSFDEZYF(true);
				continue;
			}
			if (st.equals("CKCZMC")) {
				flagobj.setCKCZMCF(true);
				continue;
			}
			if (st.equals("KCMKMC")) {
				flagobj.setKCMKMCF(true);
				continue;
			}
			if (st.equals("CKCLB")) {
				flagobj.setCKCLBF(true);
				continue;
			}
			if (st.equals("CXF")) {
				flagobj.setCXFF(true);
				continue;
			}
			if (st.equals("CZXS")) {
				flagobj.setCZXSF(true);
				continue;
			}
			if (st.equals("CLLXS")) {
				flagobj.setCLLXSF(true);
				continue;
			}
			if (st.equals("CSYXS")) {
				flagobj.setCSYXSF(true);
				continue;
			}
			if (st.equals("CSJXS")) {
				flagobj.setCSJXSF(true);
				continue;
			}
			if (st.equals("CKWXS")) {
				flagobj.setCKWXSF(true);
				continue;
			}
			if (st.equals("CSJXS2")) {
				flagobj.setCSJXS2F(true);
				continue;
			}
			if (st.equals("CZYFXMC")) {
				flagobj.setCZYFXMCF(true);
				continue;
			}
		}
		docProgramService.pyjhkcxxZhcxToExcel(datas, nameobj, flagobj, len,
				filepath);
	}
}
