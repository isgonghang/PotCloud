package com.pot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pot.service.GoEasyPush;
import com.pot.socket.SocketInfoReader;
import com.pot.socket.SocketInfoWriter;
import com.pot.socket.SocketOperate;
import com.pot.socket.SocketThread;

public class SendPythonCode extends HttpServlet {

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
			
			writer.setInfo("3\r\n" + 
					"    OutputStream os = socket.getOutputStream();\r\n" + 
					"    PrintWriter pw = new PrintWriter(os);\r\n" + 
					"	 pw.write(\"user:zzh;password:123\");\r\n" + 
					"	 pw.flush();\r\n" + 
					"	 socket.shutdownOutput();");
			
//			// read file content from file
//            StringBuffer sb= new StringBuffer("");
//            File file = new File("D:\\code.txt");
//            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
//            BufferedReader br = new BufferedReader(reader);
//            String str = null;
//            while((str = br.readLine()) != null) {
//            	str += "\n";
//            	System.out.println("里面" + str);
//            }
//			System.out.println("外面" + str);
//			writer.setInfo(str);
//            br.close();
//            reader.close();


//			SocketInfoReader readers = new SocketInfoReader(connection);
//			String infos = readers.getInfo();
//			System.out.println("获取到的返回值为" + infos);
//			if(infos != null) {
//
//			}
		

			
		}
		
		
	}
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
