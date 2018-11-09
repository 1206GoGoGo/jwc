package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.pojo.JyPyjhkcxx;
import com.whut.pojo.JyPyjhkcxxb;
import com.whut.pojo.JyPyjhyq;
import com.whut.pojo.JyZyxx;
import com.whut.pojo.SysKc;
import com.whut.service.JyPyjhkcxxService;
import com.whut.service.JyPyjhkcxxbService;
import com.whut.service.JyPyjhyqService;
import com.whut.service.JyZyxxService;
import com.whut.service.SysKcService;

@RequestMapping(value="/JyPyjhyq")
@Controller
public class JyPyjhyqController {

	@Autowired
	private JyPyjhyqService jyPyjhyqService; //培养计划要求
	@Autowired
	private JyZyxxService jyZyxxService;  //专业信息
	@Autowired
	private JyPyjhkcxxService jyPyjhkcxxService; //培养计划课程信息
	@Autowired
	private JyPyjhkcxxbService jyPyjhkcxxbService; //培养课程信息b ？？？？？？？？？
	@Autowired
	private SysKcService sysKcService; //课程

	/**
	 * 调整培养计划要求
	 * @param jyPyjhyq
	 */
	@RequestMapping(value="/adjust", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody void adjust(String jxjhh) {
		//JyPyjhyq o = jyPyjhyqService.getPyByJxjhh(jyPyjhyq.getJxjhh());
		JyPyjhyq o = jyPyjhyqService.getPyByJxjhh(jxjhh);
		if (o != null) {
			if (o.getZt() == 1) {
				o.setZt(4);
				jyPyjhyqService.modifyPyjhyq(o);
			} else if (o.getZt() == 4) {
				o.setZt(5);
				jyPyjhyqService.modifyPyjhyq(o);
			} else {
				o.setZt(1);
				jyPyjhyqService.modifyPyjhyq(o);
			}
		}
	}
	
	
	/**
	 * 根据查询条件进行查询
	 * 
	 * 如果某项条件没有指定，则为“0”
	 * */
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public @ResponseBody List<JyPyjhyq> search(String xydm, String zydm, String nj) {

		List<JyPyjhyq> list = jyPyjhyqService.search(xydm, zydm, nj);
		return list;
	}
	
	/**
	 * 修改培养计划要求
	 * @param jyPyjhyq
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,consumes= "application/json")
	public @ResponseBody String modifyPyjhyq(@RequestBody JyPyjhyq jyPyjhyq) {
		JyPyjhyq jyjhyq2 = new JyPyjhyq();
		jyjhyq2.setJxjhh(jyPyjhyq.getJxjhh());
		jyjhyq2.setYwpymbzw(jyPyjhyq.getYwpymbzw());
		jyjhyq2.setYwpymbyw(jyPyjhyq.getYwpymbyw());
		jyjhyq2.setYwpyyqzw(jyPyjhyq.getYwpyyqzw());
		jyjhyq2.setYwpyyqyw(jyPyjhyq.getYwpyyqzw());
		jyPyjhyq.setYwpymbzw("");
		jyPyjhyq.setYwpymbyw("");
		jyPyjhyq.setYwpyyqzw("");
		jyPyjhyq.setYwpyyqyw("");
		jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
		jyPyjhyqService.updatePyjhyq(jyjhyq2);
		return "UpdateSuccess";
	}
	
	
	
	public List<JyPyjhyq> getpyListByZydm(String id) {
		return jyPyjhyqService.getpyListByZydm(id);
	}

	//zydm---jxjhh修改
	public void addPyjhyqInfo(JyPyjhyq jyPyjhyq, String zydm) {
		if (zydm == "") {
			jyPyjhyqService.addPyjhyqInfo(jyPyjhyq);
		} else {
			JyZyxx jyZyxx = jyZyxxService.getZyxxListByjxjhh(zydm);
			jyPyjhyq.setJyZyxx(jyZyxx);
			jyPyjhyqService.addPyjhyqInfo(jyPyjhyq);
		}

	}

	/**
	 * 如果有，逻辑删除（置0）JyPyjhyq
	 * */
	public void delAndUpdata(String jxjhh) {
		JyPyjhyq o = jyPyjhyqService.getPyByJxjhh(jxjhh);
		if (o != null) {
			o.setZt(0);
			jyPyjhyqService.modifyPyjhyq(o);
		}
	}

	public List<JyPyjhyq> getAllList() {
		List<JyPyjhyq> list = jyPyjhyqService.getAllList();
		return list;
	}

	public List<JyPyjhyq> getAll1346List() {
		List<JyPyjhyq> list = jyPyjhyqService.getAll1346List();
		return list;
	}

	public List<JyPyjhyq> getpyListByXydm(String xydm) {
		List<JyPyjhyq> list = jyPyjhyqService.getpyListByXydm(xydm);
		return list;
	}


	

	public List<JyPyjhkcxx> search1(String xydm, String zydm, String nj) {
		List<JyPyjhkcxx> list = jyPyjhkcxxService.search1(xydm, zydm, nj);
		return list;
	}

	public List<JyPyjhyq> search(String zydm, String nj) {
		List<JyPyjhyq> list = jyPyjhyqService.search(zydm, nj);
		return list;
	}

	public JyPyjhyq getPyjhyqByJxjhh(String jxjhh) {
		return jyPyjhyqService.getPyByJxjhh(jxjhh);
	}

	

	/**
	 * 审核通过某处于“3申请调整”状态的教学计划jxjhh
	 * */
	public void sqPass(String jxjhh) {
		JyPyjhyq jyPyjhyq = jyPyjhyqService.getPyByJxjhh(jxjhh);
		jyPyjhyq.setZt(4);
		jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
	}

	/**
	 * 审核通过某处于“5调整待审核”状态的教学计划jxjhh
	 * */
	public void shPass(String jxjhh) /* 2013-4-10 */
	{
		JyPyjhyq jyPyjhyq = jyPyjhyqService.getPyByJxjhh(jxjhh);
		List<JyPyjhkcxxb> list1 = jyPyjhkcxxbService.getAllByjxjhh(jxjhh);
		for (int i = 0; i < list1.size(); i++) {
			JyPyjhkcxxb jyPyjhkcxxb = list1.get(i);
			SysKc Xkc = jyPyjhkcxxb.getSysKc();
			if (jyPyjhkcxxb.getZt() == 1) {
				jyPyjhkcxxbService.delete(jyPyjhkcxxb);
			} else if (jyPyjhkcxxb.getZt() == 0) {
				JyPyjhkcxx Jkcxx = jyPyjhkcxxService.getKcxx(jyPyjhkcxxb.getJxjhh(), Xkc.getKcdm());
				jyPyjhkcxxService.delete(Jkcxx);
				jyPyjhkcxxbService.delete(jyPyjhkcxxb);
			} else if (jyPyjhkcxxb.getZt() == 2 && Xkc.getZt() == 5) {
				Xkc.setZt(1);
				sysKcService.modifyKecheng(Xkc);
				int id = jyPyjhkcxxb.getBid();
				JyPyjhkcxx Jkcxx = jyPyjhkcxxService.getPyjhkcxxById(id);
				Jkcxx.setSysKc(Xkc);
				Jkcxx.setJykkxq(jyPyjhkcxxb.getJykkxq());
				Jkcxx.setKcxz(jyPyjhkcxxb.getKcxz());
				Jkcxx.setKhfs(jyPyjhkcxxb.getKhfs());
				Jkcxx.setSfdezy(jyPyjhkcxxb.getSfdezy());
				Jkcxx.setSfgxkc(jyPyjhkcxxb.getSfgxkc());
				Jkcxx.setSfjxjhyy(jyPyjhkcxxb.getSfjxjhyy());
				Jkcxx.setSfxwk(jyPyjhkcxxb.getSfxwk());
				Jkcxx.setZt(1);
				Jkcxx.setZyfxdm(jyPyjhkcxxb.getZyfxdm());
				Jkcxx.setJyKcmk(jyPyjhkcxxb.getJyKcmk());
				jyPyjhkcxxService.modify(Jkcxx);
				jyPyjhkcxxbService.delete(jyPyjhkcxxb);
			} else if (jyPyjhkcxxb.getZt() == 2 && Xkc.getZt() == 1) {
				int id = jyPyjhkcxxb.getBid();
				JyPyjhkcxx Jkcxx = jyPyjhkcxxService.getPyjhkcxxById(id);
				Jkcxx.setJykkxq(jyPyjhkcxxb.getJykkxq());
				Jkcxx.setKcxz(jyPyjhkcxxb.getKcxz());
				Jkcxx.setKhfs(jyPyjhkcxxb.getKhfs());
				Jkcxx.setSfdezy(jyPyjhkcxxb.getSfdezy());
				Jkcxx.setSfgxkc(jyPyjhkcxxb.getSfgxkc());
				Jkcxx.setSfjxjhyy(jyPyjhkcxxb.getSfjxjhyy());
				Jkcxx.setSfxwk(jyPyjhkcxxb.getSfxwk());
				Jkcxx.setZt(1);
				Jkcxx.setZyfxdm(jyPyjhkcxxb.getZyfxdm());
				Jkcxx.setSysKc(Xkc);
				Jkcxx.setJyKcmk(jyPyjhkcxxb.getJyKcmk());
				jyPyjhkcxxService.modify(Jkcxx);
				jyPyjhkcxxbService.delete(jyPyjhkcxxb);
			} else if (jyPyjhkcxxb.getZt() == 6 && Xkc.getZt() == 4) {
				Xkc.setZt(1);
				sysKcService.modifyKecheng(Xkc);
				JyPyjhkcxx Xkcxx = new JyPyjhkcxx();
				Xkcxx.setJxjhh(jyPyjhkcxxb.getJxjhh());
				Xkcxx.setJykkxq(jyPyjhkcxxb.getJykkxq());
				Xkcxx.setKcxz(jyPyjhkcxxb.getKcxz());
				Xkcxx.setKhfs(jyPyjhkcxxb.getKhfs());
				Xkcxx.setSfdezy(jyPyjhkcxxb.getSfdezy());
				Xkcxx.setSfgxkc(jyPyjhkcxxb.getSfgxkc());
				Xkcxx.setSfjxjhyy(jyPyjhkcxxb.getSfjxjhyy());
				Xkcxx.setSfxwk(jyPyjhkcxxb.getSfxwk());
				Xkcxx.setZt(1);
				Xkcxx.setZyfxdm(jyPyjhkcxxb.getZyfxdm());
				Xkcxx.setSysKc(Xkc);
				Xkcxx.setJyKcmk(jyPyjhkcxxb.getJyKcmk());
				jyPyjhkcxxService.addJyPyjhkcxx(Xkcxx);
				jyPyjhkcxxbService.delete(jyPyjhkcxxb);
			} else if (jyPyjhkcxxb.getZt() == 6 && Xkc.getZt() == 1) {
				JyPyjhkcxx Xkcxx = new JyPyjhkcxx();
				Xkcxx.setJxjhh(jyPyjhkcxxb.getJxjhh());
				Xkcxx.setJykkxq(jyPyjhkcxxb.getJykkxq());
				Xkcxx.setKcxz(jyPyjhkcxxb.getKcxz());
				Xkcxx.setKhfs(jyPyjhkcxxb.getKhfs());
				Xkcxx.setSfdezy(jyPyjhkcxxb.getSfdezy());
				Xkcxx.setSfgxkc(jyPyjhkcxxb.getSfgxkc());
				Xkcxx.setSfjxjhyy(jyPyjhkcxxb.getSfjxjhyy());
				Xkcxx.setSfxwk(jyPyjhkcxxb.getSfxwk());
				Xkcxx.setZt(1);
				Xkcxx.setZyfxdm(jyPyjhkcxxb.getZyfxdm());
				Xkcxx.setSysKc(Xkc);
				Xkcxx.setJyKcmk(jyPyjhkcxxb.getJyKcmk());
				jyPyjhkcxxService.addJyPyjhkcxx(Xkcxx);
				jyPyjhkcxxbService.delete(jyPyjhkcxxb);
			} else if (jyPyjhkcxxb.getZt() == 6 && Xkc.getZt() == 5) {
				Xkc.setZt(1);
				sysKcService.modifyKecheng(Xkc);
				JyPyjhkcxx Xkcxx = new JyPyjhkcxx();
				Xkcxx.setJxjhh(jyPyjhkcxxb.getJxjhh());
				Xkcxx.setJykkxq(jyPyjhkcxxb.getJykkxq());
				Xkcxx.setKcxz(jyPyjhkcxxb.getKcxz());
				Xkcxx.setKhfs(jyPyjhkcxxb.getKhfs());
				Xkcxx.setSfdezy(jyPyjhkcxxb.getSfdezy());
				Xkcxx.setSfgxkc(jyPyjhkcxxb.getSfgxkc());
				Xkcxx.setSfjxjhyy(jyPyjhkcxxb.getSfjxjhyy());
				Xkcxx.setSfxwk(jyPyjhkcxxb.getSfxwk());
				Xkcxx.setZt(1);
				Xkcxx.setZyfxdm(jyPyjhkcxxb.getZyfxdm());
				Xkcxx.setSysKc(Xkc);
				Xkcxx.setJyKcmk(jyPyjhkcxxb.getJyKcmk());
				jyPyjhkcxxService.addJyPyjhkcxx(Xkcxx);
				jyPyjhkcxxbService.delete(jyPyjhkcxxb);
			}
		}
		jyPyjhyq.setZt(1);
		jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
	}

	/**
	 * 审核通过：处于“新建待审核”状态的培养计划
	 * */
	public void endPass(String jxjhh) /* 2013-4-10 */
	{
		JyPyjhyq jyPyjhyq = jyPyjhyqService.getPyByJxjhh(jxjhh);
		List<JyPyjhkcxxb> list1 = jyPyjhkcxxbService.getAllByjxjhh(jxjhh);
		for (int i = 0; i < list1.size(); i++) {
			JyPyjhkcxxb jyPyjhkcxxb = list1.get(i);
			SysKc Xkc = jyPyjhkcxxb.getSysKc();
			if (jyPyjhkcxxb.getZt() == 6) {
				// 对一个完全新建的备用课程信息，直接先将其复制到正式表中
				JyPyjhkcxx Xkcxx = new JyPyjhkcxx();
				Xkcxx.setJxjhh(jyPyjhkcxxb.getJxjhh());
				Xkcxx.setJykkxq(jyPyjhkcxxb.getJykkxq());
				Xkcxx.setKcxz(jyPyjhkcxxb.getKcxz());
				Xkcxx.setKhfs(jyPyjhkcxxb.getKhfs());
				Xkcxx.setSfdezy(jyPyjhkcxxb.getSfdezy());
				Xkcxx.setSfgxkc(jyPyjhkcxxb.getSfgxkc());
				Xkcxx.setSfjxjhyy(jyPyjhkcxxb.getSfjxjhyy());
				Xkcxx.setSfxwk(jyPyjhkcxxb.getSfxwk());
				Xkcxx.setZt(1);
				Xkcxx.setZyfxdm(jyPyjhkcxxb.getZyfxdm());
				Xkcxx.setSysKc(Xkc);
				Xkcxx.setJyKcmk(jyPyjhkcxxb.getJyKcmk());
				jyPyjhkcxxService.addJyPyjhkcxx(Xkcxx);
				if (Xkc.getZt() == 4) {// 课程为新建的
					Xkc.setZt(1);
					sysKcService.modifyKecheng(Xkc);
				} else if (Xkc.getZt() == 5) {// ?????????????????????????????课程在课程库中为学院修改新建
					Xkc.setZt(1);
					sysKcService.modifyKecheng(Xkc);
				}
			jyPyjhkcxxbService.delete(jyPyjhkcxxb); // 每处理一条备用记录，用完后便物理删除新的kcxx
			}
		jyPyjhyq.setZt(1);
		jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
		}
	}

	/**
	 * 审核拒绝：提交 to 保存
	 * */
	public void refuse(String jxjhh) {
		JyPyjhyq jyPyjhyq = jyPyjhyqService.getPyByJxjhh(jxjhh);
		jyPyjhyq.setZt(7);
		jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
	}

	/**
	 * 审核拒绝
	 * */
	public void refuse3To1(String jxjhh) {
		JyPyjhyq jyPyjhyq = jyPyjhyqService.getPyByJxjhh(jxjhh);
		jyPyjhyq.setZt(1);
		jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
	}

	/**
	 * 审核拒绝：调整待审核 to 调整中
	 * */
	public void refuse5To4(String jxjhh) {
		JyPyjhyq jyPyjhyq = jyPyjhyqService.getPyByJxjhh(jxjhh);
		jyPyjhyq.setZt(4);
		jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
	}

	public void deleteJyPyjhkcxx(String jxjhh) {
		List<JyPyjhkcxx> list = jyPyjhkcxxService.getPyjhkcbyjxjhh(jxjhh);
		for (int i = 0; i < list.size(); i++) {
			SysKc sysKc = list.get(i).getSysKc();
			if (sysKc.getZt() == 4) {
				jyPyjhkcxxService.delete(list.get(i));
				sysKcService.deleteKecheng(sysKc);
			}
		}

	}

	public void deleteSqJyPyjhkcxx(String jxjhh) {
		List<JyPyjhkcxx> list = jyPyjhkcxxService.getPyjhkcbyjxjhh(jxjhh);
		for (int i = 0; i < list.size(); i++) {
			SysKc sysKc = list.get(i).getSysKc();
			JyPyjhkcxx jyPyjhkcxx = list.get(i);
			if (sysKc.getZt() == 4 && jyPyjhkcxx.getZt() == 1) {
				jyPyjhkcxxService.delete(jyPyjhkcxx);
				sysKcService.deleteKecheng(sysKc);
			} else if (sysKc.getZt() == 5 && jyPyjhkcxx.getZt() == 2) {
				sysKc.setZt(1);
				sysKcService.modifyKecheng(sysKc);
				jyPyjhkcxx.setZt(1);
				jyPyjhkcxxService.modify(jyPyjhkcxx);
			} else if (sysKc.getZt() == 6 && jyPyjhkcxx.getZt() == 3) {
				jyPyjhkcxxService.delete(jyPyjhkcxx);
				sysKcService.deleteKecheng(sysKc);
			} else if (jyPyjhkcxx.getZt() == 2) {
				jyPyjhkcxx.setZt(0);
				jyPyjhkcxxService.modify(jyPyjhkcxx);
			}
		}

	}

	public List<JyPyjhyq> MHsearch(int cb, String text) {
		List<JyPyjhyq> list = jyPyjhyqService.MHsearch(cb, text);
		return list;
	}

	public void creat() {
		List<JyPyjhyq> list = jyPyjhyqService.getAllList();
		for (int i = 0; i < list.size(); i++) {
			JyPyjhyq jyPyjhyq = list.get(i);
			jyPyjhyq.setZt(4);
			jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
		}
	}

	public List<JyPyjhyq> search1346(String xydm, String zydm, String nj) {
		List<JyPyjhyq> list = jyPyjhyqService.search1346(xydm, zydm, nj);
		return list;

	}

	/*
	 * 获得前面11个专业培养计划List<JyPyjhyq>
	 */
	@RequestMapping(value="/getZt1356List",method = RequestMethod.GET)
	public @ResponseBody List<JyPyjhyq> getZt1356List() /* 2013-1-24新增 */
	{
		List<JyPyjhyq> list = jyPyjhyqService.getZt1356List();
		return list;
	}

	public void xgzt(String jxjhh) /* 2013-1-24新增 */
	{
		JyPyjhyq jyPyjhyq = jyPyjhyqService.getPyByJxjhh(jxjhh);
		/*
		 * List<JyPyjhkcxx> list=jyPyjhkcxxService.getPyjhkcxx(jxjhh); int i=0;
		 * for(i=0;i<list.size();i++) { JyPyjhkcxx Pyjhkcxx=list.get(i);
		 * Pyjhkcxx.setZt(6); jyPyjhkcxxService.modify(Pyjhkcxx); }
		 */
		jyPyjhyq.setZt(4);
		jyPyjhyqService.modifyPyjhyq(jyPyjhyq);
	}

	/**
	 * 添加或覆盖培养计划要求
	 * */
	public void addJyPyjhyq(JyPyjhyq jyPyjhyq) {
		JyPyjhyq o = jyPyjhyqService.getPyByJxjhh(jyPyjhyq.getJxjhh());
		if (o == null) {
			jyPyjhyqService.addPyjhyqInfo(jyPyjhyq);
		} else {
			o.setZt(1);// TODO
			jyPyjhyqService.modifyPyjhyq(o);
		}
	}

	
	
}
