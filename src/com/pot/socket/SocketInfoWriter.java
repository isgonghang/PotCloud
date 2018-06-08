package com.pot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketInfoWriter extends Thread {
	private Socket socket;
	private static String info;
	
	public SocketInfoWriter(Socket socket) {
		this.socket = socket;

	}
	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}

	public void run() {
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println(info);
			System.out.println("\n" + "已结束发送数据" + info);
			pw.flush();
//			pw.close();
//			os.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
