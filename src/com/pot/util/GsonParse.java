package com.pot.util;

import com.pot.bean.*;

import org.junit.Test;

import com.google.gson.Gson;

public class GsonParse {
	@Test
	public void demo() {
		String jsonDemo = "{"
				+ "\"id\":1,"
				+ "\"count_image\":\"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg\","
				+ "\"circle_image\":\"http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg\","
				+ "\"name\":\"harris\","
				+ "\"like_count\":202}";
		Gson gsonParse = new Gson();
		FoodMenu foodmenu1 = gsonParse.fromJson(jsonDemo, FoodMenu.class);
		System.out.println(foodmenu1);
	}
	
	
}
