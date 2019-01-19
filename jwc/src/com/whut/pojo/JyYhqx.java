package com.whut.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * JyYhqx entity. @author MyEclipse Persistence Tools
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "yhid")
public class JyYhqx implements java.io.Serializable {

	// Fields

	private String yhid;
	//@JsonBackReference
	private JyQx jyQx;
	private String zt;

	// Constructors

	/** default constructor */
	public JyYhqx() {
	}

	/** full constructor */
	public JyYhqx(String yhid, JyQx jyQx, String zt) {
		this.yhid = yhid;
		this.jyQx = jyQx;
		this.zt = zt;
	}

	// Property accessors

	public String getYhid() {
		return this.yhid;
	}

	public void setYhid(String yhid) {
		this.yhid = yhid;
	}

	public JyQx getJyQx() {
		return this.jyQx;
	}

	public void setJyQx(JyQx jyQx) {
		this.jyQx = jyQx;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

}