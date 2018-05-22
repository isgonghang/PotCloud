package com.pot.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnetcion {

	public void get() throws Exception{
		 
		  URL url = new URL("http://127.0.0.1/http/demo.do?name=Jack&age=10");
		  URLConnection urlConnection = url.openConnection();                          // 打开连接
		  BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8")); // 获取输入流
		  String line = null;
		  StringBuilder sb = new StringBuilder();
		  while ((line = br.readLine()) != null) {
		    sb.append(line + "\n");
		  }
		 
		  System.out.println(sb.toString());
		}
}
