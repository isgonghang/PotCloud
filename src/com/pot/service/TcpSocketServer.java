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
			ServerSocket serverSocket = new ServerSocket(9999);
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
			
			
			
//			// 1.创建一个服务器端Socket，即ServerSocket，制定绑定的端口，并监听此端口
//			ServerSocket serverSocket = new ServerSocket(9999);
//			
//			// 2.调用accept()方法开始监听，等待客户端的连接
//			System.out.println("---服务器已启动，等待客户端的连接---");
//			Socket socket = serverSocket.accept();
//			
//			// 3.获取输入流，并读取客户端所发信息
//			InputStream inputStream =  socket.getInputStream(); // 字节输入流
//			InputStreamReader inputStreamReader = new InputStreamReader(inputStream); // 将字节流转换为字符流
//			BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // 为输入流添加缓冲
//			String info = null; //客户端提取信息
//			while((info = bufferedReader.readLine()) != null) { // 每次读取客户端一行，循环读取信息
//				System.out.println("我是服务器端，客户端说：" + info);
//			}
//			
//			socket.shutdownInput(); // 关闭输入流
//			
//			// 4.获取输出流，响应客户端请求
//			OutputStream outputStream = socket.getOutputStream();
//			PrintWriter printWriter = new PrintWriter(outputStream); // 包装为打印流
//			printWriter.write("欢迎您！");
//			printWriter.flush(); //刷新缓存
//			
//			// 5.关闭资源
//			printWriter.close();
//			bufferedReader.close();
//			inputStreamReader.close();
//			inputStream.close();
//			socket.close();
//			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
