package com.pot.controller;

import java.util.List;
import java.util.Map;

import com.pot.bean.DynamicRecipes;
import com.pot.bean.SpecialDynamicRecipes;
import com.pot.dao.DynamicRecipesDao;
import com.pot.dao.SpecialDynamicRecipesDao;

public class SpecialDynamicRecipesAction {
	// 增加方法
	public void add(SpecialDynamicRecipes specialDynamicRecipes) throws Exception {
		SpecialDynamicRecipesDao dao = new SpecialDynamicRecipesDao();
		
		dao.addSpecialDynamicRecipes(specialDynamicRecipes);
	}
	// 按条件查询
	public List<SpecialDynamicRecipes> query(List<Map<String,Object>> params) throws Exception {
		SpecialDynamicRecipesDao dao = new SpecialDynamicRecipesDao();
		
		return dao.querySpecialDynamicRecipes(params);
	}
	// 查询方法 全部查询
	public List<SpecialDynamicRecipes>  query() throws Exception {
		SpecialDynamicRecipesDao dao = new SpecialDynamicRecipesDao();
		
		return dao.querySpecialDynamicRecipes();
	}
}
