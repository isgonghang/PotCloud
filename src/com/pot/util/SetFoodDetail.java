package com.pot.util;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pot.bean.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class SetFoodDetail extends HttpServlet {

	//生成食物菜单JSON
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Gson menuJson = new Gson();
		List<FoodDetail> detailList= new ArrayList<>();
		
		HashMap<Float,Float> detailMap0=new HashMap<>();
		detailMap0.put((float)0, (float)15);
		detailMap0.put((float)10, (float)25);  
		detailMap0.put((float)20, (float)35);  
		detailMap0.put((float)30, (float)45);
		detailMap0.put((float)40, (float)55);
		detailMap0.put((float)50, (float)55);
		FoodDetail detail0 = new FoodDetail();
		detail0.setRecipeId(0);
		detail0.setImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		detail0.setScore((float) 6.6);
		detail0.setTime((float)30);
		detail0.setSource("harris");
		detail0.setOther("abc");
		detail0.setMap(detailMap0);
		detailList.add(detail0);
		
		HashMap<Float,Float> detailMap1=new HashMap<>();
		detailMap1.put((float)0, (float)15);
		detailMap1.put((float)10, (float)25);  
		detailMap1.put((float)20, (float)35);  
		detailMap1.put((float)30, (float)45);
		detailMap1.put((float)40, (float)55);
		detailMap1.put((float)50, (float)55);
		FoodDetail detail1 = new FoodDetail();
		detail1.setRecipeId(1);
		detail1.setImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		detail1.setScore((float) 6.6);
		detail1.setTime((float)30);
		detail1.setSource("harris");
		detail1.setOther("abc");
		detail1.setMap(detailMap1);
		detailList.add(detail1);
		
		HashMap<Float,Float> detailMap2=new HashMap<>();
		detailMap2.put((float)0, (float)15);
		detailMap2.put((float)10, (float)25);  
		detailMap2.put((float)20, (float)35);  
		detailMap2.put((float)30, (float)45);
		detailMap2.put((float)40, (float)55);
		detailMap2.put((float)50, (float)55);
		FoodDetail detail2 = new FoodDetail();
		detail2.setRecipeId(2);
		detail2.setImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		detail2.setScore((float) 6.6);
		detail2.setTime((float)30);
		detail2.setSource("harris");
		detail2.setOther("abc");
		detail2.setMap(detailMap2);
		detailList.add(detail2);
		
		HashMap<Float,Float> detailMap3=new HashMap<>();
		detailMap3.put((float)0, (float)15);
		detailMap3.put((float)10, (float)25);  
		detailMap3.put((float)20, (float)35);  
		detailMap3.put((float)30, (float)45);
		detailMap3.put((float)40, (float)55);
		detailMap3.put((float)50, (float)55);
		FoodDetail detail3 = new FoodDetail();
		detail3.setRecipeId(3);
		detail3.setImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		detail3.setScore((float) 6.6);
		detail3.setTime((float)30);
		detail3.setSource("harris");
		detail3.setOther("abc");
		detail3.setMap(detailMap3);
		detailList.add(detail3);
		
		HashMap<Float,Float> detailMap4=new HashMap<>();
		detailMap4.put((float)0, (float)15);
		detailMap4.put((float)10, (float)25);  
		detailMap4.put((float)20, (float)35);  
		detailMap4.put((float)30, (float)45);
		detailMap4.put((float)40, (float)55);
		detailMap4.put((float)50, (float)55);
		FoodDetail detail4 = new FoodDetail();
		detail4.setRecipeId(4);
		detail4.setImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		detail4.setScore((float) 6.6);
		detail4.setTime((float)30);
		detail4.setSource("harris");
		detail4.setOther("abc");
		detail4.setMap(detailMap4);
		detailList.add(detail4);
		
		HashMap<Float,Float> detailMap5=new HashMap<>();
		detailMap5.put((float)0, (float)15);
		detailMap5.put((float)10, (float)25);  
		detailMap5.put((float)20, (float)35);  
		detailMap5.put((float)30, (float)45);
		detailMap5.put((float)40, (float)55);
		detailMap5.put((float)50, (float)55);
		FoodDetail detail5 = new FoodDetail();
		detail5.setRecipeId(5);
		detail5.setImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		detail5.setScore((float) 6.6);
		detail5.setTime((float)30);
		detail5.setSource("harris");
		detail5.setOther("abc");
		detail5.setMap(detailMap5);
		detailList.add(detail5);
		
		HashMap<Float,Float> detailMap6=new HashMap<>();
		detailMap6.put((float)0, (float)15);
		detailMap6.put((float)10, (float)25);  
		detailMap6.put((float)20, (float)35);  
		detailMap6.put((float)30, (float)45);
		detailMap6.put((float)40, (float)55);
		detailMap6.put((float)50, (float)55);
		FoodDetail detail6 = new FoodDetail();
		detail6.setRecipeId(6);
		detail6.setImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		detail6.setScore((float) 6.6);
		detail6.setTime((float)30);
		detail6.setSource("harris");
		detail6.setOther("abc");
		detail6.setMap(detailMap6);
		detailList.add(detail6);
		
		//输出食物菜单JSON
		String jsonObject = menuJson.toJson(detailList);
		System.out.println(jsonObject);
		PrintWriter jsons=res.getWriter();  
        jsons.write(jsonObject); 
	}
	
	
	
}
