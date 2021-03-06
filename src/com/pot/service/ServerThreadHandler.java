package com.pot.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 服务器端线程处理类
 */
public class ServerThreadHandler extends Thread {
	
	//程序代码
	private static String pythonCode = "import time\r\n" + 
			"channels = [6,13,19,26]\r\n" + 
			"def init():\r\n" + 
			"	IO.setmode(IO.BCM)\r\n" + 
			"	for x in channels:\r\n" + 
			"		IO.setup(x,IO.OUn\"\r\n" + 
			"def on(i):\r\n" + 
			"	IO.output(IO.HIGH)\r\n" + 
			"def off(i):\r\n" + 
			"	IO.output(IO.LOW)\r\n" + 
			"def ctrl(data):\r\n" + 
			"	on(data)\r\n" + 
			"	time.sleep(3)\r\n" + 
			"	off(data)\r\n" + 
			"def test():\r\n" + 
			"	for i in channels:\r\n" + 
			"		ctrl(i)\r\n" + 
			"		time.sleep(0,1)	\r\n" + 
			"def clean():\r\n" + 
			"	IO.cleanup()\r\n" + 
			"init()\r\n" + 
			"test()\r\n" + 
			"clean()";
	
	// 和本线程相关的Socket
	Socket socket = null;
	
	public ServerThreadHandler(Socket socket) {
		this.socket = socket; // 初始化和本线程相关的S
	}
	
	// 线程执行的操作，响应客户端的请求
	public void run() {
		InputStream inputStream  = null;
		InputStreamReader inputStreamReader  = null;
		BufferedReader bufferedReader  = null;
		OutputStream outputStream  = null;
		PrintWriter printWriter  = null;
		PrintStream printStream = null;
		try {
			// 获取输入流，并读取客户端所发信息
			inputStream = socket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			
			String info = null; //客户端提取信息
			while((info = bufferedReader.readLine()) != null) { // 每次读取客户端一行，循环读取信息
				System.out.println("我是服务器端，客户端说：" + info);
				printWriter.println("我是服务器端，客户端说：" + info);
			}
			
			socket.shutdownInput(); // 关闭输入流
			
			// 获取输出流，响应客户端请求
			
			//向客户端  输出
			printWriter = new PrintWriter(socket.getOutputStream());
			//输入，from 客户端 
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			printWriter.println(pythonCode); 
			printWriter.flush(); // to 客户端，输出 
//            System.out.println(in.readLine());  // 打印 客户 socket 发过来的字符，按行(\n,\r,或\r\n)  
            System.out.println("服务器结束"); 
            socket.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.关闭资源
			try {
				if(printWriter != null) {
					printWriter.close();
				}
				if(outputStream != null) {
					outputStream.close();
				}
				if(bufferedReader != null) {
//					outputStream.close();
				}
				if(inputStreamReader != null) {
					inputStreamReader.close();
				}
				if(inputStream != null) {
					inputStream.close();
				}
				if(socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
