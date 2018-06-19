package com.pot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pot.push.JiguangPush;

/* 
* 多线程
* 从Socket端口接收压力锅数据
* 向Socket端口发送控制数据
*/
public class SocketOperate extends Thread {
	private Socket socket;
	private HttpServletResponse response;
	private HttpServletRequest request;

	public SocketOperate(Socket socket) {
		this.socket = socket;

	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void run() {
		try {
			System.out.println("\n" + "成功调用数据接收发送处理类，开始进行数据的接收和发送！\n" );
			
			if (this.request != null || this.response != null) {
				
			
            // 创建一个写线程
            new SocketInfoWriter(socket).start();

            // 创建一个读线程
            new SocketInfoReader(socket).start();
			}

		} finally {

		}
	}


}