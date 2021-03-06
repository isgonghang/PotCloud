package com.pot.util;

import com.pot.bean.*;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;

import com.google.gson.Gson;

/*
 * 解析URL处理类
 */
public class UrlParseHandler extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int count = 0; //记录连接次数
		
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("getContentType: " + request.getContentType());  
			System.out.println("getQueryString: " + request.getQueryString());  
			System.out.println("getRemoteAddr: " + request.getRemoteAddr());  
			System.out.println("getRemoteHost: " + request.getRemoteHost());  
			System.out.println("getRemotePort: " + request.getRemotePort());  
			System.out.println("getRemoteUser: " + request.getRemoteUser());  
			System.out.println("getLocalAddr: " + request.getLocalAddr());  
			System.out.println("getLocalName: " + request.getLocalName());  
			System.out.println("getLocalPort: " + request.getLocalPort());  
			System.out.println("getMethod: " + request.getMethod());  
			System.out.println("-------request.getParamterMap()-------"); 
        
			String temperature = request.getParameter("temperature");
			String pressure = request.getParameter("pressure");
			String time = request.getParameter("time");
			System.out.println(temperature + "," + pressure + "," + time);
			PrintWriter printWriter = response.getWriter();
			printWriter.write("你好，我是服务器" + temperature + "," + pressure + "," + time);
			printWriter.flush();
			printWriter.close();
			
			
			count++; //统计客户端数量
			System.out.println("客户端的数量:" + count);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
