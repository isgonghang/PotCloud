package com.pot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pot.bean.DynamicRecipes;
import com.pot.bean.StaticRecipes;

public class StaticRecipesDao {


	// 1. 增加
	public void addStaticRecipes(StaticRecipes sr) throws Exception  {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + "insert into staticrecipes"
				 	 + "(id,name,like,time,image_left,image_right)"
				 	 + "values(" 
				 	 + "?,?,?,?,?,?)";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setLong(1, sr.getId());
		ptmt.setString(2, sr.getName());
		ptmt.setInt(3, sr.getLike());
		ptmt.setString(4, sr.getTime());
		ptmt.setString(5, sr.getImage_left());
		ptmt.setString(6, sr.getImage_right());
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 2. 删除
	public void deleteStaticRecipes(Integer id) throws SQLException {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " delete from staticrecipes "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setInt(1, id);
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 3. 修改
	public void updateStaticRecipes(StaticRecipes sr) throws SQLException {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " update staticrecipes "
				 	 + " set id=?,name=?,like=?,time=?,image_left=?,image_right=? "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setLong(1, sr.getId());
		ptmt.setString(2, sr.getName());
		ptmt.setInt(3, sr.getLike());
		ptmt.setString(4, sr.getTime());
		ptmt.setString(5, sr.getImage_left());
		ptmt.setString(6, sr.getImage_right());
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 4. 查询  可能返回多个数据
	public List<StaticRecipes> queryStaticRecipes() throws Exception {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from staticrecipes ");
		
		List<StaticRecipes> sr = new ArrayList<StaticRecipes>();
		StaticRecipes s = null;
		
		while(rs.next()) {
			s = new StaticRecipes();
			s.setId(rs.getLong("id"));
			s.setName(rs.getString("name"));
			s.setLike(rs.getInt("like"));
			s.setTime(rs.getString("time"));
			s.setImage_left(rs.getString("image_left"));
			s.setImage_right(rs.getString("image_right"));
		
			sr.add(s);
		}
		return sr;	
	}
	
	// 查询单个数据
	public StaticRecipes getStaticRecipes(Integer id) throws SQLException {
		StaticRecipes sr = null;
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " select * from staticrecipes "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值

		ptmt.setInt(1, id);
		
		//调用execute()执行查询sql语句
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			sr = new StaticRecipes();
			sr.setId(rs.getLong("id"));
			sr.setName(rs.getString("name"));
			sr.setLike(rs.getInt("like"));
			sr.setTime(rs.getString("time"));
			sr.setImage_left(rs.getString("image_left"));
			sr.setImage_right(rs.getString("image_right"));
		}
		return sr;
	}
	
	// 按条件查询
	public List<StaticRecipes> queryStaticRecipes(List<Map<String,Object>> params) throws Exception { //String name,int id
		List<StaticRecipes> result = new ArrayList<StaticRecipes>();
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select * from staticrecipes where 1=1 ");
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
		
		StaticRecipes sr = null;
		
		while(rs.next()) {
			sr = new StaticRecipes();
			sr.setId(rs.getLong("id"));
			sr.setName(rs.getString("name"));
			sr.setLike(rs.getInt("like"));
			sr.setTime(rs.getString("time"));
			sr.setImage_left(rs.getString("image_left"));
			sr.setImage_right(rs.getString("image_right"));
			
			result.add(sr);
		}
		return result;	
	}
}
