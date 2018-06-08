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
		String autoInfo = request.getParameter("start");
		System.out.println(autoInfo);
//		PrintWriter printWriter = response.getWriter();
//		printWriter.write("你好，我是服务器,接收到的数据为：<br/>" + autoInfo);		
//		Gson gson = new Gson();
//		RecipesDetail recipesDetail = gson.fromJson(autoInfo, RecipesDetail.class);	
////		只发送加热曲线，故只取得Map曲线
//		TreeMap<Integer, Float> map = recipesDetail.getMap();
		//向压力锅发送加热曲线
		Socket connection = SocketThread.socket;		
//		//test
//		TreeMap<Integer, Float> map2 = new TreeMap<>();
//		map2.put(0, (float) 15.0);
//		map2.put(10, (float) 25.0);
//		map2.put(20, (float) 35.0);
//		map2.put(30, (float) 50.0);
//		map2.put(45, (float) 65.0);
//		map2.put(60, (float) 75.0);	
//		
		Gson gsons = new Gson();
		String potInfo = gsons.toJson(autoInfo);
		if (connection!=null) {
			//启动数据读写处理线程
			SocketOperate socketOperate=new SocketOperate(connection);
			socketOperate.setResponse(response);
			socketOperate.start();
			//启动写线程，向Socket写入判断返回数据指令
			SocketInfoWriter writers = new SocketInfoWriter(connection);
			writers.setInfo("2\r\n" + autoInfo);
		}			
//		printWriter.flush();
//		printWriter.close();
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
