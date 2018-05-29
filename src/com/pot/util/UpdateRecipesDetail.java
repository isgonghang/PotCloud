package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.pot.bean.RecipesDetail;
import com.pot.controller.RecipesDetailAction;

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
		
		RecipesDetailAction action = new RecipesDetailAction(); //获取数据库连接方法
		RecipesDetail r = new RecipesDetail(); //向数据库添加数据
		
		Long recipeid = recipesdetail.getRecipeId();
		String image = recipesdetail.getImage();

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
		

		try {
			action.add(r);
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
