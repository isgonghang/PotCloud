package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pot.bean.AndroidControlInfo;
import com.pot.service.GoEasyPush;
import com.pot.socket.ServerSocketThreadTest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetAndroidControlInfo extends HttpServlet implements Runnable {
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码文件格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 接收客户端传过来的参数
		System.out.println("Get");
		String jsonStr = request.getParameter("start");
		System.out.println(jsonStr);
		
		// 通过调用GoEasyPush类将信息主动推送到浏览器
		GoEasyPush goEasyPush = new GoEasyPush();
		goEasyPush.PushInfo(jsonStr);
		
		//向Socket中发送数据
//		ServerSocketThreadTest serverSocket = new ServerSocketThreadTest();
//		SubThread subThread = new SubThread();
//		serverSocket.writeMsgToClient(connection.getOutputStream(),"我是服务器发来的消息!!!");
		
		// 将信息输出打印到浏览器中
		PrintWriter printWriter = response.getWriter();
		printWriter.write("你好，我是服务器,接收到的数据为：<br/>" + jsonStr);
		
		// 将参数解析成json格式
		Gson gson = new Gson();
		AndroidControlInfo androidControlInfo = gson.fromJson(jsonStr, AndroidControlInfo.class);
		
		Integer temerature = androidControlInfo.getTemperature();
		Integer pressure = androidControlInfo.getPressure();
		Long time = androidControlInfo.getTime();
		
		String info = time + "," + pressure + "," + time;
		
				
		
		printWriter.flush();
		printWriter.close();
		


	}
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
