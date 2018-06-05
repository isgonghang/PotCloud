package com.pot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketInfoReader extends Thread {
	private InputStreamReader in;
	private Socket socket;

	public SocketInfoReader(Socket socket) {
		this.socket = socket;

	}

	public void run() {
		try {
			// 3、获取输入流，并读取客户端信息
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String info = br.readLine(); //提取服务器端响应信息
//			while((info = br.readLine()) != null) { // 每次读取服务端响应信息一行，循环读取信息


//			}
			System.out.println(info);
			System.out.println("******已结束读取数据******");
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
