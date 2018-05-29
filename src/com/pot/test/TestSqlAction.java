package com.pot.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pot.bean.DynamicRecipes;
import com.pot.bean.FoodMenu;
import com.pot.bean.DynamicRecipes;
import com.pot.controller.DynamicRecipesAction;
import com.pot.controller.FoodMenuAction;
import com.pot.controller.DynamicRecipesAction;

public class TestSqlAction {

	public static void main(String[] args) throws Exception {
//		FoodMenuAction action = new FoodMenuAction();
//		DynamicRecipesAction action = new DynamicRecipesAction();
		DynamicRecipesAction action = new DynamicRecipesAction();
		/*查询*/
//		List<DynamicRecipes> result = action.query();
//		
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).getId() + "："
//					   + result.get(i).getName() + "："
//					   + result.get(i).getLike() + "："
//					   + result.get(i).getTime() + "："
//					   + result.get(i).getImage_left() + "："
//					   + result.get(i).getImage_right());
//		}
		
		/*添加*/
//		DynamicRecipes r = new DynamicRecipes();
////		DynamicRecipes d = new DynamicRecipes();
//		r.setRecipeId((long) 2);
//		r.setImage("aaa");
//		r.setScore(5); //小数点报错
//		r.setTime(00);
//		r.setSource("aaaaaa");
//		r.setOther("xxxx");


//
//		action.add(r);
		
		/*更新*/
//		action.edit(f);
		
		/*删除*/
//		action.del(6);
		
		//按参数查询
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		

		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "id");
		map.put("rela", "=");
		map.put("value", "'1'"); //必须加''
		
		params.add(map);
		
		List<DynamicRecipes> result = action.query(params);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId() + "："
					   + result.get(i).getName() + "："
					   + result.get(i).getLike() + "："
					   + result.get(i).getTime() + "："
					   + result.get(i).getImage_left() + "："
					   + result.get(i).getImage_right());
		}

	}
}
