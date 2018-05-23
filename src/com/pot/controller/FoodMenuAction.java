package com.pot.controller;

import com.pot.bean.*;
import com.pot.dao.*;

import java.util.List;

public class FoodMenuAction {

	public static void main(String[] args) throws Exception {
		FoodMenuDao fmd=new FoodMenuDao();
		FoodMenu fm1=new FoodMenu();
		fm1.setId(00);
		fm1.setName("harris");
		fm1.setCount_image("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1782158040,768410558&fm=27&gp=0.jpg");
		fm1.setCircle_image("http://imgsrc.baidu.com/forum/w=580/sign=06e93e0bbd12c8fcb4f3f6c5cc0392b4/7b8727292df5e0feed47c52a586034a85fdf72d2.jpg");
		fm1.setLike_count(704);

        //添加菜单
        fmd.addFoodMenu(fm1);
		
//		FoodMenuDao fmd=new FoodMenuDao();
//		List<FoodMenu> fm=fmd.query();
//		for (FoodMenu foodmenu : fm) {
//			System.out.println(foodmenu.getId()+","
//					+foodmenu.getName()+","
//					+foodmenu.getCount_image()+","
//					+foodmenu.getCircle_image()+","
//					+foodmenu.getLike_count());
//		}
	}
}
