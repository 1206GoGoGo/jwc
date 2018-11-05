package com.whut.pojo;

/**
 * JyTsxxpy entity. @author MyEclipse Persistence Tools
 */

public class JyTsxxpy implements java.io.Serializable {

	// Fields

	private int id;
	private SysXy sysXy;
	private JyXxgs jyXxgs;
	private SysKc sysKc;
	private String tsxxpydm;
	private int zt;
	private String bz;
	private String nj;
	private String xzsm;
	private String shhf;
	private String jykkxq;
	private String xqdm;
	private String xxkc;

	// Constructors

	/** default constructor */
	public JyTsxxpy() {
	}

	/** minimal constructor */
	public JyTsxxpy(int id, SysXy sysXy, SysKc sysKc, String tsxxpydm, int zt, String shhf, String jykkxq, String xqdm) {
		this.id = id;
		this.sysXy = sysXy;
		this.sysKc = sysKc;
		this.tsxxpydm = tsxxpydm;
		this.zt = zt;
		this.shhf = shhf;
		this.jykkxq = jykkxq;
		this.xqdm = xqdm;
	}

	/** full constructor */
	public JyTsxxpy(int id, SysXy sysXy, JyXxgs jyXxgs, SysKc sysKc, String tsxxpydm, int zt, String bz, String nj, String xzsm, String shhf,
			String jykkxq, String xqdm, String xxkc) {
		this.id = id;
		this.sysXy = sysXy;
		this.jyXxgs = jyXxgs;
		this.sysKc = sysKc;
		this.tsxxpydm = tsxxpydm;
		this.zt = zt;
		this.bz = bz;
		this.nj = nj;
		this.xzsm = xzsm;
		this.shhf = shhf;
		this.jykkxq = jykkxq;
		this.xqdm = xqdm;
		this.xxkc = xxkc;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SysXy getSysXy() {
		return this.sysXy;
	}

	public void setSysXy(SysXy sysXy) {
		this.sysXy = sysXy;
	}

	public JyXxgs getJyXxgs() {
		return this.jyXxgs;
	}

	public void setJyXxgs(JyXxgs jyXxgs) {
		this.jyXxgs = jyXxgs;
	}

	public SysKc getSysKc() {
		return this.sysKc;
	}

	public void setSysKc(SysKc sysKc) {
		this.sysKc = sysKc;
	}

	public String getTsxxpydm() {
		return this.tsxxpydm;
	}

	public void setTsxxpydm(String tsxxpydm) {
		this.tsxxpydm = tsxxpydm;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getNj() {
		return this.nj;
	}

	public void setNj(String nj) {
		this.nj = nj;
	}

	public String getXzsm() {
		return this.xzsm;
	}

	public void setXzsm(String xzsm) {
		this.xzsm = xzsm;
	}

	public String getShhf() {
		return this.shhf;
	}

	public void setShhf(String shhf) {
		this.shhf = shhf;
	}

	public String getJykkxq() {
		return this.jykkxq;
	}

	public void setJykkxq(String jykkxq) {
		this.jykkxq = jykkxq;
	}

	public String getXqdm() {
		return this.xqdm;
	}

	public void setXqdm(String xqdm) {
		this.xqdm = xqdm;
	}

	public String getXxkc() {
		return xxkc;
	}

	public void setXxkc(String xxkc) {
		this.xxkc = xxkc;
	}

}