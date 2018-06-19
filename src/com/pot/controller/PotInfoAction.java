package com.pot.controller;

import com.pot.bean.AllPotInfo;
import com.pot.bean.RecipesDetail;
import com.pot.dao.PotInfoDao;
import com.pot.dao.RecipesDetailDao;

public class PotInfoAction {
	// 增加方法
	public void add(AllPotInfo allPotInfo) throws Exception {
		PotInfoDao dao = new PotInfoDao();
		
		dao.addPotInfo(allPotInfo);
	}
}
