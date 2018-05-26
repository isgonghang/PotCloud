package com.pot.service;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class DemoTcpSocketServer {  
  
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
	
    public static void main(String[] args) {  
        try {  
        	while(true) {
        		ServerSocket server = new ServerSocket(5000);  
        		System.out.println("服务器启动");  
        		Socket socket = server.accept(); //阻塞等待, 直到一个客户端 socket过来  
        		System.out.println("连接成功");  
            
        		PrintWriter out = new PrintWriter(socket.getOutputStream()); //输出，to 客户端  
        		BufferedReader in = new BufferedReader(new InputStreamReader(  
                    socket.getInputStream())); //输入，from 客户端 
        		out.println(pythonCode); 
        		out.flush(); // to 客户端，输出 
        		System.out.println(in.readLine());  // 打印 客户 socket 发过来的字符，按行(\n,\r,或\r\n)  
        		System.out.println("服务器结束"); 
        		socket.close();  
        	}

        } catch (IOException e) {  
            e.printStackTrace();  
        }   
    }
}  