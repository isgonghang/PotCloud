package com.pot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	  
    public static void main(String[] args) {  
        testCommon();  
    }  
      
    /** 
     * 1.测试普通的server 
     * 
     */  
    public static void testCommon(){  
        ServerSocket serverSocket=null;  
        try {  
            serverSocket = new ServerSocket(22);  
            while(true){  
                System.out.println("wait receive message from client...");  
                //接收客户端连接的socket对象  
                Socket connection =null;  
                try {  
                    //接收客户端传过来的数据，会阻塞  
                    connection=serverSocket.accept();  
                      
                    System.out.println("****received message from client******");  
                      
                    //读取客户端传过来的数据  
                    readMessageFromClient(connection.getInputStream());  
                      
                    System.out.println("****received message from client end******");  
                      
                    //向客户端写入数据  
                    writeMsgToClient(connection.getOutputStream(),"I am server message!!!");  
                      
                    connection.close();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }finally{  
                    if (connection!=null) {  
                        connection .close();  
                    }  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            if (serverSocket!=null) {  
                try {  
                    serverSocket.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
  
    /** 
     * 读取客户端信息 
     * @param inputStream 
     */  
    private static void readMessageFromClient(InputStream inputStream) throws IOException {  
        Reader reader = new InputStreamReader(inputStream);  
        BufferedReader br=new BufferedReader(reader);  
        String a = null;  
        while((a=br.readLine())!=null){  
            System.out.println(a);  
        }  
    }  
  
    /** 
     * 响应客户端信息 
     * @param outputStream 
     * @param string 
     */  
    private static void writeMsgToClient(OutputStream outputStream, String string) throws IOException {  
        Writer writer = new OutputStreamWriter(outputStream);  
        writer.append("I am server message!!!");  
        writer.flush();  
        writer.close();  
    }  
}
