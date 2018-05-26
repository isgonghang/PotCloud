package com.pot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	// 常量 用于存放url 用户名  密码
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/pot";
	private static final String USER = "root";
	private static final String PASSWORD = "123321";

	private static Connection conn = null;
	
	// 静态块 用于调用
	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库的连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//对外提供方法 获取连接
	public static Connection getConnection() {
		return conn;
	}
	
	
	public static void main(String[] args) throws Exception {
		// 1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获得数据库的连接
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// 3.通过数据库的连接操作数据库，实现增删改查
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name,count_image,circle_image,like_count from foodmenu ");
		
		while(rs.next()) {
			System.out.println(rs.getInt("id") + "," 
							 + rs.getString("name") + "," 
							 + rs.getString("count_image")
							 + rs.getString("circle_image")
							 + rs.getInt("like_count"));
		}
	}
}
