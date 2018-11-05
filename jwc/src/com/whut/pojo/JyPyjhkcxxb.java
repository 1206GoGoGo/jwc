package com.whut.pojo;

/**
 * JyPyjhkcxx entity. @author MyEclipse Persistence Tools
 */

public class JyPyjhkcxxb implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysKc sysKc;
	private JyKcz jyKcz;
	private String jxjhh;
	private int jykkxq;
	private boolean sfxwk;
	private boolean sfdezy;
	private String zyfxdm;
	private String khfs;
	private boolean sfgxkc;
	private boolean sfjxjhyy;
	private int zt;
	private String kcxz;
	private Integer bid;
	
	private JyKcmk jyKcmk;
	
	public JyKcmk getJyKcmk() {
		return this.jyKcmk;
	}

	public void setJyKcmk(JyKcmk jyKcmk) {
		this.jyKcmk = jyKcmk;
	}

	// Constructors

	/** default constructor */
	public JyPyjhkcxxb() {
	}

	/** minimal constructor */
	public JyPyjhkcxxb(Integer id, SysKc sysKc, int jykkxq, Boolean sfxwk,
			Boolean sfdezy, Boolean sfgxkc, Boolean sfjxjhyy, int zt) {
		this.id = id;
		this.sysKc = sysKc;
		this.jykkxq = jykkxq;
		this.sfxwk = sfxwk;
		this.sfdezy = sfdezy;
		this.sfgxkc = sfgxkc;
		this.sfjxjhyy = sfjxjhyy;
		this.zt = zt;
	}

	/** full constructor */
	public JyPyjhkcxxb(Integer id, SysKc sysKc, JyKcz jyKcz, String jxjhh,
			int jykkxq, Boolean sfxwk, Boolean sfdezy, String zyfxdm,
			String khfs, Boolean sfgxkc, Boolean sfjxjhyy, int zt,
			String kcxz,Integer bid) {
		this.id = id;
		this.sysKc = sysKc;
		this.jyKcz = jyKcz;
		this.jxjhh = jxjhh;
		this.jykkxq = jykkxq;
		this.sfxwk = sfxwk;
		this.sfdezy = sfdezy;
		this.zyfxdm = zyfxdm;
		this.khfs = khfs;
		this.sfgxkc = sfgxkc;
		this.sfjxjhyy = sfjxjhyy;
		this.zt = zt;
		this.kcxz = kcxz;
		this.bid = bid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysKc getSysKc() {
		return this.sysKc;
	}

	public void setSysKc(SysKc sysKc) {
		this.sysKc = sysKc;
	}

	public JyKcz getJyKcz() {
		return this.jyKcz;
	}

	public void setJyKcz(JyKcz jyKcz) {
		this.jyKcz = jyKcz;
	}

	public String getJxjhh() {
		return this.jxjhh;
	}

	public void setJxjhh(String jxjhh) {
		this.jxjhh = jxjhh;
	}

	public int getJykkxq() {
		return this.jykkxq;
	}

	public void setJykkxq(int jykkxq) {
		this.jykkxq = jykkxq;
	}

	public Boolean getSfxwk() {
		return this.sfxwk;
	}

	public void setSfxwk(Boolean sfxwk) {
		this.sfxwk = sfxwk;
	}

	public Boolean getSfdezy() {
		return this.sfdezy;
	}

	public void setSfdezy(Boolean sfdezy) {
		this.sfdezy = sfdezy;
	}

	public String getZyfxdm() {
		return this.zyfxdm;
	}

	public void setZyfxdm(String zyfxdm) {
		this.zyfxdm = zyfxdm;
	}

	public String getKhfs() {
		return this.khfs;
	}

	public void setKhfs(String khfs) {
		this.khfs = khfs;
	}

	public Boolean getSfgxkc() {
		return this.sfgxkc;
	}

	public void setSfgxkc(Boolean sfgxkc) {
		this.sfgxkc = sfgxkc;
	}

	public Boolean getSfjxjhyy() {
		return this.sfjxjhyy;
	}

	public void setSfjxjhyy(Boolean sfjxjhyy) {
		this.sfjxjhyy = sfjxjhyy;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public String getKcxz() {
		return this.kcxz;
	}

	public void setKcxz(String kcxz) {
		this.kcxz = kcxz;
	}
	
	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

}