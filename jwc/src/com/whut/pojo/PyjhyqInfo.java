package com.whut.pojo;

public class PyjhyqInfo {

	JyPyjhyq jyPyjhyq;
	String zydm;
	
	
	public PyjhyqInfo() {
		
	}
	
	public PyjhyqInfo(JyPyjhyq jyPyjhyq, String zydm) {
		this.jyPyjhyq = jyPyjhyq;
		this.zydm = zydm;
	}
	
	
	public JyPyjhyq getJyPyjhyq() {
		return jyPyjhyq;
	}
	public void setJyPyjhyq(JyPyjhyq jyPyjhyq) {
		this.jyPyjhyq = jyPyjhyq;
	}
	public String getZydm() {
		return zydm;
	}
	public void setZydm(String zydm) {
		this.zydm = zydm;
	}
	
	
}
