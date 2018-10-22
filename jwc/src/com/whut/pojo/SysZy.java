package com.whut.pojo;


import java.util.Set;

/**
 * SysZy entity. @author MyEclipse Persistence Tools
 */

public class SysZy implements java.io.Serializable {

	// Fields

	private String zydm;
	private SysX sysX;
	private String zymc;
	private String xw;
	private String zypymb;
	private String zypyyq;
	private String xydm;
	private String zyqc;
	private String tjzydm;
	private String cc;
	private int zt;
	private int xz;
	private String ssxqdm;
	private String zyywmc;

	// Constructors

	/** default constructor */
	public SysZy() {
	}

	/** minimal constructor */
	public SysZy(String zydm, String zymc, int zt, int xz,
			String ssxqdm) {
		this.zydm = zydm;
		this.zymc = zymc;
		this.zt = zt;
		this.xz = xz;
		this.ssxqdm = ssxqdm;
	}

	/** full constructor */
	public SysZy(String zydm, SysX sysX, String zymc, String xzzw, String xwzw,
			String zypymb, String zyypyyq, String xydm, String zyqc,
			String tjzydm, String cc, int zt, String xzyw, String xwyw,
			int xz, String ssxqdm, Set jyKckxjyses) {
		this.zydm = zydm;
		this.sysX = sysX;
		this.zymc = zymc;
		this.xw = xw;
		this.zypymb = zypymb;
		this.zypyyq = zypyyq;
		this.xydm = xydm;
		this.zyqc = zyqc;
		this.tjzydm = tjzydm;
		this.cc = cc;
		this.zt = zt;
		this.xz = xz;
		this.ssxqdm = ssxqdm;
	}

	// Property accessors

	public String getZydm() {
		return this.zydm;
	}

	public void setZydm(String zydm) {
		this.zydm = zydm;
	}

	public SysX getSysX() {
		return this.sysX;
	}

	public void setSysX(SysX sysX) {
		this.sysX = sysX;
	}

	public String getZymc() {
		return this.zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getXw() {
		return this.xw;
	}

	public void setXw(String xw) {
		this.xw = xw;
	}

	public String getZypymb() {
		return this.zypymb;
	}

	public void setZypymb(String zypymb) {
		this.zypymb = zypymb;
	}

	public String getZypyyq() {
		return this.zypyyq;
	}

	public void setZypyyq(String zypyyq) {
		this.zypyyq = zypyyq;
	}

	public String getXydm() {
		return this.xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public String getZyqc() {
		return this.zyqc;
	}

	public void setZyqc(String zyqc) {
		this.zyqc = zyqc;
	}

	public String getTjzydm() {
		return this.tjzydm;
	}

	public void setTjzydm(String tjzydm) {
		this.tjzydm = tjzydm;
	}

	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public int getXz() {
		return this.xz;
	}

	public void setXz(int xz) {
		this.xz = xz;
	}

	public String getSsxqdm() {
		return this.ssxqdm;
	}

	public void setSsxqdm(String ssxqdm) {
		this.ssxqdm = ssxqdm;
	}

	public String getZyywmc() {
		return zyywmc;
	}

	public void setZyywmc(String zyywmc) {
		this.zyywmc = zyywmc;
	}

}