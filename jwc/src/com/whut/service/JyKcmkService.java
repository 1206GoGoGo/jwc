package com.whut.service;

import java.util.List;

import com.whut.pojo.JyKcmk;

public interface JyKcmkService {
	// public List<JyKcmk> getAllListBykczdm(String kczdm);

	public void deleteMse(JyKcmk jyKcmk);

	// 20130629

	public void addKcmkInfo(JyKcmk obj);

	public List<JyKcmk> getAllListByKCZID(int kczid);

	public void modAkcmk(JyKcmk jyKcmk);

	public JyKcmk getKcmkByKcmkId(int id);

	public boolean hasKc(JyKcmk kcmk);
}
