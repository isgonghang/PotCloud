package com.pot.service;

import org.omg.CORBA.PUBLIC_MEMBER;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

public class GoEasyPush {

	public static void main(String[] args) {
		
		GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io","BC-9a8299840a374746a3dbc5281310cefc");
		goEasy.publish("my_channel","Hello, GoEasy!", new PublishListener(){
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
}
