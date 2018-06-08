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
import com.pot.socket.SocketInfoReader;
import com.pot.socket.SocketInfoWriter;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;

import anetwork.channel.aidl.Connection;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetAndroidControlInfo extends HttpServlet{

	private Socket socket;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码文件格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 接收客户端传过来的参数
		String jsonStr = request.getParameter("start");
		System.out.println(jsonStr + "not auto");
		//开启Socket线程
		Socket connection = SocketThread.socket;
		if (connection!=null) {
			//启动数据读写处理线程
			SocketOperate socketOperate=new SocketOperate(connection);
			socketOperate.setResponse(response);
			socketOperate.start();
			//启动写线程，向Socket写入数据
			SocketInfoWriter writer = new SocketInfoWriter(connection);
			writer.setInfo("1\r\n" + jsonStr);
		}		
		// 通过调用GoEasyPush类将信息主动推送到浏览器
		GoEasyPush goEasyPush = new GoEasyPush();
		goEasyPush.PushInfo(jsonStr);	
	}
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
