package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pot.bean.RecipesDetail;
import com.pot.controller.DynamicRecipesAction;
import com.pot.controller.RecipesDetailAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 获取上传云食谱
 */
public class GetRecipesDetail extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 接收客户端传过来的参数
		String idStr = request.getParameter("id");
		// System.out.println("获取到的recipeId为：" + idStr);

		RecipesDetailAction action = new RecipesDetailAction(); // 获取数据库连接方法

		// 按参数查询
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "recipeid");
		map.put("rela", "=");
		map.put("value", idStr); // 必须加''

		params.add(map);

		List<RecipesDetail> result;

		// 将查询结果转换为json格式
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonobj = new JSONObject();
		try {
			TreeMap<Integer, Float> map2 = new TreeMap<>();
			map2.put(0, (float) 15.0);
			map2.put(10, (float) 25.0);
			map2.put(20, (float) 35.0);
			map2.put(30, (float) 50.0);
			map2.put(45, (float) 65.0);
			map2.put(60, (float) 75.0);
			
			result = action.query(params);
			for (int i = 0; i < result.size(); i++) {
				// 生成json
				jsonobj.put("recipeId", result.get(i).getRecipeId());
				jsonobj.put("image", result.get(i).getImage());
				jsonobj.put("score", result.get(i).getScore());
				jsonobj.put("time", result.get(i).getTime());
				jsonobj.put("source", (float) 6.6);
				jsonobj.put("other", result.get(i).getOther());
				jsonobj.put("map",String.valueOf(map2));
				// jsonarray.add(jsonobj);

			}
			System.out.println(String.valueOf(jsonobj));
			// 输出数据
			PrintWriter out = response.getWriter();
			out.println(jsonobj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
