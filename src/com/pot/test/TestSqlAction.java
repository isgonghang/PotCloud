package com.pot.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pot.bean.FoodMenu;
import com.pot.controller.FoodMenuAction;

public class TestSqlAction {

	public static void main(String[] args) throws Exception {
		FoodMenuAction action = new FoodMenuAction();
		
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
		FoodMenu f = new FoodMenu();
		
		f.setName("小a");
		f.setCount_image("111111.com");
		f.setCircle_image("1123.com");
		f.setLike_count(5555);
		f.setId(6);
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
		map.put("value", "'harris'"); //必须加''
		
		params.add(map);
		
		List<FoodMenu> result = action.query(params);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId() + "："
							   + result.get(i).getName() + "："
							   + result.get(i).getCount_image() + "："
							   + result.get(i).getCircle_image() + "："
							   + result.get(i).getLike_count());
		}
	}
}
