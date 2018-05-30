package com.pot.service;

import org.java_websocket.WebSocketImpl;

public class WebSocketStart {

	public static void main(String[] args) {
		WebSocketImpl.DEBUG = false;
        int port = 5000; // 端口
        WebSocketServer2Browser s = new WebSocketServer2Browser(port);
        s.start();
        System.out.println("WebSocket已经成功启动");
	}

}
