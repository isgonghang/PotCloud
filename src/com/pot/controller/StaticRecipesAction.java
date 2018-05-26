package com.pot.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pot.bean.DynamicRecipes;
import com.pot.bean.StaticRecipes;
import com.pot.dao.DynamicRecipesDao;
import com.pot.dao.StaticRecipesDao;

/*
 * 控制层
 */
public class StaticRecipesAction {

	// 增加方法
	public void add(StaticRecipes staticrecipes) throws Exception {
		StaticRecipesDao dao = new StaticRecipesDao();
		
		dao.addStaticRecipes(staticrecipes);
	}
	
	//查询单个StaticRecipes
	public StaticRecipes get(Integer id) throws SQLException{
		StaticRecipesDao dao = new StaticRecipesDao();
		return dao.getStaticRecipes(id);
	}
	
	// 更新方法
	public void edit(StaticRecipes staticrecipes) throws Exception {
		StaticRecipesDao dao = new StaticRecipesDao();
		
		dao.updateStaticRecipes(staticrecipes);
	}
	
	// 删除方法 根据主键id
	public void del(Integer id) throws Exception {
		StaticRecipesDao dao = new StaticRecipesDao();
		
		dao.deleteStaticRecipes(id);
	}
	
	// 查询方法 全部查询
	public List<StaticRecipes>  query() throws Exception {
		StaticRecipesDao dao = new StaticRecipesDao();
		
		return dao.queryStaticRecipes();
	}
	
	// 按条件查询
	public List<StaticRecipes> query(List<Map<String,Object>> params) throws Exception {
		StaticRecipesDao dao = new StaticRecipesDao();
		
		return dao.queryStaticRecipes(params);
	}
}
