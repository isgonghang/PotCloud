package com.pot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketInfoWriter extends Thread {
	private PrintStream out;
	private Socket socket;
	private static String info;
	
	
	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public SocketInfoWriter(Socket socket) {
		this.socket = socket;

	}
	

	public void run() {
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println(info);
			System.out.println(info);
			System.out.println("******已结束发送数据******");
			pw.flush();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
