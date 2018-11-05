package com.whut.service;

import java.util.List;

import com.whut.pojo.JyTsxxkcjsdyb;

public interface JyTsxxkcjsdybService {

	public List<JyTsxxkcjsdyb> GetKcJsList(int pyid);

	public List<JyTsxxkcjsdyb> getAllList();

	public void modify(JyTsxxkcjsdyb jytsxxkcjsdyb);

	public void addJyXzjs(JyTsxxkcjsdyb jytsxxkcjsdyb);

	public List<JyTsxxkcjsdyb> getDyByxmAndkc(String kcmc, String jsxm);

	public List<JyTsxxkcjsdyb> GetThisKcJsList(String ThisKc, int pyid);

}