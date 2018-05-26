package com.pot.view;

import java.util.List;
import java.util.Scanner;

import com.pot.bean.FoodMenu;
import com.pot.controller.FoodMenuAction;

public class FoodMenuView {

	private static final String CONTEXT = "欢迎来到食物菜单：\n" + 
			"下面是食物菜单实现的功能列表：\n" + 
			"[MAIN/M]：主菜单\n" + 
			"[QUERY/Q]：查看FoodMenu全部信息\n" + 
			"[GET/G]：查看某个FoodMenu的详细信息\n" +
			"[ADD/A]：添加FoodMenu信息\n" + 
			"[UPDATE/U]：更新FoodMenu信息\n" + 
			"[DELETE/D]：删除FoodMenu信息\n" +
			"[SEARCH/S]：查询FoodMenu信息（根据名称，id查询）\n" + 
			"[EXIT/E]：退出FoodMenu菜单\n" + 
			"[BREAK/B]：退出当前功能，返回主菜单";
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	
	public static void main(String[] args) {
		
		System.out.println(CONTEXT);
		
		//保持程序一直运行
		
		Scanner scan = new Scanner(System.in);//接收控制台参数
		FoodMenu foodmenu = new FoodMenu();
		FoodMenuAction action = new FoodMenuAction();
		
		String prenious=null; //保持此功能
		Integer step = 1; //步骤
		
		while(scan.hasNext()) {
			//跳出循环，实现某一功能
			String in = scan.next().toString();
			if(OPERATION_EXIT.equals(in.toUpperCase()) //退出判断
					|| OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase()) ) {
				System.out.println("您已退出");
				break;
			}if(OPERATION_QUERY.equals(in.toUpperCase()) //查询判断
					|| OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase()) ) {
				try {
					List<FoodMenu> list = action.query();
					for (FoodMenu fm : list) {
						System.out.println(fm.getId() + "," 
										 + fm.getName() + ","
										 + fm.getCount_image() + ","
										 + fm.getCircle_image() + ","
										 + fm.getLike_count());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}  else if (OPERATION_ADD.equals(in.toUpperCase()) //添加判断
					|| OPERATION_ADD.substring(0, 1).equals(in.toUpperCase()) 
					|| OPERATION_ADD.equals(prenious) ){
				prenious = OPERATION_ADD;
				//新增foodmenu
				if (1 == step) {
					System.out.println("请输入FoodMenu的 [name] ");
				}else if (2 == step) {
					foodmenu.setName(in);
					System.out.println("请输入FoodMenu的 [count_image] ");
				}else if (3 == step) {
					foodmenu.setCount_image(in);
					System.out.println("请输入FoodMenu的 [circle_image] ");
				}else if (4 == step) {
					foodmenu.setCircle_image(in);
					System.out.println("请输入FoodMenu的 [like_count] ");
				}else if (5 == step) {
					try {
						foodmenu.setLike_count(Integer.valueOf(in));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("格式有误");
						step = 4;
					}
					
					try {
						action.add(foodmenu);
						System.out.println("新增FoodMenu成功");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("新增FoodMenu失败");
					}
				}
				if (OPERATION_ADD.equals(prenious)) {
					step++;
				}
			} else {
				System.out.println("您输入的值为：" + in.toString());
				
			}
			
		}
	}
}
