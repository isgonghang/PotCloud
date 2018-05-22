package com.pot.util;

import com.google.gson.Gson;
import com.pot.bean.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class Gsons extends HttpServlet {
	//生成JSON
	@Test
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		Gson gson = new Gson();
//		EquipmentInfo equipmentInfo = new EquipmentInfo(50,"00:20:00","gh");
//		String jsonObject = gson.toJson(equipmentInfo);
//		System.out.println(jsonObject);
//		
//		PrintWriter jsons=res.getWriter();  
//        jsons.write(jsonObject); 
//        
        
        //食谱
        
        Gson gson = new Gson();
        List<FoodMenu> list=new ArrayList<>();
        for(int i=0;i<15;i++) {
        	 FoodMenu recipes = new FoodMenu();
        	 recipes.setId(i);
        	 recipes.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
        	 recipes.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
        	 recipes.setName("abc");
        	 recipes.setLike_count(200);
        	 list.add(recipes);
        }
       
		String jsonObject = gson.toJson(list);
		System.out.println(jsonObject);
		PrintWriter jsons=res.getWriter();  
        jsons.write(jsonObject); 
        
        
//        Gson gson = new Gson();
//        HashMap<Float,Float> map=new HashMap<>();
//        map.put((float)0, (float)15);
//        map.put((float)10, (float)25);  
//        map.put((float)20, (float)35);  
//        map.put((float)30, (float)45);
//        map.put((float)40, (float)55);
//        map.put((float)50, (float)55);
//        List<RecipeDetail> lists=new ArrayList<>();
//        for(int i=0;i<15;i++) {
//        	RecipeDetail recipes = new RecipeDetail();
//        	recipes.setOther("ff");
//        	recipes.setSource("fafa");
//        	recipes.setRecipeId(0);
//        	recipes.setTime((float)30);
//        	recipes.setMap(map);
//        	recipes.setScore((float) 6.6);
//        	recipes.setImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
//        	list.add(recipes);
//        	 
//        }
	}
	
	
//	
//	//解析JSON
//	@Test
//	public void getJson() {
//		Gson gson = new Gson();
//		String jsonString = "{\"temperature\":50,\"time\":\"00:20:00\",\"user\":\"gh\"}";
//		EquipmentInfo equipmentInfo = gson.fromJson(jsonString, EquipmentInfo.class);
//		System.out.println(equipmentInfo);
//	}
//	
}
