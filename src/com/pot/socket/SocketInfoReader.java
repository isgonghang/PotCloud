package com.pot.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

import sun.misc.IOUtils;

public class SocketInfoReader extends Thread {
	private Socket socket;
	private static String info;

	public SocketInfoReader(Socket socket) {
		this.socket = socket;

	}

	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		SocketInfoReader.info = info;
	}

	public void run() {
		try {
			// 3、获取输入流，并读取客户端信息
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			//提取服务器端响应信息
			info = br.readLine();

			System.out.println("已结束读取数据" + info);
			
//			//关闭资源
//			br.close();
//			isr.close();
//			is.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		} 
		
	}
}
