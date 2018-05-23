package com.pot.service;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class DemoTcpSocketServer {  
  
    public static void main(String[] args) {  
        try {  
            ServerSocket server = new ServerSocket(5000);  
            System.out.println("服务器启动");  
            Socket socket = server.accept(); //阻塞等待, 直到一个客户端 socket过来  
            System.out.println("连接成功");  
            BufferedReader in = new BufferedReader(new InputStreamReader(  
                    socket.getInputStream())); //输入，from 客户端  
            PrintWriter out = new PrintWriter(socket.getOutputStream()); //输出，to 客户端  
            System.out.println(in.readLine());  // 打印 客户 socket 发过来的字符，按行(\n,\r,或\r\n)  
            out.println("服务器返回 ^_^ ");   
            out.flush(); // to 客户端，输出  
            socket.close();  
            server.close();  
            System.out.println("服务器结束");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
}  