package com.whut.pojo;

import java.math.BigDecimal;
import java.util.Set;

import org.hibernate.dialect.function.VarArgsSQLFunction;

/**
 * SysKc entity. @author MyEclipse Persistence Tools
 */

public class SysKc implements java.io.Serializable {

	// Fields

	private String kcdm; //课程代码
	
	private DmKclb dmKclb;//课程类别代码
	private JyXxgs jyXxgs;//选修归属
	
	private String kczwmc; //课程中文名称
	private String kcywmc;//开课部门
	private String xf;  //学分
	private String kcxz;//课程性质
	private String xydm;//学院代码
	private String xdm;//系代码
	private String yxyqdm;//预修要求
	private String kcjj; //课程简介
	private String kcywjj;//课程英文简介
	private Double zhxs; //总学时
	private Double llxs; //讲课学时
	private Double syxs;//实验学时
	private Double sjxs;//更改为实践学时
	private String kczyzyjmd;//需要与目的
	private String zycks;//主要参考书
	private String bz; //备注
	private String kcqmc;
	private String kclbmc;//课程类别名称
	private Double kwxs; //课外学时
	private Double sjxs2;//更改为上机学时
	private String kcyl1;
	private String kcyl2;
	private String sfqy;
	private String kcyl4;
	private String kcyl5;
	private String kcyl6;
	private String kcyl7;
	private String kcyl8;
	private String kcyl9;
	private String kcyl10;
	private Double sjzs;//实践周数
	private int zt;//状态

	// Constructors

	/** default constructor */
	public SysKc() {
	}

	/** minimal constructor */
	public SysKc(String kcdm, String kczwmc) {
		this.kcdm = kcdm;
		this.kczwmc = kczwmc;
	}

	/** full constructor */
	public SysKc(String kcdm, DmKclb dmKclb, JyXxgs jyXxgs, String kczwmc,
			String kcywmc, String xf, String kcxz, String xydm, String xdm,
			String yxyqdm, String kcjj, String kcywjj, Double zhxs,
			Double llxs, Double syxs, Double sjxs, String kczyzyjmd,
			String zycks, String bz, String kcqmc, String kclbmc, Double kwxs,
			Double sjxs2, String kcyl1, String kcyl2, String sfqy,
			String kcyl4, String kcyl5, String kcyl6, String kcyl7,
			String kcyl8, String kcyl9, String kcyl10, Double sjzs, int zt,
			Set jyGdxfdzsForXkcdm, Set jyGdxfdzsForKcdm, Set jyTsxxpies,
			Set jyPyjhkcxxes) {
		this.kcdm = kcdm;
		this.dmKclb = dmKclb;
		this.jyXxgs = jyXxgs;
		this.kczwmc = kczwmc;
		this.kcywmc = kcywmc;
		this.xf = xf;
		this.kcxz = kcxz;
		this.xydm = xydm;
		this.xdm = xdm;
		this.yxyqdm = yxyqdm;
		this.kcjj = kcjj;
		this.kcywjj = kcywjj;
		this.zhxs = zhxs;
		this.llxs = llxs;
		this.syxs = syxs;
		this.sjxs = sjxs;
		this.kczyzyjmd = kczyzyjmd;
		this.zycks = zycks;
		this.bz = bz;
		this.kcqmc = kcqmc;
		this.kclbmc = kclbmc;
		this.kwxs = kwxs;
		this.sjxs2 = sjxs2;
		this.sfqy = sfqy;
		this.kcyl1 = kcyl1;
		this.kcyl2 = kcyl2;
		this.sfqy = sfqy;
		this.kcyl4 = kcyl4;
		this.kcyl5 = kcyl5;
		this.kcyl6 = kcyl6;
		this.kcyl7 = kcyl7;
		this.kcyl8 = kcyl8;
		this.kcyl9 = kcyl9;
		this.kcyl10 = kcyl10;
		this.sjzs = sjzs;
		this.zt = zt;
		
	}

	// Property accessors

	public String getKcdm() {
		return this.kcdm;
	}

	public void setKcdm(String kcdm) {
		this.kcdm = kcdm;
	}

	public DmKclb getDmKclb() {
		return this.dmKclb;
	}

	public void setDmKclb(DmKclb dmKclb) {
		this.dmKclb = dmKclb;
	}

	public JyXxgs getJyXxgs() {
		return this.jyXxgs;
	}

	public void setJyXxgs(JyXxgs jyXxgs) {
		this.jyXxgs = jyXxgs;
	}

	public String getKczwmc() {
		return this.kczwmc;
	}

	public void setKczwmc(String kczwmc) {
		this.kczwmc = kczwmc;
	}

	public String getKcywmc() {
		return this.kcywmc;
	}

	public void setKcywmc(String kcywmc) {
		this.kcywmc = kcywmc;
	}

	public String getXf() {
		return this.xf;
	}

	public void setXf(String xf) {
		this.xf = xf;
	}

	public String getKcxz() {
		return this.kcxz;
	}

	public void setKcxz(String kcxz) {
		this.kcxz = kcxz;
	}

	public String getXydm() {
		return this.xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public String getXdm() {
		return this.xdm;
	}

	public void setXdm(String xdm) {
		this.xdm = xdm;
	}

	public String getYxyqdm() {
		return this.yxyqdm;
	}

	public void setYxyqdm(String yxyqdm) {
		this.yxyqdm = yxyqdm;
	}

	public String getKcjj() {
		return this.kcjj;
	}

	public void setKcjj(String kcjj) {
		this.kcjj = kcjj;
	}

	public String getKcywjj() {
		return this.kcywjj;
	}

	public void setKcywjj(String kcywjj) {
		this.kcywjj = kcywjj;
	}

	public Double getZhxs() {
		return this.zhxs;
	}

	public void setZhxs(Double zhxs) {
		this.zhxs = zhxs;
	}

	public Double getLlxs() {
		return this.llxs;
	}

	public void setLlxs(Double llxs) {
		this.llxs = llxs;
	}

	public Double getSyxs() {
		return this.syxs;
	}

	public void setSyxs(Double syxs) {
		this.syxs = syxs;
	}

	public Double getSjxs() {
		return this.sjxs;
	}

	public void setSjxs(Double sjxs) {
		this.sjxs = sjxs;
	}

	public String getKczyzyjmd() {
		return this.kczyzyjmd;
	}

	public void setKczyzyjmd(String kczyzyjmd) {
		this.kczyzyjmd = kczyzyjmd;
	}

	public String getZycks() {
		return this.zycks;
	}

	public void setZycks(String zycks) {
		this.zycks = zycks;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getKcqmc() {
		return this.kcqmc;
	}

	public void setKcqmc(String kcqmc) {
		this.kcqmc = kcqmc;
	}

	public String getKclbmc() {
		return this.kclbmc;
	}

	public void setKclbmc(String kclbmc) {
		this.kclbmc = kclbmc;
	}

	public Double getKwxs() {
		return this.kwxs;
	}

	public void setKwxs(Double kwxs) {
		this.kwxs = kwxs;
	}

	public Double getSjxs2() {
		return this.sjxs2;
	}

	public void setSjxs2(Double sjxs2) {
		this.sjxs2 = sjxs2;
	}

	public String getKcyl1() {
		return kcyl1;
	}

	public void setKcyl1(String kcyl1) {
		this.kcyl1 = kcyl1;
	}

	public String getKcyl2() {
		return this.kcyl2;
	}

	public void setKcyl2(String kcyl2) {
		this.kcyl2 = kcyl2;
	}

	public String getSfqy() {
		return this.sfqy;
	}
	
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}

	public String getKcyl4() {
		return this.kcyl4;
	}

	public void setKcyl4(String kcyl4) {
		this.kcyl4 = kcyl4;
	}

	public String getKcyl5() {
		return this.kcyl5;
	}

	public void setKcyl5(String kcyl5) {
		this.kcyl5 = kcyl5;
	}

	public String getKcyl6() {
		return this.kcyl6;
	}

	public void setKcyl6(String kcyl6) {
		this.kcyl6 = kcyl6;
	}

	public String getKcyl7() {
		return this.kcyl7;
	}

	public void setKcyl7(String kcyl7) {
		this.kcyl7 = kcyl7;
	}

	public String getKcyl8() {
		return this.kcyl8;
	}

	public void setKcyl8(String kcyl8) {
		this.kcyl8 = kcyl8;
	}

	public String getKcyl9() {
		return this.kcyl9;
	}

	public void setKcyl9(String kcyl9) {
		this.kcyl9 = kcyl9;
	}

	public String getKcyl10() {
		return this.kcyl10;
	}

	public void setKcyl10(String kcyl10) {
		this.kcyl10 = kcyl10;
	}

	public Double getSjzs() {
		return sjzs;
	}

	public void setSjzs(Double sjzs) {
		this.sjzs = sjzs;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}


	
}