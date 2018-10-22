package com.whut.pojo;

/**
 * SysXq entity. @author MyEclipse Persistence Tools
 */

public class SysXq implements java.io.Serializable {

	// Fields

	private String xqdm;
	private String xqmc;
	private String xqjp;
	private String zt;

	// Constructors

	/** default constructor */
	public SysXq() {
	}

	/** full constructor */
	public SysXq(String xqdm, String xqmc, String xqjp, String zt) {
		this.xqdm = xqdm;
		this.xqmc = xqmc;
		this.xqjp = xqjp;
		this.zt = zt;
	}

	// Property accessors

	public String getXqdm() {
		return this.xqdm;
	}

	public void setXqdm(String xqdm) {
		this.xqdm = xqdm;
	}

	public String getXqmc() {
		return this.xqmc;
	}

	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}

	public String getXqjp() {
		return this.xqjp;
	}

	public void setXqjp(String xqjp) {
		this.xqjp = xqjp;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

}