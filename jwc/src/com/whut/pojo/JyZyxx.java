package com.whut.pojo;

/**
 * JyZyxx entity. @author MyEclipse Persistence Tools
 */

public class JyZyxx implements java.io.Serializable {

	// Fields

	private String jxjhh;
	private SysZy sysZy;
	private DmXklb dmXklb;
	private String ssxqdm;
	private String nj;
	private Integer rs;
	private Integer bjs;
	private Integer zskcs;
	private Double zdbyxf = 0.0;
	private Double ggbxxf  = 0.0;
	private Double ggxxxf  = 0.0;
	private Double xkbxxf  = 0.0;
	private Double xkxxxf  = 0.0;
	private Double zybxxf  = 0.0;
	private Double zyxxxf1  = 0.0;
	private Double zyxxxf2  = 0.0;
	private Double sjkxf  = 0.0;
	private Double fssjxf  = 0.0;
	private Double jqsjxf  = 0.0;
	private Double yyfjxf  = 0.0;
	private Double kwxf  = 0.0;
	private Double tsbxxf  = 0.0;
	private Double tsxxxf  = 0.0;
	private Double dlbxxf  = 0.0;
	private Double flxxxf  = 0.0;
	private Double knsyxf  = 0.0;
	private Double dexwxf  = 0.0;
	private Double bybz  = 0.0;
	private Double xwsybz  = 0.0;
	private Double gxkxf  = 0.0;
	private Double xxysyzdxf  = 0.0;
	private Double whkcxf  = 0.0;
	private Double kjwhkcxf  = 0.0;
	private Double yskcxf  = 0.0;
	private Double xxfyq  = 0.0; 
	private Double xynx  = 0.0;
	private Double fxnx  = 0.0;
	private Double yybxxf = 0.0;
	private Double tybxxf = 0.0;
	private String bz;
	private int zt;
	
	//private String kcly1;
	private Double gxkcxf=0.0;//个性课程学分
	
	private String kcly2;
	private String kcly3;
	private String kcly4;
	private String kcly5;
	private String kcly6;
	private String kcly7;
	private String kcly8;
	private String kcly9;
	private String kcly10;
	
	private String gxxf;
//	private Set jyPyjhyqs = new HashSet(0);

	// Constructors

	/** default constructor */
	public JyZyxx() {
	}

	/** minimal constructor */
	public JyZyxx(String jxjhh, SysZy sysZy, String ssxqdm, String nj, int rs,
			int bjs) {
		this.jxjhh = jxjhh;
		this.sysZy = sysZy;
		this.ssxqdm = ssxqdm;
		this.nj = nj;
		this.rs = rs;
		this.bjs = bjs;
	}



	public JyZyxx(String jxjhh, SysZy sysZy, DmXklb dmXklb, String ssxqdm,
			String nj, Integer rs, Integer bjs, Integer zskcs, Double zdbyxf,
			Double ggbxxf, Double ggxxxf, Double xkbxxf, Double xkxxxf,
			Double zybxxf, Double zyxxxf1, Double zyxxxf2, Double sjkxf,
			Double fssjxf, Double jqsjxf, Double yyfjxf, Double kwxf,
			Double tsbxxf, Double tsxxxf, Double dlbxxf, Double flxxxf,
			Double knsyxf, Double dexwxf, Double bybz, Double xwsybz,
			Double gxkxf, Double xxysyzdxf, Double whkcxf, Double kjwhkcxf,
			Double yskcxf, Double xxfyq, Double xynx, Double fxnx, Double yybxxf,Double tybxxf,String bz,
			int zt, Double gxkcxf, String kcly2, String kcly3, String kcly4,
			String kcly5, String kcly6, String kcly7, String kcly8,
			String kcly9, String kcly10, String gxxf) {
		super();
		this.jxjhh = jxjhh;
		this.sysZy = sysZy;
		this.dmXklb = dmXklb;
		this.ssxqdm = ssxqdm;
		this.nj = nj;
		this.rs = rs;
		this.bjs = bjs;
		this.zskcs = zskcs;
		this.zdbyxf = zdbyxf;
		this.ggbxxf = ggbxxf;
		this.ggxxxf = ggxxxf;
		this.xkbxxf = xkbxxf;
		this.xkxxxf = xkxxxf;
		this.zybxxf = zybxxf;
		this.zyxxxf1 = zyxxxf1;
		this.zyxxxf2 = zyxxxf2;
		this.sjkxf = sjkxf;
		this.fssjxf = fssjxf;
		this.jqsjxf = jqsjxf;
		this.yyfjxf = yyfjxf;
		this.kwxf = kwxf;
		this.tsbxxf = tsbxxf;
		this.tsxxxf = tsxxxf;
		this.dlbxxf = dlbxxf;
		this.flxxxf = flxxxf;
		this.knsyxf = knsyxf;
		this.dexwxf = dexwxf;
		this.bybz = bybz;
		this.xwsybz = xwsybz;
		this.gxkxf = gxkxf;
		this.xxysyzdxf = xxysyzdxf;
		this.whkcxf = whkcxf;
		this.kjwhkcxf = kjwhkcxf;
		this.yskcxf = yskcxf;
		this.xxfyq = xxfyq;
		this.xynx = xynx;
		this.fxnx = fxnx;
		this.bz = bz;
		this.zt = zt;
		this.gxkcxf = gxkcxf;
		this.kcly2 = kcly2;
		this.kcly3 = kcly3;
		this.kcly4 = kcly4;
		this.kcly5 = kcly5;
		this.kcly6 = kcly6;
		this.kcly7 = kcly7;
		this.kcly8 = kcly8;
		this.kcly9 = kcly9;
		this.kcly10 = kcly10;
		this.gxxf = gxxf;
	}

	// Property accessors

	public String getJxjhh() {
		return this.jxjhh;
	}

	public void setJxjhh(String jxjhh) {
		this.jxjhh = jxjhh;
	}

	public SysZy getSysZy() {
		return this.sysZy;
	}

	public void setSysZy(SysZy sysZy) {
		this.sysZy = sysZy;
	}

	public DmXklb getDmXklb() {
		return this.dmXklb;
	}

	public void setDmXklb(DmXklb dmXklb) {
		this.dmXklb = dmXklb;
	}

	public String getSsxqdm() {
		return this.ssxqdm;
	}

	public void setSsxqdm(String ssxqdm) {
		this.ssxqdm = ssxqdm;
	}

	public String getNj() {
		return this.nj;
	}

	public void setNj(String nj) {
		this.nj = nj;
	}

	public Integer getRs() {
		return this.rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public Integer getBjs() {
		return this.bjs;
	}

	public void setBjs(Integer bjs) {
		this.bjs = bjs;
	}

	public Integer getZskcs() {
		return this.zskcs;
	}

	public void setZskcs(Integer zskcs) {
		this.zskcs = zskcs;
	}

	public Double getZdbyxf() {
		return this.zdbyxf;
	}

	public void setZdbyxf(Double zdbyxf) {
		this.zdbyxf = zdbyxf;
	}

	public Double getGgbxxf() {
		return this.ggbxxf;
	}

	public void setGgbxxf(Double ggbxxf) {
		this.ggbxxf = ggbxxf;
	}

	public Double getGgxxxf() {
		return this.ggxxxf;
	}

	public void setGgxxxf(Double ggxxxf) {
		this.ggxxxf = ggxxxf;
	}

	public Double getXkbxxf() {
		return this.xkbxxf;
	}

	public void setXkbxxf(Double xkbxxf) {
		this.xkbxxf = xkbxxf;
	}

	public Double getXkxxxf() {
		return this.xkxxxf;
	}

	public void setXkxxxf(Double xkxxxf) {
		this.xkxxxf = xkxxxf;
	}

	public Double getZybxxf() {
		return this.zybxxf;
	}

	public void setZybxxf(Double zybxxf) {
		this.zybxxf = zybxxf;
	}

	public Double getZyxxxf1() {
		return this.zyxxxf1;
	}

	public void setZyxxxf1(Double zyxxxf1) {
		this.zyxxxf1 = zyxxxf1;
	}

	public Double getZyxxxf2() {
		return this.zyxxxf2;
	}

	public void setZyxxxf2(Double zyxxxf2) {
		this.zyxxxf2 = zyxxxf2;
	}

	public Double getSjkxf() {
		return this.sjkxf;
	}

	public void setSjkxf(Double sjkxf) {
		this.sjkxf = sjkxf;
	}

	public Double getFssjxf() {
		return this.fssjxf;
	}

	public void setFssjxf(Double fssjxf) {
		this.fssjxf = fssjxf;
	}

	public Double getJqsjxf() {
		return this.jqsjxf;
	}

	public void setJqsjxf(Double jqsjxf) {
		this.jqsjxf = jqsjxf;
	}

	public Double getYyfjxf() {
		return this.yyfjxf;
	}

	public void setYyfjxf(Double yyfjxf) {
		this.yyfjxf = yyfjxf;
	}

	public Double getKwxf() {
		return this.kwxf;
	}

	public void setKwxf(Double kwxf) {
		this.kwxf = kwxf;
	}

	public Double getTsbxxf() {
		return this.tsbxxf;
	}

	public void setTsbxxf(Double tsbxxf) {
		this.tsbxxf = tsbxxf;
	}

	public Double getTsxxxf() {
		return this.tsxxxf;
	}

	public void setTsxxxf(Double tsxxxf) {
		this.tsxxxf = tsxxxf;
	}

	public Double getDlbxxf() {
		return this.dlbxxf;
	}

	public void setDlbxxf(Double dlbxxf) {
		this.dlbxxf = dlbxxf;
	}

	public Double getFlxxxf() {
		return this.flxxxf;
	}

	public void setFlxxxf(Double flxxxf) {
		this.flxxxf = flxxxf;
	}

	public Double getKnsyxf() {
		return this.knsyxf;
	}

	public void setKnsyxf(Double knsyxf) {
		this.knsyxf = knsyxf;
	}

	public Double getDexwxf() {
		return this.dexwxf;
	}

	public void setDexwxf(Double dexwxf) {
		this.dexwxf = dexwxf;
	}

	public Double getBybz() {
		return this.bybz;
	}

	public void setBybz(Double bybz) {
		this.bybz = bybz;
	}

	public Double getXwsybz() {
		return this.xwsybz;
	}

	public void setXwsybz(Double xwsybz) {
		this.xwsybz = xwsybz;
	}

	public Double getGxkxf() {
		return this.gxkxf;
	}

	public void setGxkxf(Double gxkxf) {
		this.gxkxf = gxkxf;
	}

	public Double getXxysyzdxf() {
		return this.xxysyzdxf;
	}

	public void setXxysyzdxf(Double xxysyzdxf) {
		this.xxysyzdxf = xxysyzdxf;
	}

	public Double getWhkcxf() {
		return this.whkcxf;
	}

	public void setWhkcxf(Double whkcxf) {
		this.whkcxf = whkcxf;
	}

	public Double getKjwhkcxf() {
		return this.kjwhkcxf;
	}

	public void setKjwhkcxf(Double kjwhkcxf) {
		this.kjwhkcxf = kjwhkcxf;
	}

	public Double getYskcxf() {
		return this.yskcxf;
	}

	public void setYskcxf(Double yskcxf) {
		this.yskcxf = yskcxf;
	}

	public Double getXxfyq() {
		return this.xxfyq;
	}

	public void setXxfyq(Double xxfyq) {
		this.xxfyq = xxfyq;
	}

	public Double getXynx() {
		return this.xynx;
	}

	public void setXynx(Double xynx) {
		this.xynx = xynx;
	}

	public Double getFxnx() {
		return this.fxnx;
	}

	public void setFxnx(Double fxnx) {
		this.fxnx = fxnx;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public int getZt() {
		return this.zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public String getKcly2() {
		return this.kcly2;
	}

	public void setKcly2(String kcly2) {
		this.kcly2 = kcly2;
	}

	public String getKcly3() {
		return this.kcly3;
	}

	public void setKcly3(String kcly3) {
		this.kcly3 = kcly3;
	}

	public String getKcly4() {
		return this.kcly4;
	}

	public void setKcly4(String kcly4) {
		this.kcly4 = kcly4;
	}

	public String getKcly5() {
		return this.kcly5;
	}

	public void setKcly5(String kcly5) {
		this.kcly5 = kcly5;
	}

	public String getKcly6() {
		return this.kcly6;
	}

	public void setKcly6(String kcly6) {
		this.kcly6 = kcly6;
	}

	public String getKcly7() {
		return this.kcly7;
	}

	public void setKcly7(String kcly7) {
		this.kcly7 = kcly7;
	}

	public String getKcly8() {
		return this.kcly8;
	}

	public void setKcly8(String kcly8) {
		this.kcly8 = kcly8;
	}

	public String getKcly9() {
		return this.kcly9;
	}

	public void setKcly9(String kcly9) {
		this.kcly9 = kcly9;
	}

	public String getKcly10() {
		return this.kcly10;
	}

	public void setKcly10(String kcly10) {
		this.kcly10 = kcly10;
	}

	public Double getGxkcxf() {
		return gxkcxf;
	}

	public void setGxkcxf(Double gxkcxf) {
		this.gxkcxf = gxkcxf;
	}

	public String getGxxf() {
		return gxxf;
	}

	public void setGxxf(String gxxf) {
		this.gxxf = gxxf;
	}
	public Double getYybxxf() {
		return yybxxf;
	}

	public void setYybxxf(Double yybxxf) {
		this.yybxxf = yybxxf;
	}

	public Double getTybxxf() {
		return tybxxf;
	}

	public void setTybxxf(Double tybxxf) {
		this.tybxxf = tybxxf;
	}
}