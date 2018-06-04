package com.pot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class GetSocketMessage {
    /** 
     * 读取客户端信息 
     * @param inputStream 
     */  
    static void readMessageFromClient(InputStream inputStream) throws IOException {  
        Reader reader = new InputStreamReader(inputStream);  
        BufferedReader br=new BufferedReader(reader);  
        String a = null;  
        while((a=br.readLine())!=null){  
            System.out.println(a);  
        }  
    } 
}
