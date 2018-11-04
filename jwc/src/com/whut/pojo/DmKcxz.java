package com.whut.pojo;

/**
 * DmKcxz entity. @author MyEclipse Persistence Tools
 */

public class DmKcxz implements java.io.Serializable {

	// Fields

	private String kcxzdm;
	private String kcxzmc;
	private String kcxzywqc;
	private String kcxzywjc;
	private int zt;

	// Constructors

	/** default constructor */
	public DmKcxz() {
	}

	/** full constructor */
	public DmKcxz(String kcxzdm, String kcxzmc, int zt) {
		this.kcxzdm = kcxzdm;
		this.kcxzmc = kcxzmc;
		this.zt = zt;
	}

	// Property accessors

	public String getKcxzdm() {
		return this.kcxzdm;
	}

	public void setKcxzdm(String kcxzdm) {
		this.kcxzdm = kcxzdm;
	}

	public String getKcxzmc() {
		return this.kcxzmc;
	}

	public void setKcxzmc(String kcxzmc) {
		this.kcxzmc = kcxzmc;
	}

	public String getKcxzywqc() {
		return kcxzywqc;
	}

	public void setKcxzywqc(String kcxzywqc) {
		this.kcxzywqc = kcxzywqc;
	}

	public String getKcxzywjc() {
		return kcxzywjc;
	}

	public void setKcxzywjc(String kcxzywjc) {
		this.kcxzywjc = kcxzywjc;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}