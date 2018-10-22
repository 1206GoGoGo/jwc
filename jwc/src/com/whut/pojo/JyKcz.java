package com.whut.pojo;

/**
 * JyKcz entity. @author MyEclipse Persistence Tools
 */

public class JyKcz implements java.io.Serializable {

	// Fields

	private Integer id;
	private String kczdm;
	private String kczmc;
	private String jxjhh;
	private Double kczxf;
	private Byte mks;
	private String bz;
	private int zt;

	// Constructors

	/** default constructor */
	public JyKcz() {
	}

	/** minimal constructor */
	public JyKcz(Integer id, String kczdm, String kczmc, String jxjhh,
			int zt) {
		this.id = id;
		this.kczdm = kczdm;
		this.kczmc = kczmc;
		this.jxjhh = jxjhh;
		this.zt = zt;
	}

	/** full constructor */
	public JyKcz(Integer id, String kczdm, String kczmc, String jxjhh,
			Double kczxf, Byte mks, String bz, int zt) {
		this.id = id;
		this.kczdm = kczdm;
		this.kczmc = kczmc;
		this.jxjhh = jxjhh;
		this.kczxf = kczxf;
		this.mks = mks;
		this.bz = bz;
		this.zt = zt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKczdm() {
		return this.kczdm;
	}

	public void setKczdm(String kczdm) {
		this.kczdm = kczdm;
	}

	public String getKczmc() {
		return this.kczmc;
	}

	public void setKczmc(String kczmc) {
		this.kczmc = kczmc;
	}

	public String getJxjhh() {
		return this.jxjhh;
	}

	public void setJxjhh(String jxjhh) {
		this.jxjhh = jxjhh;
	}

	public Double getKczxf() {
		return this.kczxf;
	}

	public void setKczxf(Double kczxf) {
		this.kczxf = kczxf;
	}

	public Byte getMks() {
		return this.mks;
	}

	public void setMks(Byte mks) {
		this.mks = mks;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}