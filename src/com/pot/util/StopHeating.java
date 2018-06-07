package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pot.service.GoEasyPush;
import com.pot.socket.SocketInfoWriter;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;

public class StopHeating extends HttpServlet {
	private Socket socket;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			int count = 0; //记录连接次数
		
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
        
			String stop = request.getParameter("stop");

			System.out.println("获取到的控制命令为：" + stop);
			
			Socket connection = SocketThread.socket;

			if (connection!=null) {
				//启动数据读写处理线程

				SocketOperate socketOperate=new SocketOperate(connection);
				socketOperate.setResponse(response);
				socketOperate.start();

				//启动写线程，向Socket写入判断返回数据指令
				SocketInfoWriter writer = new SocketInfoWriter(connection);
				
				writer.setInfo("6\r\n");
			
			}
			// 通过调用GoEasyPush类将信息主动推送到浏览器
			GoEasyPush goEasyPush = new GoEasyPush();
			goEasyPush.PushInfo(stop);
			
			PrintWriter printWriter = response.getWriter();
			printWriter.write("你好，我是服务器," + "获取到的控制命令为：" + stop);
			printWriter.flush();
			printWriter.close();
			
			
			count++; //统计客户端数量
			System.out.println("客户端的数量:" + count);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		doGet(request, response);
        
		response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8"); 
		
		// 接收到指令后，想客户端返回已收到
		String stop = request.getParameter("stop");
		PrintWriter out = response.getWriter();
		
		if (stop != null && stop.equals("停止")) {
			out.println("已获取停止指令");
		}
		
        out.flush();  //刷新缓存
        out.close();  //关闭输出流
	}
	
}
