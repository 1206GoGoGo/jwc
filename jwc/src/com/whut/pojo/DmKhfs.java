package com.whut.pojo;

/**
 * DmKhfs entity. @author MyEclipse Persistence Tools
 */

public class DmKhfs implements java.io.Serializable {

	// Fields

	private String khfsdm;
	private String khfsmc;
	private String jyksfs;
	private int zt;

	// Constructors

	/** default constructor */
	public DmKhfs() {
	}

	/** minimal constructor */
	public DmKhfs(String khfsdm, String khfsmc, int zt) {
		this.khfsdm = khfsdm;
		this.khfsmc = khfsmc;
		this.zt = zt;
	}

	/** full constructor */
	public DmKhfs(String khfsdm, String khfsmc, String jyksfs, int zt) {
		this.khfsdm = khfsdm;
		this.khfsmc = khfsmc;
		this.jyksfs = jyksfs;
		this.zt = zt;
	}


	public String getKhfsdm() {
		return this.khfsdm;
	}

	public void setKhfsdm(String khfsdm) {
		this.khfsdm = khfsdm;
	}

	public String getKhfsmc() {
		return this.khfsmc;
	}

	public void setKhfsmc(String khfsmc) {
		this.khfsmc = khfsmc;
	}

	public String getJyksfs() {
		return this.jyksfs;
	}

	public void setJyksfs(String jyksfs) {
		this.jyksfs = jyksfs;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}