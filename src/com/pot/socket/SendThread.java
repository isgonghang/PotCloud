package com.pot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

 public class SendThread extends Thread{  
    private Socket connection;  
    private String string;
    public SendThread(Socket conSocket){  
        this.connection=conSocket;  
    }  
      public void setConnection(Socket connection) {
		this.connection = connection;
	}
    public void run(){  
        try {  
              
            System.out.println("****成功接收到客户端发送的消息******");  
              
            //读取客户端传过来的数据  
            if (connection.getInputStream() == null) {
				System.out.println("输入为空");
			} else {
				readMessageFromClient(connection.getInputStream());  
			}              
            System.out.println("****客户端发送消息结束******");  
            System.out.println();  
              
            //向客户端写入数据  
            writeMsgToClient(connection.getOutputStream(),string);  
              
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
    public void setString(String string) {
		this.string = string;
	}
}
