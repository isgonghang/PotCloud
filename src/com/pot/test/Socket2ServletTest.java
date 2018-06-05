package com.pot.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class SocketServer extends Thread  
{  
    private Socket socket;  
    public SocketServer(Socket socket)  
    {  
        this.socket = socket;  
    }  
  
    public void run()  
    {  
        String output = "";  
        try  
        {  
            BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
            PrintWriter pw = new PrintWriter(socket.getOutputStream());  
            String line = null;  
            line = bfr.readLine();  
            output = "server send====================";  
            pw.println(output);  
            pw.flush();  
            bfr.close();  
            pw.close();  
            socket.close();  
        }  
        catch (IOException ioex)  
        {  
            ioex.printStackTrace();  
        }  
    }  
}  
  
public class Socket2ServletTest extends HttpServlet {  
    private String message;  
  
    public void init() throws ServletException  
    {  
        System.out.println("=================hello world=================");  
        new Thread() {  
            public void run()  
            {  
                try  
                {  
                    ServerSocket server = new ServerSocket(30000);  
                    Socket socket = null;  
                    while (true)  
                    {  
                        socket = server.accept();  
                        SocketServer ss = new SocketServer(socket);  
                        ss.start();  
                    }  
                }  
                catch (IOException ex)  
                {  
                    System.out.println(ex.getMessage());  
                }  
            }  
        }.start();  
        System.out.println("_______________________hello world___________________________");  
  }  
    
  public void doGet(HttpServletRequest request,  
                    HttpServletResponse response)  
            throws ServletException, IOException  
  {  
      response.setIntHeader("Refresh", 1);  
      response.setContentType("text/html");  
      response.setHeader("content-type","text/html;charset=gb2312");  
  
      Calendar calendar = new GregorianCalendar();  
      String am_pm;  
      int hour = calendar.get(Calendar.HOUR);  
      int minute = calendar.get(Calendar.MINUTE);  
      int second = calendar.get(Calendar.SECOND);  
      if(calendar.get(Calendar.AM_PM) == 0)  
        am_pm = "AM";  
      else  
        am_pm = "PM";  
   
      String CT = hour+":"+ minute +":"+ second +" "+ am_pm;  
      
      PrintWriter out = response.getWriter();  
      String title = "使用 Servlet 自动刷新页面";  
      String docType =  
      "<!doctype html public \"-//w3c//dtd html 4.0 " +  
      "transitional//en\">\n";  
      out.println(docType +  
        "<html>\n" +  
        "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/> <title>" + title + "</title></head>\n"+  
        "<body bgcolor=\"#f0f0f0\">\n" +  
        "<h1 align=\"center\">" + title + "</h1>\n" +  
        "<p>当前时间是：" + CT + "</p>\n");  
  }  
    
  public void doPost(HttpServletRequest request,  
                     HttpServletResponse response)  
      throws ServletException, IOException {  
     doGet(request, response);  
  }  
  
    
  public void destroy()  
  {  
  }  
}  