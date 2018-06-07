package com.pot.service;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

public class GoEasyPushPotInfo {
	public void PushInfo(String info) {

		
		GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io","BC-adcc5f82eacf44e3b917ecae5e0c372b");
		goEasy.publish("my_channel", info, new PublishListener(){
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
