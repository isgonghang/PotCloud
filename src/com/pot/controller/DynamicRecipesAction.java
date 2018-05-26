package com.pot.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pot.bean.DynamicRecipes;
import com.pot.bean.FoodMenu;
import com.pot.dao.DynamicRecipesDao;
import com.pot.dao.FoodMenuDao;

/*
 * 控制层
 */
public class DynamicRecipesAction {

	// 增加方法
	public void add(DynamicRecipes dynamicrecipes) throws Exception {
		DynamicRecipesDao dao = new DynamicRecipesDao();
		
		dao.addDynamicRecipes(dynamicrecipes);
	}
	
	//查询单个DynamicRecipes
	public DynamicRecipes get(Integer id) throws SQLException{
		DynamicRecipesDao dao = new DynamicRecipesDao();
		return dao.getDynamicRecipes(id);
	}
	
	// 更新方法
	public void edit(DynamicRecipes dynamicrecipes) throws Exception {
		DynamicRecipesDao dao = new DynamicRecipesDao();
		
		dao.updateDynamicRecipes(dynamicrecipes);
	}
	
	// 删除方法 根据主键id
	public void del(Integer id) throws Exception {
		DynamicRecipesDao dao = new DynamicRecipesDao();
		
		dao.deleteDynamicRecipes(id);
	}
	
	// 查询方法 全部查询
	public List<DynamicRecipes>  query() throws Exception {
		DynamicRecipesDao dao = new DynamicRecipesDao();
		
		return dao.queryDynamicRecipes();
	}
	
	// 按条件查询
	public List<DynamicRecipes> query(List<Map<String,Object>> params) throws Exception {
		DynamicRecipesDao dao = new DynamicRecipesDao();
		
		return dao.queryDynamicRecipes(params);
	}
	
}
