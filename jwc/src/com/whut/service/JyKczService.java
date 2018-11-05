package com.whut.service;

import java.util.List;

import com.whut.pojo.JyKcz;


public interface JyKczService {
	public List<JyKcz> getAllListByjxjhh(String jxjhh);

	public void addKczInfo(JyKcz obj);

	public JyKcz getKczBykczdm(String kczdm);

	public void deleteMse(JyKcz jyKcz);

	public void modAkcz(JyKcz obj);

	public boolean hasMK(JyKcz kcz);

}
