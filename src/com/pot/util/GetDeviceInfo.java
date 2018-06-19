package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pot.bean.DeviceInfo;

public class GetDeviceInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		DeviceInfo deviceInfo = new DeviceInfo();
		deviceInfo.getStatusConnect();
		deviceInfo.setDeviceName("压力锅01");
		deviceInfo.setDeviceState("已连接");
		deviceInfo.setDeviceMac("34:de:1a:55:11:12");
		deviceInfo.setLocation(new int[]{172, 20, 10, 6});
		
		Gson gson = new Gson();
		String info = gson.toJson(deviceInfo);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// 输出数据
		PrintWriter out = resp.getWriter();           
		out.println(String.valueOf(info));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
