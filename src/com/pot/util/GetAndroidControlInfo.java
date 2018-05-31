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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetAndroidControlInfo extends HttpServlet  {
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
		AndroidControlInfo androidControlInfo = gson.fromJson(jsonStr, AndroidControlInfo.class);
		
		
		Integer temerature = androidControlInfo.getTemperature();
		Integer pressure = androidControlInfo.getPressure();
		Long time = androidControlInfo.getTime();
		
		System.out.println(time + "," + pressure + "," + time);
		
		printWriter.flush();
		printWriter.close();

	}
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
