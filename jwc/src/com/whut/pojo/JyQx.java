package com.whut.pojo;



import java.math.BigDecimal;

import java.util.HashSet;

import java.util.Set;



import com.fasterxml.jackson.annotation.JsonManagedReference;



/**

 * JyQx entity. @author MyEclipse Persistence Tools

 */



public class JyQx implements java.io.Serializable {



	// Fields



	private BigDecimal qxid;

	private String qxmc;

	private String zt;

	

	@JsonManagedReference

	private Set<JyYhqx> jyYhqxes = new HashSet(0);



	// Constructors



	/** default constructor */

	public JyQx() {

	}



	/** minimal constructor */

	public JyQx(BigDecimal qxid, String qxmc, String zt) {

		this.qxid = qxid;

		this.qxmc = qxmc;

		this.zt = zt;

	}



	/** full constructor */

	public JyQx(BigDecimal qxid, String qxmc, String zt, Set jyYhqxes) {

		this.qxid = qxid;

		this.qxmc = qxmc;

		this.zt = zt;

		this.jyYhqxes = jyYhqxes;

	}



	// Property accessors



	public BigDecimal getQxid() {

		return this.qxid;

	}



	public void setQxid(BigDecimal qxid) {

		this.qxid = qxid;

	}



	public String getQxmc() {

		return this.qxmc;

	}



	public void setQxmc(String qxmc) {

		this.qxmc = qxmc;

	}



	public String getZt() {

		return this.zt;

	}



	public void setZt(String zt) {

		this.zt = zt;

	}



	public Set getJyYhqxes() {

		return this.jyYhqxes;

	}



	public void setJyYhqxes(Set<JyYhqx> jyYhqxes) {

		this.jyYhqxes = jyYhqxes;

	}



}