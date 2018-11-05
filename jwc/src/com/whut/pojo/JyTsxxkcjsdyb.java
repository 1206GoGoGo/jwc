package com.whut.pojo;

/**
 * JyTsxxkcjsdyb entity. @author MyEclipse Persistence Tools
 */

public class JyTsxxkcjsdyb implements java.io.Serializable {


	// Fields

	private int id;
	private JyTsxxpy jyTsxxpy;
	private SysJs sysJs;
	private int zt;

	// Constructors

	/** default constructor */
	public JyTsxxkcjsdyb() {
	}

	/** full constructor */
	public JyTsxxkcjsdyb(int id, JyTsxxpy jyTsxxpy, SysJs sysJs,
			int zt) {
		this.id = id;
		this.jyTsxxpy = jyTsxxpy;
		this.sysJs = sysJs;
		this.zt = zt;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JyTsxxpy getJyTsxxpy() {
		return this.jyTsxxpy;
	}

	public void setJyTsxxpy(JyTsxxpy jyTsxxpy) {
		this.jyTsxxpy = jyTsxxpy;
	}

	public SysJs getSysJs() {
		return this.sysJs;
	}

	public void setSysJs(SysJs sysJs) {
		this.sysJs = sysJs;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

}