package com.pot.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pot.util.*;

public class Server extends HttpServlet {  
	  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {  
        PrintWriter pw=res.getWriter();  
        pw.write("Hello World ! "); 
        
        req.getParameter("temperature");
        req.getContextPath();
        req.getRequestDispatcher("index.html").forward(req, res);
        
        String requestUrl = req.getRequestURI().toString(); //�õ������URL��ַ
        String requestUri = req.getRequestURI(); //�õ��������Դ
        
        String queryString = req.getQueryString(); //�õ������URL��ַ�и����Ĳ���
        
        String remoteAddr = req.getRemoteAddr(); //�õ������IP��ַ
        String remoteHost = req.getRemoteHost();
        int remotePort = req.getRemotePort();
        String remoteUser = req.getRemoteUser();
        String method = req.getMethod();//�õ�����URL��ַʱʹ�õķ���
        String pathInfo = req.getPathInfo();
        String localAddr = req.getLocalAddr();//��ȡWEB��������IP��ַ
        String localName = req.getLocalName();//��ȡWEB��������������
        res.setCharacterEncoding("UTF-8");//���ý��ַ���"UTF-8"����������ͻ��������
        //ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ���ݣ����������仰����ô�������ʾ�Ľ�������
        res.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.write("��ȡ���Ŀͻ�����Ϣ���£�");
        out.write("<hr/>");
        out.write("�����URL��ַ��"+requestUrl);
        out.write("<br/>");
        out.write("�������Դ��"+requestUri);
        out.write("<br/>");
        out.write("�����URL��ַ�и����Ĳ�����"+queryString);
        out.write("<br/>");
        out.write("�����ߵ�IP��ַ��"+remoteAddr);
        out.write("<br/>");
        out.write("�����ߵ���������"+remoteHost);
        out.write("<br/>");
        out.write("ʹ�õĶ˿ںţ�"+remotePort);
        out.write("<br/>");
        out.write("remoteUser��"+remoteUser);
        out.write("<br/>");
        out.write("����ʹ�õķ�����"+method);
        out.write("<br/>");
        out.write("pathInfo��"+pathInfo);
        out.write("<br/>");
        out.write("localAddr��"+localAddr);
        out.write("<br/>");
        out.write("localName��"+localName);
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(req, res);
		
		res.setContentType("text/html;charset=UTF-8");  
        System.out.println("POST�������óɹ�"); 
        
        res.sendRedirect("index.html");
	}  
} 
