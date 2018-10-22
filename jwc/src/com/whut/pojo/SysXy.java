package com.whut.pojo;

import java.util.Set;

/**
 * SysXy entity. @author MyEclipse Persistence Tools
 */

public class SysXy implements java.io.Serializable {

	// Fields

	private String xydm;
	private String xymc;
	private String xyqc;
	private String xyywmc;
	private int zt;


	/** default constructor */
	public SysXy() {
	}

	/** minimal constructor */
	public SysXy(String xydm, String xymc, int zt) {
		this.xydm = xydm;
		this.xymc = xymc;
		this.zt = zt;
	}

	/** full constructor */
	public SysXy(String xydm, String xymc, String xyqc, String xyywmc, int zt,
			Set sysXs, Set jyTsxxpies) {
		this.xydm = xydm;
		this.xymc = xymc;
		this.xyqc = xyqc;
		this.xyywmc = xyywmc;
		this.zt = zt;
	}

	public String getXydm() {
		return this.xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public String getXymc() {
		return this.xymc;
	}

	public void setXymc(String xymc) {
		this.xymc = xymc;
	}

	public String getXyqc() {
		return this.xyqc;
	}

	public void setXyqc(String xyqc) {
		this.xyqc = xyqc;
	}

	public String getXyywmc() {
		return this.xyywmc;
	}

	public void setXyywmc(String xyywmc) {
		this.xyywmc = xyywmc;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}