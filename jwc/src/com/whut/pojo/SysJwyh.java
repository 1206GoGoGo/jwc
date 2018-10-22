package com.whut.pojo;

/**
 * SysJwyh entity. @author MyEclipse Persistence Tools
 */

public class SysJwyh implements java.io.Serializable {

	// Fields

	private String yhm;
	private String js;
	private String xm;
	private String szdw;
	private String ty;
	private String xqdm;
	private String ipdz;
	private String macdz;
	private int zt;
	private String emldz;
	private String lxdh;

	// Constructors

	/** default constructor */
	public SysJwyh() {
	}

	/** minimal constructor */
	public SysJwyh(String yhm, String js, int zt) {
		this.yhm = yhm;
		this.js = js;
		this.zt = zt;
	}

	/** full constructor */
	public SysJwyh(String yhm, String js, String xm, String szdw, String ty,
			String xqdm, String ipdz, String macdz, int zt,
			String emldz, String lxdh) {
		this.yhm = yhm;
		this.js = js;
		this.xm = xm;
		this.szdw = szdw;
		this.ty = ty;
		this.xqdm = xqdm;
		this.ipdz = ipdz;
		this.macdz = macdz;
		this.zt = zt;
		this.emldz = emldz;
		this.lxdh = lxdh;
	}

	// Property accessors

	public String getYhm() {
		return this.yhm;
	}

	public void setYhm(String yhm) {
		this.yhm = yhm;
	}

	public String getJs() {
		return this.js;
	}

	public void setJs(String js) {
		this.js = js;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSzdw() {
		return this.szdw;
	}

	public void setSzdw(String szdw) {
		this.szdw = szdw;
	}

	public String getTy() {
		return this.ty;
	}

	public void setTy(String ty) {
		this.ty = ty;
	}

	public String getXqdm() {
		return this.xqdm;
	}

	public void setXqdm(String xqdm) {
		this.xqdm = xqdm;
	}

	public String getIpdz() {
		return this.ipdz;
	}

	public void setIpdz(String ipdz) {
		this.ipdz = ipdz;
	}

	public String getMacdz() {
		return this.macdz;
	}

	public void setMacdz(String macdz) {
		this.macdz = macdz;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public String getEmldz() {
		return this.emldz;
	}

	public void setEmldz(String emldz) {
		this.emldz = emldz;
	}

	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

}