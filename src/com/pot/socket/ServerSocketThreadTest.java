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

/* Socket服务器端开启线程测试类  
* 
* @date Jul 14, 2016 11:35:32 AM  
*/ 
public class ServerSocketThreadTest {
	  
    public static void main(String[] args) {  
        testCommon();  
    }  
      
    /** 
     * 1.测试普通的server 
     * @author zzj 
     */  
    public static void testCommon(){  
        ServerSocket serverSocket=null;  
        try {  
            serverSocket = new ServerSocket(5000);  
            while(true){  
                System.out.println("等待客户端连接并发送数据...");  
                //接收客户端连接的socket对象  
                Socket connection =null;  
                //接收客户端传过来的数据，会阻塞  
                connection=serverSocket.accept();  
                new SubThread(connection).start();  
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
}  
  
class SubThread extends Thread{  
    private Socket connection;  
    public SubThread(Socket conSocket){  
        this.connection=conSocket;  
    }  
      
    public void run(){  
        try {  
              
            System.out.println("****成功接收到客户端发送的消息******");  
              
            //读取客户端传过来的数据  
            readMessageFromClient(connection.getInputStream());  
              
            System.out.println("****客户端发送消息结束******");  
            System.out.println();  
              
            //向客户端写入数据  
            writeMsgToClient(connection.getOutputStream(),"我是服务器发来的消息!!!");  
              
            connection.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            if (connection!=null) {  
                try {  
                    connection .close();  
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
