package com.whut.pojo;

import java.util.Set;

/**
 * JyXxgs entity. @author MyEclipse Persistence Tools
 */

public class JyXxgs implements java.io.Serializable {

	// Fields

	private String xxgsdm;
	private String xxgsmc;
	private int zt;
	
	// Constructors

	/** default constructor */
	public JyXxgs() {
	}

	/** minimal constructor */
	public JyXxgs(String xxgsdm, String xxgsmc, int zt) {
		this.xxgsdm = xxgsdm;
		this.xxgsmc = xxgsmc;
		this.zt = zt;
	}

	/** full constructor */
	public JyXxgs(String xxgsdm, String xxgsmc, int zt, Set sysKcs,
			Set jyTsxxpies) {
		this.xxgsdm = xxgsdm;
		this.xxgsmc = xxgsmc;
		this.zt = zt;
	}

	// Property accessors

	public String getXxgsdm() {
		return this.xxgsdm;
	}

	public void setXxgsdm(String xxgsdm) {
		this.xxgsdm = xxgsdm;
	}

	public String getXxgsmc() {
		return this.xxgsmc;
	}

	public void setXxgsmc(String xxgsmc) {
		this.xxgsmc = xxgsmc;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}