package com.whut.pojo;

/**
 * JyKcmk entity. @author MyEclipse Persistence Tools
 */

public class JyKcmk implements java.io.Serializable {

	// Fields

	private Integer id;
	private JyKcz jyKcz;
	private String kcmkdm;
	private String kcmkmc;
	private Integer mkkcs;
	private Integer zt;

	// Constructors

	/** default constructor */
	public JyKcmk() {
	}

	/** minimal constructor */
	public JyKcmk(Integer id, String kcmkdm, String kcmkmc, Integer zt) {
		this.id = id;
		this.kcmkdm = kcmkdm;
		this.kcmkmc = kcmkmc;
		this.zt = zt;
	}

	/** full constructor */
	public JyKcmk(Integer id, JyKcz jyKcz, String kcmkdm, String kcmkmc,
			Integer mkkcs, Integer zt) {
		this.id = id;
		this.jyKcz = jyKcz;
		this.kcmkdm = kcmkdm;
		this.kcmkmc = kcmkmc;
		this.mkkcs = mkkcs;
		this.zt = zt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JyKcz getJyKcz() {
		return this.jyKcz;
	}

	public void setJyKcz(JyKcz jyKcz) {
		this.jyKcz = jyKcz;
	}

	public String getKcmkdm() {
		return this.kcmkdm;
	}

	public void setKcmkdm(String kcmkdm) {
		this.kcmkdm = kcmkdm;
	}

	public String getKcmkmc() {
		return this.kcmkmc;
	}

	public void setKcmkmc(String kcmkmc) {
		this.kcmkmc = kcmkmc;
	}

	public Integer getMkkcs() {
		return this.mkkcs;
	}

	public void setMkkcs(Integer mkkcs) {
		this.mkkcs = mkkcs;
	}

	public Integer getZt() {
		return this.zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

}