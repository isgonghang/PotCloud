package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.google.gson.Gson;
import com.pot.bean.DynamicRecipes;
import com.pot.bean.RecipesDetail;
import com.pot.bean.SpecialDynamicRecipes;
import com.pot.controller.DynamicRecipesAction;
import com.pot.controller.RecipesDetailAction;
import com.pot.controller.SpecialDynamicRecipesAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.management.counter.Variability;

/*
 * 获取动态推荐食谱
 */
public class GetDynamicRecipes extends HttpServlet {
	 
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		DynamicRecipesAction action = new DynamicRecipesAction(); //获取数据库连接方法
		SpecialDynamicRecipesAction action2 = new SpecialDynamicRecipesAction();
		RecipesDetailAction action3 = new RecipesDetailAction();
		
		//将查询结果转换为json格式
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonobj = new JSONObject();
		
		//全部查询
		try {
			List<DynamicRecipes> result = action.query();
			List<SpecialDynamicRecipes> result2 = action2.query();
			List<RecipesDetail> result3 = action3.query();

			for (int i = 0; i < result.size(); i++) {
				jsonobj.put("recipeId", result3.get(i).getRecipeId());
				jsonobj.put("count_image", result3.get(i).getImage());
				jsonobj.put("circle_image", result.get(i).getCircle_image());
				jsonobj.put("name", result.get(i).getName());
				jsonobj.put("like_count", result.get(i).getLike_count());
				
				jsonarray.add(jsonobj); 
			}
			System.out.println(jsonarray);
			// 输出数据
			PrintWriter out = response.getWriter();            
			out.println(String.valueOf(jsonarray));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//按参数查询
//		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
//		Map<String, Object> map = new HashMap<String,Object>();
//		map.put("name", "id");
//		map.put("rela", "=");
//		map.put("value", 1); //必须加''
//		
//		params.add(map);
//		
//		
//		List<DynamicRecipes> result;
		
		//将查询结果转换为json格式
//		JSONArray jsonarray = new JSONArray();
//		JSONObject jsonobj = new JSONObject();
//		try {
//			result = action.query(params);
//			for (int i = 0; i < result.size(); i++) {
//				//生成json
//				jsonobj.put("id", result.get(i).getId());
//				jsonobj.put("name", result.get(i).getName());
//				jsonobj.put("like", result.get(i).getLike());
//				jsonobj.put("time", result.get(i).getTime());
//				jsonobj.put("image_left", result.get(i).getImage_left());
//				jsonobj.put("image_right", result.get(i).getImage_right());
//				
//			}
//			jsonarray.add(jsonobj); 
//			System.out.println(jsonarray);
//			// 输出数据
//			PrintWriter out = response.getWriter();            
//			out.println(String.valueOf(jsonarray));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws  ServletException, IOException {
		doGet(request, response);
	} 
}
