package com.pot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pot.bean.*;

public class FoodMenuDao {

	public void addFoodMenu(){
        
    }
    
    public void updateFoodMenu(){
             
    }
    public void delFoodMenu(){
        
    }
    
    public List<FoodMenu> query() throws Exception{
        Connection con=DBUtil.getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select id,age from foodmenu");
        List<FoodMenu> foodmenu=new ArrayList<FoodMenu>();
        FoodMenu food=null;
        while(rs.next()){//如果对象中有数据，就会循环打印出来
        	food = new FoodMenu();
        	food.setId(rs.getInt("id"));
        	food.setName(rs.getString("name"));
        	food.setCount_image(rs.getString("count_image"));
        	food.setCircle_image(rs.getString("circle_image"));
        	food.setLike_count(rs.getInt("like_count"));
        	foodmenu.add(food);
        }
        return foodmenu;
    }
    
    //查询单个女神
    public FoodMenu get(){
        return null;
    }

	public void addFoodMenu(FoodMenu fm)throws Exception {
		Connection con=DBUtil.getConnection();//首先拿到数据库的连接
        String sql="" + 
                "insert into imooc_goddess"+
                "(id,name,count_image,circle_image,like_count,"+
                "create_id,create_name,create_count_image,create_circle_image,create_like_count,"
                + "update_id,update_name,update_count_image,update_circle_image,update_like_count,"
                + "update_date,isdel) "+
                "values("+
                "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";//参数用?表示，相当于占位符;用mysql的日期函数current_date()来获取当前日期
        //预编译sql语句
        PreparedStatement psmt = con.prepareStatement(sql);
        //先对应SQL语句，给SQL语句传递参数
        psmt.setInt(1, fm.getId());
        psmt.setString(2, fm.getName());
        psmt.setString(3, fm.getCount_image());
        psmt.setString(4, fm.getCircle_image());
        psmt.setInt(5, fm.getLike_count());

        //执行SQL语句
        psmt.execute();
        /**
         * prepareStatement这个方法会将SQL语句加载到驱动程序conn集成程序中，但是并不直接执行
         * 而是当它调用execute()方法的时候才真正执行；
         * 
         * 上面SQL中的参数用?表示，相当于占位符，然后在对参数进行赋值。
         * 当真正执行时，这些参数会加载在SQL语句中，把SQL语句拼接完整才去执行。
         * 这样就会减少对数据库的操作
         */
    }
		
}
