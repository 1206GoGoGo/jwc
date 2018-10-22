package com.whut.pojo;

import java.util.Date;

/**
 * JyXxtx entity. @author MyEclipse Persistence Tools
 */

public class JyXxtx implements java.io.Serializable {

	// Fields

	private int xxdm;
	private String fsf;
	private String jsf;
	private String xxbt;
	private String xxnr;
	private Date fssj;
	private int xxzt;
	private int zt;

	// Constructors

	/** default constructor*/
	public JyXxtx() {
	}

	/** minimal constructor*/
	public JyXxtx(int xxdm, String fsf, String jsf, String xxnr, Date fssj,
			int xxzt, int zt) {
		this.xxdm = xxdm;
		this.fsf = fsf;
		this.jsf = jsf;
		this.xxnr = xxnr;
		this.fssj = fssj;
		this.xxzt = xxzt;
		this.zt = zt;
	}

	/** full constructor*/
	public JyXxtx(int xxdm, String fsf, String jsf, String xxbt, String xxnr,
			Date fssj, int xxzt, int zt) {
		this.xxdm = xxdm;
		this.fsf = fsf;
		this.jsf = jsf;
		this.xxbt = xxbt;
		this.xxnr = xxnr;
		this.fssj = fssj;
		this.xxzt = xxzt;
		this.zt = zt;
	}

	// Property accessors

	public int getXxdm() {
		return this.xxdm;
	}

	public void setXxdm(int xxdm) {
		this.xxdm = xxdm;
	}

	public String getFsf() {
		return this.fsf;
	}

	public void setFsf(String fsf) {
		this.fsf = fsf;
	}

	public String getJsf() {
		return this.jsf;
	}

	public void setJsf(String jsf) {
		this.jsf = jsf;
	}

	public String getXxbt() {
		return this.xxbt;
	}

	public void setXxbt(String xxbt) {
		this.xxbt = xxbt;
	}

	public String getXxnr() {
		return this.xxnr;
	}

	public void setXxnr(String xxnr) {
		this.xxnr = xxnr;
	}

	public Date getFssj() {
		return this.fssj;
	}

	public void setFssj(Date fssj) {
		this.fssj = fssj;
	}

	public int getXxzt() {
		return this.xxzt;
	}

	public void setXxzt(int xxzt) {
		this.xxzt = xxzt;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}