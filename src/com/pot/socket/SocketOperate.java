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
	

	public void run() {
		try {
			System.out.println("***************************************\n" + "\n"
					+ "      成功调用数据接收发送处理类，开始进行数据的接收和发送！\n" + "\n" + "***************************************");

			// 3、获取输入流，并读取客户端信息
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String info = br.readLine(); //提取服务器端响应信息
//			while((info = br.readLine()) != null) { // 每次读取服务端响应信息一行，循环读取信息


//			}
			System.out.println(info);
			

			if (response != null) {
				System.out.println("response 非空");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter printWriter = response.getWriter();
				printWriter.write(handle(info));

//				printWriter.flush();
				printWriter.close();
			}

			System.out.println("******已结束接收数据******");

			// 4、获取输出流，响应客户端的请求
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println("import time\r\n" + "channels = [6,13,19,26]\r\n" + "def init():\r\n"
					+ "	IO.setmode(IO.BCM)\r\n" + "	for x in channels:\r\n" + "		IO.setup(x,IO.OUn\"\r\n"
					+ "def on(i):\r\n" + "	IO.output(IO.HIGH)\r\n" + "def off(i):\r\n" + "	IO.output(IO.LOW)\r\n"
					+ "def ctrl(data):\r\n" + "	on(data)\r\n" + "	time.sleep(3)\r\n" + "	off(data)\r\n"
					+ "def test():\r\n" + "	for i in channels:\r\n" + "		ctrl(i)\r\n"
					+ "		time.sleep(0,1)	\r\n" + "def clean():\r\n" + "	IO.cleanup()\r\n" + "init()\r\n"
					+ "test()\r\n" + "clean()\r\n");
			System.out.println("******已结束发送数据******");
			pw.flush();

			 //5、关闭资源
			 pw.close();
			 os.close();
			 socket.shutdownOutput();
			 br.close();
			 isr.close();
			 is.close();
			 socket.shutdownInput();

		} catch (IOException ex) {

		} finally {

		}
	}

	public static String handle(String jsonStr) {
		String result = "来自设备的json数据：";
		return result+jsonStr;
	}

}