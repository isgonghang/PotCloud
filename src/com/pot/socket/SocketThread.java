package com.pot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/** 
* Socket启动线程并进行端口监听 
*/
public class SocketThread extends Thread {

	private ServerSocket serverSocket = null;
	
	/*
	 *  开启ServerSocket端口
	 */
	public SocketThread(ServerSocket serverScoket){ 
		try { 
			if(serverSocket == null){ 
				//开启Socket服务器端5000端口
				serverSocket = new ServerSocket(5000); 
				System.out.println("\n" + "Socket服务器已成功启动\n"); 
			} 
		} catch (Exception e) { 
			System.out.println("SocketThread创建socket服务出错"); 
			e.printStackTrace(); 
		} 

	} 

	/*
	 * 开启线程进行ServerSocket端口监听、等待客户端连接并进行数据交互
	 */
	public static Socket socket;
	public void run(){ 
		while(!this.isInterrupted()){ 
			try { 
				socket = serverSocket.accept(); //阻塞等待, 直到一个客户端 socket过来 
				System.out.println("\n" + "已成功监听Socket连接端口，并等待压力锅客户端发送数据！\n");

				if(socket != null && !socket.isClosed()){ 
					//启动发送数据和处理接受的数据类 
					new SocketOperate(socket).start(); 
//					System.out.println("接收发送数据线程已经成功启动");
				} 
//			socket.setSoTimeout(30000); 

			}catch (Exception e) { 
				e.printStackTrace(); 	
			} 
		} 
	}

			
	

	public void closeSocketServer(){ 
		try { 
			if(null!=serverSocket && !serverSocket.isClosed()) { 
				serverSocket.close(); 
			} 
		} catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	} 
}
