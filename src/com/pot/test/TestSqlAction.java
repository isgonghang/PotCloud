package com.pot.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pot.bean.DynamicRecipes;
import com.pot.bean.FoodMenu;
import com.pot.controller.DynamicRecipesAction;
import com.pot.controller.FoodMenuAction;

public class TestSqlAction {

	public static void main(String[] args) throws Exception {
//		FoodMenuAction action = new FoodMenuAction();
		DynamicRecipesAction action = new DynamicRecipesAction();
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
		DynamicRecipes d = new DynamicRecipes();
		

		d.setName("aaa");
		d.setLike(555);
		d.setTime("000");
		d.setImage_left("aaa.com");
		d.setImage_right("bb.com");

//		action.add(f);
		
		/*更新*/
//		action.edit(f);
		
		/*删除*/
//		action.del(6);
		
		//按参数查询
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "name");
		map.put("rela", "=");
		map.put("value", "'nene'"); //必须加''
		
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
