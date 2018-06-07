package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pot.push.JiguangPush;
import com.pot.socket.SocketInfoWriter;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;

public class EmergencyStop extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		Socket connection = SocketThread.socket;

		if (connection!=null) {
			//启动数据读写处理线程

			SocketOperate socketOperate=new SocketOperate(connection);
			socketOperate.setResponse(resp);
			socketOperate.start();

			//启动写线程，向Socket写入判断返回数据指令
			SocketInfoWriter writer = new SocketInfoWriter(connection);
			
			writer.setInfo("6\r\n");
		
		}
		
		JiguangPush jgPush = new JiguangPush();
		jgPush.sendAllsetNotification("压力锅温度过高，已紧急停止。。。。"); 
		
		// 将信息输出打印到浏览器中
		PrintWriter printWriter = resp.getWriter();
		printWriter.write("你好，我是服务器,已成功停止<br/>" );
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doGet(req, resp);
	}
}
