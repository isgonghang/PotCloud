package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pot.bean.AndroidControlInfo;
import com.pot.bean.RecipesDetail;


public class GetAndroidAutoHeating extends HttpServlet  {

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			
		System.out.println("Get");
		String value = request.getParameter("start");
		System.out.println(value);
		PrintWriter printWriter = response.getWriter();
		printWriter.write("你好，我是服务器,接收到的数据为：<br/>" + value);
			
		String jsonStr = request.getParameter("start");
			
		System.out.println(jsonStr);
			
		Gson gson = new Gson();
		RecipesDetail recipesDetail = gson.fromJson(jsonStr, RecipesDetail.class);
			
		Long recipeId = recipesDetail.getRecipeId();
		String image = recipesDetail.getImage();
		Float score = recipesDetail.getScore();
		Integer time = recipesDetail.getTime();
		String source = recipesDetail.getSource();
		String other = recipesDetail.getOther();
			
		System.out.println(recipeId + "," + image + "," + score + "," + time + "," + source+ "," + other);
			
		printWriter.flush();
		printWriter.close();

	}
			
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
