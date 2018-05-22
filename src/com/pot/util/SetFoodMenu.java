package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.pot.bean.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class SetFoodMenu extends HttpServlet {

	//����ʳ��˵�JSON
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Gson menuJson = new Gson();
		List<FoodMenu> menuList= new ArrayList<>();
		
		FoodMenu menu1 = new FoodMenu();
		menu1.setId(1);
		menu1.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu1.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu1.setName("harris");
		menu1.setLike_count(704);
		menuList.add(menu1);
		
		FoodMenu menu2 = new FoodMenu();
		menu2.setId(2);
		menu2.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu2.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu2.setName("harris");
		menu2.setLike_count(704);
		menuList.add(menu2);
		
		FoodMenu menu3 = new FoodMenu();
		menu3.setId(3);
		menu3.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu3.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu3.setName("harris");
		menu3.setLike_count(704);
		menuList.add(menu3);
		
		FoodMenu menu4 = new FoodMenu();
		menu4.setId(4);
		menu4.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu4.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu4.setName("harris");
		menu4.setLike_count(704);
		menuList.add(menu4);
		
		FoodMenu menu5 = new FoodMenu();
		menu5.setId(5);
		menu5.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu5.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu5.setName("harris");
		menu5.setLike_count(704);
		menuList.add(menu5);
		
		FoodMenu menu6 = new FoodMenu();
		menu6.setId(6);
		menu6.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu6.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu6.setName("harris");
		menu6.setLike_count(704);
		menuList.add(menu6);
		
		FoodMenu menu7 = new FoodMenu();
		menu7.setId(7);
		menu7.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu7.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu7.setName("harris");
		menu7.setLike_count(704);
		menuList.add(menu7);
		
		FoodMenu menu8 = new FoodMenu();
		menu8.setId(8);
		menu8.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu8.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu8.setName("harris");
		menu8.setLike_count(704);
		menuList.add(menu8);
		
		FoodMenu menu9 = new FoodMenu();
		menu9.setId(9);
		menu9.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu9.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu9.setName("harris");
		menu9.setLike_count(704);
		menuList.add(menu9);
		
		FoodMenu menu10 = new FoodMenu();
		menu10.setId(10);
		menu10.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		menu10.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		menu10.setName("harris");
		menu10.setLike_count(704);
		menuList.add(menu10);
		
		//���ʳ��˵�JSON
		String jsonObject = menuJson.toJson(menuList);
		System.out.println(jsonObject);
		PrintWriter jsons=res.getWriter();  
        jsons.write(jsonObject); 
	}
	
	
	
}
