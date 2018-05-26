package com.pot.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pot.bean.FoodMenu;
import com.pot.dao.FoodMenuDao;

/*
 * 控制层
 */
public class FoodMenuAction {
	
	// 增加方法
	public void add(FoodMenu foodmenu) throws Exception {
		FoodMenuDao dao = new FoodMenuDao();
		
		dao.addFoodMenu(foodmenu);
	}
	
	//查询单个foodmenu
	public FoodMenu get(Integer id) throws SQLException{
		FoodMenuDao dao = new FoodMenuDao();
		return dao.getFoodMenu(id);
	}
	
	// 更新方法
	public void edit(FoodMenu foodmenu) throws Exception {
		FoodMenuDao dao = new FoodMenuDao();
		
		dao.updateFoodMenu(foodmenu);
	}
	
	// 删除方法 根据主键id
	public void del(Integer id) throws Exception {
		FoodMenuDao dao = new FoodMenuDao();
		
		dao.deleteFoodMenu(id);
	}
	
	// 查询方法 全部查询
	public List<FoodMenu>  query() throws Exception {
		FoodMenuDao dao = new FoodMenuDao();
		
		return dao.queryFoodMenu();
	}
	
	// 按条件查询
	public List<FoodMenu> query(List<Map<String,Object>> params) throws Exception {
		FoodMenuDao dao = new FoodMenuDao();
		
		return dao.queryFoodMenu(params);
	}
	
	
	
	

//	public static void main(String[] args) throws Exception {
//		
//		FoodMenuDao f = new FoodMenuDao();
//		//插入测试
//		FoodMenu f1 = new FoodMenu();
//		f1.setName("n123");
//		f1.setCount_image("a123a.com");
//		f1.setCircle_image("a123a1.com");
//		f1.setLike_count(2125);
//		f1.setId(6);
//		
//		List<FoodMenu> result = f.queryFoodMenu("harris",1);
//		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
//		Map<String,Object> param = new HashMap<String, Object>();
//		param.put("name", "name");
//		param.put("rela", "like");
//		param.put("value", "'%harris%'");
//		params.add(param);
//		
//		
//		List<FoodMenu> result = f.queryFoodMenu(params);
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).toString());
//		}
//		FoodMenu f2 = f.getFoodMenu(4);
//		System.out.println(f2.toString());
//		
//		f.deleteFoodMenu(6);
//		f.updateFoodMenu(f1);
//		f.addFoodMenu(f1);
		
//		//查询测试
//		//返回集合数据
//		List<FoodMenu> fm = f.queryFoodMenu();
//		//遍历集合
//		for (FoodMenu foodmenu : fm) {
//			System.out.println(foodmenu.getId() + "," 
//							 + foodmenu.getName() + ","
//							 + foodmenu.getCount_image() + ","
//							 + foodmenu.getCircle_image() + ","
//							 + foodmenu.getLike_count());
//		}
//	}
}
