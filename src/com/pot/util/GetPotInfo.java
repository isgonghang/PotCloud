package com.pot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pot.service.GoEasyPush;
import com.pot.service.GoEasyPushPotInfo;
import com.pot.socket.SocketInfoReader;
import com.pot.socket.SocketInfoWriter;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;

public class GetPotInfo extends HttpServlet {

	private Socket socket;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码文件格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Socket connection = SocketThread.socket;

		if (connection!=null) {
			//启动数据读写处理线程
			SocketOperate socketOperate = new SocketOperate(connection);
			socketOperate.setResponse(response);
			socketOperate.start();

			try {
				//启动写线程，向Socket写入判断返回数据指令
				SocketInfoWriter writer = new SocketInfoWriter(connection);
				writer.setInfo("5\r\n");
				
				writer.join();
				
				
				SocketInfoReader reader = new SocketInfoReader(connection);
				String infos = reader.getInfo();
				System.out.println("获取到的返回数据为：" + infos);
				
				Gson gsons = new Gson();
				String sendInfo = gsons.toJson(infos);
				// 通过调用GoEasyPush类将信息主动推送到浏览器
				GoEasyPushPotInfo goEasyPushPotInfo = new GoEasyPushPotInfo();
				goEasyPushPotInfo.PushInfo(sendInfo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			

			
		}
		
		
	}
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
