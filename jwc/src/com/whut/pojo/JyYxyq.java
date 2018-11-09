package com.whut.pojo;

/**
 * JyYxyq entity. @author MyEclipse Persistence Tools
 */

public class JyYxyq implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysKc sysKcByKcdm;
	private SysKc sysKcByYxkcdm;
	private String yxyqdm;
	private int zt;

	// Constructors

	/** default constructor */
	public JyYxyq() {
	}

	/** minimal constructor */
	public JyYxyq(String yxyqdm, int zt) {
		this.yxyqdm = yxyqdm;
		this.zt = zt;
	}

	/** full constructor */
	public JyYxyq(SysKc sysKcByKcdm, SysKc sysKcByYxkcdm, String yxyqdm, int zt) {
		this.sysKcByKcdm = sysKcByKcdm;
		this.sysKcByYxkcdm = sysKcByYxkcdm;
		this.yxyqdm = yxyqdm;
		this.zt = zt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysKc getSysKcByKcdm() {
		return this.sysKcByKcdm;
	}

	public void setSysKcByKcdm(SysKc sysKcByKcdm) {
		this.sysKcByKcdm = sysKcByKcdm;
	}

	public SysKc getSysKcByYxkcdm() {
		return this.sysKcByYxkcdm;
	}

	public void setSysKcByYxkcdm(SysKc sysKcByYxkcdm) {
		this.sysKcByYxkcdm = sysKcByYxkcdm;
	}

	public String getYxyqdm() {
		return this.yxyqdm;
	}

	public void setYxyqdm(String yxyqdm) {
		this.yxyqdm = yxyqdm;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}