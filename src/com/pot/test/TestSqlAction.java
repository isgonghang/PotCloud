package com.pot.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pot.bean.DynamicRecipes;
import com.pot.bean.FoodMenu;
import com.pot.bean.RecipesDetail;
import com.pot.controller.DynamicRecipesAction;
import com.pot.controller.FoodMenuAction;
import com.pot.controller.RecipesDetailAction;

public class TestSqlAction {

	public static void main(String[] args) throws Exception {
//		FoodMenuAction action = new FoodMenuAction();
//		DynamicRecipesAction action = new DynamicRecipesAction();
		RecipesDetailAction action = new RecipesDetailAction();
		/*查询*/
//		List<FoodMenu> result = action.query();
		
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).getId() + "："
//							   + result.get(i).getName() + "："
//							   + result.get(i).getCount_image() + "："
//							   + result.get(i).getCircle_image() + "："
//							   + result.get(i).getLike_count());
//		}
		
		/*添加*/
		RecipesDetail r = new RecipesDetail();
//		DynamicRecipes d = new DynamicRecipes();
		r.setRecipeId((long) 2);
		r.setImage("aaa");
		r.setScore(5); //小数点报错
		r.setTime(00);
		r.setSource("aaaaaa");
		r.setOther("xxxx");


//
		action.add(r);
		
		/*更新*/
//		action.edit(f);
		
		/*删除*/
//		action.del(6);
		
		//按参数查询
//		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
//		
//		Map<String, Object> map = new HashMap<String,Object>();
//		map.put("name", "recipeid");
//		map.put("rela", "=");
//		map.put("value", "'1'"); //必须加''
//		
//		params.add(map);
//		
//		List<RecipesDetail> result = action.query(params);
//		
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).getRecipeId()+ "："
//							   + result.get(i).getImage() + "："
//							   + result.get(i).getScore() + "："
//							   + result.get(i).getTime() + "："
//							   + result.get(i).getSource() + "："
//							   + result.get(i).getOther());
//		}
//	}

	}
}
