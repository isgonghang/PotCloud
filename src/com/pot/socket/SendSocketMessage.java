package com.pot.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class SendSocketMessage {
    /** 
     * 响应客户端信息 
     * @param outputStream 
     * @param string 
     */  
	private String string;
    static void writeMsgToClient(OutputStream outputStream, String string) throws IOException {  
        Writer writer = new OutputStreamWriter(outputStream);  
        writer.append("I am server message!!!");  
        writer.flush();  
        writer.close();  
    }
	
    public void setString(String string) {
		this.string = string;
	}
}
