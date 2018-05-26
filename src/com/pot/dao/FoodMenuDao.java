package com.pot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pot.bean.FoodMenu;

/*
 * 增删改查方法
 */
public class FoodMenuDao {

	// 1. 增加
	public void addFoodMenu(FoodMenu fm) throws Exception  {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + "insert into foodmenu"
				 	 + "(name,count_image,circle_image,like_count)"
				 	 + "values(" 
				 	 + "?,?,?,?)";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setString(1, fm.getName());
		ptmt.setString(2, fm.getCount_image());
		ptmt.setString(3, fm.getCircle_image());
		ptmt.setInt(4, fm.getLike_count());
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 2. 删除
	public void deleteFoodMenu(Integer id) throws SQLException {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " delete from foodmenu "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setInt(1, id);
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 3. 修改
	public void updateFoodMenu(FoodMenu fm) throws SQLException {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " update foodmenu "
				 	 + " set name=?,count_image=?,circle_image=?,like_count=? "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setString(1, fm.getName());
		ptmt.setString(2, fm.getCount_image());
		ptmt.setString(3, fm.getCircle_image());
		ptmt.setInt(4, fm.getLike_count());
		ptmt.setInt(5, fm.getId());
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 4. 查询  可能返回多个数据
	public List<FoodMenu> queryFoodMenu() throws Exception {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name,count_image,circle_image,like_count from foodmenu ");
		
		List<FoodMenu> fm = new ArrayList<FoodMenu>();
		FoodMenu f = null;
		
		while(rs.next()) {
			f = new FoodMenu();
			f.setId(rs.getInt("id"));
			f.setName(rs.getString("name"));
			f.setCount_image(rs.getString("count_image"));
			f.setCircle_image(rs.getString("circle_image"));
			f.setLike_count(rs.getInt("like_count"));
			
			fm.add(f);
		}
		return fm;	
	}
	
	// 查询单个数据
	public FoodMenu getFoodMenu(Integer id) throws SQLException {
		FoodMenu fm = null;
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " select * from foodmenu "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值

		ptmt.setInt(1, id);
		
		//调用execute()执行查询sql语句
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			fm = new FoodMenu();
			fm.setId(rs.getInt("id"));
			fm.setName(rs.getString("name"));
			fm.setCount_image(rs.getString("count_image"));
			fm.setCircle_image(rs.getString("circle_image"));
			fm.setLike_count(rs.getInt("like_count"));
		}
		return fm;
	}
	
	// 按条件查询
	public List<FoodMenu> queryFoodMenu(List<Map<String,Object>> params) throws Exception { //String name,int id
		List<FoodMenu> result = new ArrayList<FoodMenu>();
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select * from foodmenu where 1=1 ");
//		sb.append(" where name=? and id=? ");
//		sb.append(" where name like ? and id like ? ");
		if(params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String,Object> map = params.get(i);
				sb.append(" and " + map.get("name") + " " 
						          + map.get("rela") + " " 
						          + map.get("value"));
			}
		}
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
//		ptmt.setString(1, "%" + name + "%"); //% 模糊匹配
//		ptmt.setInt(2, id);
		
		System.out.println(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		
		FoodMenu f = null;
		
		while(rs.next()) {
			f = new FoodMenu();
			f.setId(rs.getInt("id"));
			f.setName(rs.getString("name"));
			f.setCount_image(rs.getString("count_image"));
			f.setCircle_image(rs.getString("circle_image"));
			f.setLike_count(rs.getInt("like_count"));
			
			result.add(f);
		}
		return result;	
	}
}
