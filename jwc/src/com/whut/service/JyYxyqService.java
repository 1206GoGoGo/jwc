package com.whut.service;

import java.util.List;

import com.whut.pojo.JyYxyq;

public interface JyYxyqService {
	public List<JyYxyq> getyxyqListByJxjhh(String jxjhh, String kcdm);

	public void addJyYxyq(JyYxyq jyYxyq);

	public List<JyYxyq> getxykcByyxdmAndKc(String yxyqdm, String kcdm);
}
