package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pot.bean.AndroidControlInfo;
import com.pot.bean.RecipesDetail;
import com.pot.socket.SocketInfoWriter;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;


public class GetAndroidAutoHeating extends HttpServlet  {

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//向压力锅发送加热曲线
		Socket connection = SocketThread.socket;
		
		//test
		TreeMap<Integer, Float> map2 = new TreeMap<>();
		map2.put(0, (float) 15.0);
		map2.put(10, (float) 25.0);
		map2.put(20, (float) 35.0);
		map2.put(30, (float) 50.0);
		map2.put(45, (float) 65.0);
		map2.put(60, (float) 75.0);
		
		Gson gsons = new Gson();
		String jsonStr2 = gsons.toJson(map2);
		
		
		if (connection!=null) {
			//启动数据读写处理线程

			SocketOperate socketOperate=new SocketOperate(connection);
			socketOperate.setResponse(response);
			socketOperate.setRequest(request);
			socketOperate.start();

			//启动写线程，向Socket写入判断返回数据指令
			SocketInfoWriter writer = new SocketInfoWriter(connection);
			
			writer.setInfo("2\r\n" + jsonStr2);
		}
		
		
			
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
