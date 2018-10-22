package com.whut.pojo;

import java.util.Set;

/**
 * DmKclb entity. @author MyEclipse Persistence Tools
 */

public class DmKclb implements java.io.Serializable {

	// Fields

	private String kclbdm;
	private String kclbmc;
	private int zt;
	
	// Constructors

	/** default constructor */
	public DmKclb() {
	}

	/** minimal constructor */
	public DmKclb(String kclbdm, String kclbmc, int zt) {
		this.kclbdm = kclbdm;
		this.kclbmc = kclbmc;
		this.zt = zt;
	}

	/** full constructor */
	public DmKclb(String kclbdm, String kclbmc, int zt, Set sysKcs) {
		this.kclbdm = kclbdm;
		this.kclbmc = kclbmc;
		this.zt = zt;
	}

	// Property accessors

	public String getKclbdm() {
		return this.kclbdm;
	}

	public void setKclbdm(String kclbdm) {
		this.kclbdm = kclbdm;
	}

	public String getKclbmc() {
		return this.kclbmc;
	}

	public void setKclbmc(String kclbmc) {
		this.kclbmc = kclbmc;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}