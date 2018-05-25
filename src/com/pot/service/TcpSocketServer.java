package com.pot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP协议的Socket通信  
 * 服务器端
 */
public class TcpSocketServer {

	public static void main(String[] args) {

		try {
			// 1.创建一个服务器端Socket，即ServerSocket，制定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(5000);
			Socket socket = null;
			
			// 记录客户端数量
			int count = 0;
			
			System.out.println("---服务器已启动，等待客户端的连接---");
			//循环监听等待客户端连接	
			while(true) {
				// 调用accept()方法开始监听，等待客户端的连接
				socket = serverSocket.accept();
				// 创建一个新线程 
				ServerThreadHandler serverThreadHandler = new ServerThreadHandler(socket);
				// 启动线程
				serverThreadHandler.start();
				
				count++; //统计客户端数量
				System.out.println("客户端的数量:" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端IP：" + address.getHostAddress());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}