package com.pot.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.pot.socket.SocketThread;

public class TestSocket {
	 
    public static void main(String[] args) {  
        try {  
            Socket socket = new Socket("172.20.10.6", 5000);  
            System.out.println("Client start!");  
            PrintWriter out = new PrintWriter(socket.getOutputStream()); // 输出，to 服务器 socket  
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 输入， from 服务器 socket  
            out.println("Client request! :-) ");  
            out.flush(); // 刷缓冲输出，to 服务器  
            System.out.println(in.readLine()); // 打印服务器发过来的字符串  
            System.out.println("Client end!");  
            socket.close();  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
    }  
}
