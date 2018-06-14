package com.pot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.pot.push.JiguangPush;

/*
 * 基于TCP协议的Socket通信  
 * 客户端
 */
public class TcpSocketClient {

	public static void main(String[] args) {
		try {
			while (true) {
				
		
			// 1.创建客户端Socket，指定服务器地址和端口
			Socket socket = new Socket("localhost",5000);
			

			
			
			
			// 3.获取输入流，并读取服务器端的响应信息
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); //字节流包装为字符流
			String info = null; //提取服务器端响应信息
			System.out.println("我是客户端，服务器说：");
			while(Integer.valueOf((info = bufferedReader.readLine())) == 5) { // 每次读取服务端响应信息一行，循环读取信息
				System.out.println(info);
				
				// 2.获取输出流，用来向服务器端发送信息
				OutputStream outputStream = socket.getOutputStream(); // 字节输入流
				PrintWriter printWriter = new PrintWriter(outputStream); //将输出流包装为打印流

				printWriter.println("{\"temp\":35,\"pre\":25}");
				printWriter.flush(); // 刷新缓存
			}
			System.out.println("结束输入");
			
			// 4.关闭资源
			bufferedReader.close();
			inputStream.close();
//			printWriter.close();
//			outputStream.close();
			socket.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}