package com.pot.service;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.pot.push.PushInfo2Android;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GoEasyPush {
	
	public static void main(String[] args) {
		//将查询结果转换为json格式
		JSONObject jsonobj = new JSONObject();
		
		jsonobj.put("temperature", 44);
		jsonobj.put("pressure", 16);
		jsonobj.put("time", 600);
		
		
		String potInfo = String.valueOf(jsonobj);
		
		GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io","BC-9a8299840a374746a3dbc5281310cefc");
		goEasy.publish("my_channel", potInfo, new PublishListener(){
			@Override
			public void onSuccess() {
				System.out.print("消息发布成功。");
			}
			@Override
			public void onFailed(GoEasyError error) {
				System.out.print("消息发布失败, 错误编码：" + error.getCode() + " 错误信息： " + error.getContent());
			}
		});
	}
//	public static void PushInfo2Android(String potInfo) {
//		GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io","BC-9a8299840a374746a3dbc5281310cefc");
//		goEasy.publish("my_channel", potInfo, new PublishListener(){
//			@Override
//			public void onSuccess() {
//				System.out.print("消息发布成功。");
//			}
//			@Override
//			public void onFailed(GoEasyError error) {
//				System.out.print("消息发布失败, 错误编码：" + error.getCode() + " 错误信息： " + error.getContent());
//			}
//		});
//	}
		
}
