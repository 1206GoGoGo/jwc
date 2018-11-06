package com.whut.pojo;

import java.math.BigDecimal;

/**
 * JyGdxfdz entity. @author MyEclipse Persistence Tools
 */

public class JyGdxfdz implements java.io.Serializable {

	// Fields
	private SysKc sysKcByKcdm;
	private SysKc sysKcByXkcdm;
	
	// Constructors
	private BigDecimal id;
	private String kcdm;
	private String xkcdm;
	private String zt;

	public JyGdxfdz() {
	}
	public JyGdxfdz(BigDecimal id, String kcdm, String zt) {
		this.id = id;
		this.kcdm = kcdm;
		this.zt = zt;
	}

	
	public JyGdxfdz(BigDecimal id, String kcdm, String xkcdm, String zt) {
		this.id = id;
		this.kcdm = kcdm;
		this.xkcdm = xkcdm;
		this.zt = zt;
	}

	
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getKcdm() {
		return this.kcdm;
	}

	public void setKcdm(String kcdm) {
		this.kcdm = kcdm;
	}

	public String getXkcdm() {
		return this.xkcdm;
	}

	public void setXkcdm(String xkcdm) {
		this.xkcdm = xkcdm;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public SysKc getSysKcByKcdm() {
		return this.sysKcByKcdm;
	}

	public void setSysKcByKcdm(SysKc sysKcByKcdm) {
		this.sysKcByKcdm = sysKcByKcdm;
	}

	public SysKc getSysKcByXkcdm() {
		return this.sysKcByXkcdm;
	}

	public void setSysKcByXkcdm(SysKc sysKcByXkcdm) {
		this.sysKcByXkcdm = sysKcByXkcdm;
	}

}