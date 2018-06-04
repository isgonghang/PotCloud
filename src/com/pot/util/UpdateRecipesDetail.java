package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.pot.bean.DynamicRecipes;
import com.pot.bean.RecipesDetail;
import com.pot.bean.SpecialDynamicRecipes;
import com.pot.controller.DynamicRecipesAction;
import com.pot.controller.RecipesDetailAction;
import com.pot.controller.SpecialDynamicRecipesAction;

/*
 * 上传云食谱
 */
public class UpdateRecipesDetail extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		System.out.println("Get");
		String value = request.getParameter("recipe");
		System.out.println(value);
		PrintWriter printWriter = response.getWriter();
		printWriter.write("你好，我是服务器,接收到的数据为：<br/>" + value);
		
		String jsonStr = request.getParameter("recipe");
		Gson gson = new Gson();
		RecipesDetail recipesdetail = gson.fromJson(jsonStr, RecipesDetail.class);
		SpecialDynamicRecipes specialDynamicRecipes = gson.fromJson(jsonStr, SpecialDynamicRecipes.class);
		
		RecipesDetailAction action = new RecipesDetailAction(); //获取数据库连接方法
		SpecialDynamicRecipesAction action2 = new SpecialDynamicRecipesAction();
		
		SpecialDynamicRecipes sd = new SpecialDynamicRecipes();
		RecipesDetail r = new RecipesDetail(); //向数据库添加数据
		
		Long recipeid = recipesdetail.getRecipeId();
		Long id = recipesdetail.getRecipeId();
		
		String image = recipesdetail.getImage();
		String image2 = recipesdetail.getImage();

		Float score = recipesdetail.getScore();
		Integer time = recipesdetail.getTime();
		String source = recipesdetail.getSource();
		String other = recipesdetail.getOther();
		
		r.setRecipeId(recipeid);
		r.setImage(image);
		r.setScore(score); //小数点报错
		r.setTime(time);
		r.setSource(source);
		r.setOther(other);
		//将recipedetail上传的id和img存储到dynamicrecipes数据库
		sd.setId(id);
		sd.setCount_image(image2);
		

		try {
			action.add(r);
			action2.add(sd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printWriter.flush();
		printWriter.close();

	}
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
