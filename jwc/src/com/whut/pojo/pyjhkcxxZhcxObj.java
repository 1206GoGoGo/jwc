package com.whut.pojo;

public class pyjhkcxxZhcxObj {
	//培养计划课程信息综合查询
	private String CJXJHH = ""; // 教学计划号cjxjhh
	private String CNJ = ""; // 年级cnj
	private String CSKXYDM = ""; // 学院代码cskxydm
	private String CSKXYMC = ""; // 学院名称cskxymc
	private String CSKZYDM = ""; // 专业代码cskzydm
	private String CSKZYMC = ""; // 专业名称cskzymc
	private String CKCDM = ""; // 课程代码ckcdm
	private String CKCMC = ""; // 课程名称ckcmc
	private String KKXYDM = ""; // 开课学院代码kkxydm
	private String KKXYMC = ""; // 开课学院名称kkxymc
	private String CKHFS = ""; // 考核方式ckhfs
	private String CKCXZ = ""; // 课程性质ckcxz
	private String KCMKMC = ""; // 课程模块名称kcmkmc
	private String CKCLB = ""; // 课程类别ckclb
	private String CZYFXMC = ""; // 专业方向名称czyfxmc
	private String CKCZMC = ""; // 课程组名称ckczmc
	private String CXF = ""; // 学分cxf

	private Number CZT = 0; // 状态czt
	private Number CSFXWK = 0; // 是否学位课csfxwk
	private Number CSFDEZY = 0; // 是否第二专业csfdezy
	private Number CSFGXKC = 0; // 是否个性化课程csfgxkc

	private Number CZXS = 0; // 总学时czxs
	private Number CLLXS = 0; // 理论学时cllxs
	private Number CSYXS = 0; // 实验学时csyxs
	private Number CSJXS = 0; // 上机学时csjxs
	private Number CSJXS2 = 0; // 实践学时csjxs2
	private Number CKWXS = 0; // 课外学时ckwxs
	private Number CKKXQ = 0; // 开课学期ckkxq

	public pyjhkcxxZhcxObj() {
		super();
	}

	public pyjhkcxxZhcxObj(String cJXJHH, String cNJ, String cSKXYDM,
			String cSKXYMC, String cSKZYDM, String cSKZYMC, String cKCDM,
			String cKCMC, String kKXYDM, String kKXYMC, String cKHFS,
			String cKCXZ, String kCMKMC, String cKCLB, String cZYFXMC,
			String cKCZMC, String cXF, Number cZT, Number cSFXWK,
			Number cSFDEZY, Number cSFGXKC, Number cZXS, Number cLLXS,
			Number cSYXS, Number cSJXS, Number cSJXS2, Number cKWXS,
			Number cKKXQ) {
		super();
		CJXJHH = cJXJHH;
		CNJ = cNJ;
		CSKXYDM = cSKXYDM;
		CSKXYMC = cSKXYMC;
		CSKZYDM = cSKZYDM;
		CSKZYMC = cSKZYMC;
		CKCDM = cKCDM;
		CKCMC = cKCMC;
		KKXYDM = kKXYDM;
		KKXYMC = kKXYMC;
		CKHFS = cKHFS;
		CKCXZ = cKCXZ;
		KCMKMC = kCMKMC;
		CKCLB = cKCLB;
		CZYFXMC = cZYFXMC;
		CKCZMC = cKCZMC;
		CXF = cXF;
		CZT = cZT;
		CSFXWK = cSFXWK;
		CSFDEZY = cSFDEZY;
		CSFGXKC = cSFGXKC;
		CZXS = cZXS;
		CLLXS = cLLXS;
		CSYXS = cSYXS;
		CSJXS = cSJXS;
		CSJXS2 = cSJXS2;
		CKWXS = cKWXS;
		CKKXQ = cKKXQ;
	}

	public String getCJXJHH() {
		return CJXJHH;
	}

	public void setCJXJHH(String cJXJHH) {
		CJXJHH = cJXJHH;
	}

	public String getCNJ() {
		return CNJ;
	}

	public void setCNJ(String cNJ) {
		CNJ = cNJ;
	}

	public String getCSKXYDM() {
		return CSKXYDM;
	}

	public void setCSKXYDM(String cSKXYDM) {
		CSKXYDM = cSKXYDM;
	}

	public String getCSKXYMC() {
		return CSKXYMC;
	}

	public void setCSKXYMC(String cSKXYMC) {
		CSKXYMC = cSKXYMC;
	}

	public String getCSKZYDM() {
		return CSKZYDM;
	}

	public void setCSKZYDM(String cSKZYDM) {
		CSKZYDM = cSKZYDM;
	}

	public String getCSKZYMC() {
		return CSKZYMC;
	}

	public void setCSKZYMC(String cSKZYMC) {
		CSKZYMC = cSKZYMC;
	}

	public String getCKCDM() {
		return CKCDM;
	}

	public void setCKCDM(String cKCDM) {
		CKCDM = cKCDM;
	}

	public String getCKCMC() {
		return CKCMC;
	}

	public void setCKCMC(String cKCMC) {
		CKCMC = cKCMC;
	}

	public String getKKXYDM() {
		return KKXYDM;
	}

	public void setKKXYDM(String kKXYDM) {
		KKXYDM = kKXYDM;
	}

	public String getKKXYMC() {
		return KKXYMC;
	}

	public void setKKXYMC(String kKXYMC) {
		KKXYMC = kKXYMC;
	}

	public String getCKHFS() {
		return CKHFS;
	}

	public void setCKHFS(String cKHFS) {
		CKHFS = cKHFS;
	}

	public String getCKCXZ() {
		return CKCXZ;
	}

	public void setCKCXZ(String cKCXZ) {
		CKCXZ = cKCXZ;
	}

	public String getKCMKMC() {
		return KCMKMC;
	}

	public void setKCMKMC(String kCMKMC) {
		KCMKMC = kCMKMC;
	}

	public String getCKCLB() {
		return CKCLB;
	}

	public void setCKCLB(String cKCLB) {
		CKCLB = cKCLB;
	}

	public String getCZYFXMC() {
		return CZYFXMC;
	}

	public void setCZYFXMC(String cZYFXMC) {
		CZYFXMC = cZYFXMC;
	}

	public String getCKCZMC() {
		return CKCZMC;
	}

	public void setCKCZMC(String cKCZMC) {
		CKCZMC = cKCZMC;
	}

	public String getCXF() {
		return CXF;
	}

	public void setCXF(String cXF) {
		CXF = cXF;
	}

	public Number getCZT() {
		return CZT;
	}

	public void setCZT(Number cZT) {
		CZT = cZT;
	}

	public Number getCSFXWK() {
		return CSFXWK;
	}

	public void setCSFXWK(Number cSFXWK) {
		CSFXWK = cSFXWK;
	}

	public Number getCSFDEZY() {
		return CSFDEZY;
	}

	public void setCSFDEZY(Number cSFDEZY) {
		CSFDEZY = cSFDEZY;
	}

	public Number getCSFGXKC() {
		return CSFGXKC;
	}

	public void setCSFGXKC(Number cSFGXKC) {
		CSFGXKC = cSFGXKC;
	}

	public Number getCZXS() {
		return CZXS;
	}

	public void setCZXS(Number cZXS) {
		CZXS = cZXS;
	}

	public Number getCLLXS() {
		return CLLXS;
	}

	public void setCLLXS(Number cLLXS) {
		CLLXS = cLLXS;
	}

	public Number getCSYXS() {
		return CSYXS;
	}

	public void setCSYXS(Number cSYXS) {
		CSYXS = cSYXS;
	}

	public Number getCSJXS() {
		return CSJXS;
	}

	public void setCSJXS(Number cSJXS) {
		CSJXS = cSJXS;
	}

	public Number getCSJXS2() {
		return CSJXS2;
	}

	public void setCSJXS2(Number cSJXS2) {
		CSJXS2 = cSJXS2;
	}

	public Number getCKWXS() {
		return CKWXS;
	}

	public void setCKWXS(Number cKWXS) {
		CKWXS = cKWXS;
	}

	public Number getCKKXQ() {
		return CKKXQ;
	}

	public void setCKKXQ(Number cKKXQ) {
		CKKXQ = cKKXQ;
	}

}
