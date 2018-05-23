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
        
			String jsonStr = request.getParameter("0");
			System.out.println(jsonStr);
			PrintWriter printWriter = response.getWriter();
			printWriter.write("你好，我是服务器" + jsonStr);
			printWriter.flush();
			printWriter.close();
			
			//请求转发浏览器
			/**
			* 将数据存放到request对象中,此时把request对象当作一个Map容器来使用
			*/
			request.setAttribute("data", jsonStr);
			//客户端访问这个Servlet后，通知服务器将请求转发(forward)到test.jsp页面进行处理
			request.getRequestDispatcher("/main_control.jsp").forward(request, response);
			
			
			count++; //统计客户端数量
			System.out.println("客户端的数量:" + count);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
