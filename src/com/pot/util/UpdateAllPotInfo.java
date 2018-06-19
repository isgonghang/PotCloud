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
import com.pot.bean.AllPotInfo;
import com.pot.bean.PotInfo;
import com.pot.bean.RecipesDetail;
import com.pot.bean.SpecialDynamicRecipes;
import com.pot.controller.PotInfoAction;
import com.pot.controller.RecipesDetailAction;
import com.pot.controller.SpecialDynamicRecipesAction;
import com.pot.service.GoEasyPush;
import com.pot.socket.SocketInfoReader;
import com.pot.socket.SocketInfoWriter;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;

public class UpdateAllPotInfo extends HttpServlet {

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

			SocketOperate socketOperate=new SocketOperate(connection);
			socketOperate.setResponse(response);
			socketOperate.setRequest(request);
			socketOperate.start();

			//启动写线程，向Socket写入判断返回数据指令
			SocketInfoWriter writer = new SocketInfoWriter(connection);
			writer.setInfo("4");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			SocketInfoReader readers = new SocketInfoReader(connection);
			String infos = readers.getInfo();
			System.out.println("获取到的返回值为" + infos);
			
			Gson gson = new Gson();
//			AllPotInfo allPotInfo = gson.fromJson(infos, AllPotInfo.class);
			
			PotInfoAction action = new PotInfoAction(); //获取数据库连接方法
			
			AllPotInfo pi = new AllPotInfo(); //向数据库添加数据
			
			String record = infos;
			String other = "others";
			String defaults = "defaults";

			pi.setRecord(record);
			pi.setOther(other);
			pi.setDefaults(defaults);

			try {
				action.add(pi);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter printWriter = response.getWriter();

			printWriter.flush();
			printWriter.close();
	
		}
		
		
	}
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
