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

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.junit.Test;

import com.pot.util.GetAndroidControlInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.umeng.qq.tencent.Info;

/* Socket服务器端开启线程测试类  
* 
* @date Jul 14, 2016 11:35:32 AM  
*/ 
public class ServerSocketThreadTest {
	private String jsonStr;
	private Thread thread;
	public   static Socket cSocket;
	public ServerSocketThreadTest() {
	
	}
  public void setThread(Thread thread) {
	this.thread = thread;
}
	public String getJsonStr() {
		return jsonStr;
	}
public static Socket getcSocket() {
	return cSocket;
}
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	public static void main(String[] args) {  
        
		//System.out.println(GetAndroidControlInfo.s);

//		testCommon();  
    }  
      
    /** 
     * 1.测试普通的server 
     * @author zzj 
     */  
    public  void testCommon(){  
        ServerSocket serverSocket=null;  
        try {  
            serverSocket = new ServerSocket(5000);  
            while(true){  
                System.out.println("等待客户端连接并发送数据...");  
                //接收客户端连接的socket对象  
               Socket  connection =null;  
                //接收客户端传过来的数据，会阻塞  
                connection=serverSocket.accept();  
               cSocket=connection;
                
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
  
 