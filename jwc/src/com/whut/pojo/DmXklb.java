package com.whut.pojo;

import java.util.Set;

/**
 * DmXklb entity. @author MyEclipse Persistence Tools
 */

public class DmXklb implements java.io.Serializable {

	// Fields

	private String xklbdm;
	private String xklbzwmc;
	private String xklbywmc;
	private int zt;
//	private Set jyZyxxes = new HashSet(0);

	// Constructors

	/** default constructor */
	public DmXklb() {
	}

	/** minimal constructor */
	public DmXklb(String xklbdm, String xklbzwmc, int zt) {
		this.xklbdm = xklbdm;
		this.xklbzwmc = xklbzwmc;
		this.zt = zt;
	}

	/** full constructor */
	public DmXklb(String xklbdm, String xklbzwmc, String xklbywmc, int zt,
			Set jyZyxxes) {
		this.xklbdm = xklbdm;
		this.xklbzwmc = xklbzwmc;
		this.xklbywmc = xklbywmc;
		this.zt = zt;
//		this.jyZyxxes = jyZyxxes;
	}

	// Property accessors

	public String getXklbdm() {
		return this.xklbdm;
	}

	public void setXklbdm(String xklbdm) {
		this.xklbdm = xklbdm;
	}

	public String getXklbzwmc() {
		return this.xklbzwmc;
	}

	public void setXklbzwmc(String xklbzwmc) {
		this.xklbzwmc = xklbzwmc;
	}

	public String getXklbywmc() {
		return this.xklbywmc;
	}

	public void setXklbywmc(String xklbywmc) {
		this.xklbywmc = xklbywmc;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

//	public Set getJyZyxxes() {
//		return this.jyZyxxes;
//	}
//
//	public void setJyZyxxes(Set jyZyxxes) {
//		this.jyZyxxes = jyZyxxes;
//	}

}