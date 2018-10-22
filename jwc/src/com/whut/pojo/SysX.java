package com.whut.pojo;

import java.util.Set;

/**
 * SysX entity. @author MyEclipse Persistence Tools
 */

public class SysX implements java.io.Serializable {

	// Fields

	private String xdm;
	private SysXy sysXy;
	private String xmc;
	private String xywmc;
	private String ssxqdm;
	private String zt;
	// Constructors

	

	/** default constructor */
	public SysX() {
	}

	/** minimal constructor */
	public SysX(String xdm, SysXy sysXy, String xmc, String ssxqdm, String zt) {
		this.xdm = xdm;
		this.sysXy = sysXy;
		this.xmc = xmc;
		this.ssxqdm = ssxqdm;
		this.zt = zt;
	}

	/** full constructor */
	public SysX(String xdm, SysXy sysXy, String xmc, String xywmc,
			String ssxqdm, String zt, Set sysZies) {
		this.xdm = xdm;
		this.sysXy = sysXy;
		this.xmc = xmc;
		this.xywmc = xywmc;
		this.ssxqdm = ssxqdm;
		this.zt = zt;
	}

	// Property accessors

	public String getXdm() {
		return this.xdm;
	}

	public void setXdm(String xdm) {
		this.xdm = xdm;
	}

	public SysXy getSysXy() {
		return this.sysXy;
	}

	public void setSysXy(SysXy sysXy) {
		this.sysXy = sysXy;
	}

	public String getXmc() {
		return this.xmc;
	}

	public void setXmc(String xmc) {
		this.xmc = xmc;
	}

	public String getXywmc() {
		return this.xywmc;
	}

	public void setXywmc(String xywmc) {
		this.xywmc = xywmc;
	}

	public String getSsxqdm() {
		return this.ssxqdm;
	}

	public void setSsxqdm(String ssxqdm) {
		this.ssxqdm = ssxqdm;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

}