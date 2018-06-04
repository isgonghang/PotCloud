package com.pot.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pot.bean.AndroidControlInfo;
import com.pot.service.GoEasyPush;
import com.pot.socket.SendThread;
import com.pot.socket.ServerSocketThreadTest;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;

import anetwork.channel.aidl.Connection;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetAndroidControlInfo extends HttpServlet implements Runnable {
	public static String strs;
	private Socket socket;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码文件格式
		System.out.println("执行doget");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 接收客户端传过来的参数
		
		String jsonStr = request.getParameter("start");
//		System.out.println(jsonStr);
		
		Socket connection=SocketThread.socket;

		if (connection!=null) {
			System.out.println("connection非空");
			SocketOperate socketOperate=new SocketOperate(connection);
			socketOperate.setResponse(response);
			socketOperate.start();
		}
		
		


		
//		System.out.println(jsonStr);
//		strs = "asd";
//		new ServerSocketThreadTest().setJsonStr(jsonStr);
		
		
		// 通过调用GoEasyPush类将信息主动推送到浏览器
		GoEasyPush goEasyPush = new GoEasyPush();
		goEasyPush.PushInfo(jsonStr);
		
		//向Socket中发送数据
//		ServerSocketThreadTest serverSocket = new ServerSocketThreadTest();
//		SubThread subThread = new SubThread();
//		serverSocket.writeMsgToClient(connection.getOutputStream(),"我是服务器发来的消息!!!");
		
		// 将信息输出打印到浏览器中
//		PrintWriter printWriter = response.getWriter();
//		printWriter.write("你好，我是服务器,接收到的数据为：<br/>" + jsonStr);		
//		
//		printWriter.flush();
//		printWriter.close();
		
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
