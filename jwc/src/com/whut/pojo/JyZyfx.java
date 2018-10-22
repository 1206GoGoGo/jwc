package com.whut.pojo;

/**
 * JyZyfx entity. @author MyEclipse Persistence Tools
 */

public class JyZyfx implements java.io.Serializable {

	// Fields

	private String zyfxdm;
	private SysZy sysZy;
	private String zyfxzwmc;
	private String zyfxywmc;
	private Double xxxfyq;
	private Double bxxfyq;
	private Long ms;
	private int zt;
	private String nj;
	// Constructors



	/** default constructor */
	public JyZyfx() {
	}

	/** minimal constructor */
	public JyZyfx(String zyfxdm, SysZy sysZy, String zyfxzwmc, int zt,
			String nj) {
		this.zyfxdm = zyfxdm;
		this.sysZy = sysZy;
		this.zyfxzwmc = zyfxzwmc;
		this.zt = zt;
		this.nj = nj;
	}

	/** full constructor */
	public JyZyfx(String zyfxdm, SysZy sysZy, String zyfxzwmc, String zyfxywmc,
			Double xxxfyq, Double bxxfyq, Long ms, int zt, String nj) {
		this.zyfxdm = zyfxdm;
		this.sysZy = sysZy;
		this.zyfxzwmc = zyfxzwmc;
		this.zyfxywmc = zyfxywmc;
		this.xxxfyq = xxxfyq;
		this.bxxfyq = bxxfyq;
		this.ms = ms;
		this.zt = zt;
		this.nj = nj;
	}

	// Property accessors

	public String getZyfxdm() {
		return this.zyfxdm;
	}

	public void setZyfxdm(String zyfxdm) {
		this.zyfxdm = zyfxdm;
	}

	public SysZy getSysZy() {
		return this.sysZy;
	}

	public void setSysZy(SysZy sysZy) {
		this.sysZy = sysZy;
	}

	public String getZyfxzwmc() {
		return this.zyfxzwmc;
	}

	public void setZyfxzwmc(String zyfxzwmc) {
		this.zyfxzwmc = zyfxzwmc;
	}

	public String getZyfxywmc() {
		return this.zyfxywmc;
	}

	public void setZyfxywmc(String zyfxywmc) {
		this.zyfxywmc = zyfxywmc;
	}

	public Double getXxxfyq() {
		return this.xxxfyq;
	}

	public void setXxxfyq(Double xxxfyq) {
		this.xxxfyq = xxxfyq;
	}

	public Double getBxxfyq() {
		return this.bxxfyq;
	}

	public void setBxxfyq(Double bxxfyq) {
		this.bxxfyq = bxxfyq;
	}

	public Long getMs() {
		return this.ms;
	}

	public void setMs(Long ms) {
		this.ms = ms;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public String getNj() {
		return this.nj;
	}

	public void setNj(String nj) {
		this.nj = nj;
	}

}