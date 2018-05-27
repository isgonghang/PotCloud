package com.pot.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pot.bean.RecipesDetail;
import com.pot.dao.RecipesDetailDao;

/*
 * 控制层
 */
public class RecipesDetailAction {

	// 增加方法
	public void add(RecipesDetail recipesdetail) throws Exception {
		RecipesDetailDao dao = new RecipesDetailDao();
		
		dao.addRecipesDetail(recipesdetail);
	}
	
	//查询单个RecipesDetail
	public RecipesDetail get(Integer id) throws SQLException{
		RecipesDetailDao dao = new RecipesDetailDao();
		return dao.getRecipesDetail(id);
	}
	
	// 更新方法
	public void edit(RecipesDetail recipesdetail) throws Exception {
		RecipesDetailDao dao = new RecipesDetailDao();
		
		dao.updateRecipesDetail(recipesdetail);
	}
	
	// 删除方法 根据主键id
	public void del(Integer id) throws Exception {
		RecipesDetailDao dao = new RecipesDetailDao();
		
		dao.deleteRecipesDetail(id);
	}
	
	// 查询方法 全部查询
	public List<RecipesDetail>  query() throws Exception {
		RecipesDetailDao dao = new RecipesDetailDao();
		
		return dao.queryRecipesDetail();
	}
	
	// 按条件查询
	public List<RecipesDetail> query(List<Map<String,Object>> params) throws Exception {
		RecipesDetailDao dao = new RecipesDetailDao();
		
		return dao.queryRecipesDetail(params);
	}
	
}
