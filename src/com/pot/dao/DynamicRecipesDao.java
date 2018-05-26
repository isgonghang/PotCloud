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

public class DynamicRecipesDao {


	// 1. 增加
	public void addDynamicRecipes(DynamicRecipes dr) throws Exception  {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + "insert into dynamicrecipes"
				 	 + "(id,name,like,time,image_left,image_right)"
				 	 + "values(" 
				 	 + "?,?,?,?,?,?)";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setLong(1, dr.getId());
		ptmt.setString(2, dr.getName());
		ptmt.setInt(3, dr.getLike());
		ptmt.setString(4, dr.getTime());
		ptmt.setString(5, dr.getImage_left());
		ptmt.setString(6, dr.getImage_right());
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 2. 删除
	public void deleteDynamicRecipes(Integer id) throws SQLException {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " delete from dynamicrecipes "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setInt(1, id);
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 3. 修改
	public void updateDynamicRecipes(DynamicRecipes dr) throws SQLException {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " update dynamicrecipes "
				 	 + " set id=?,name=?,like=?,time=?,image_left=?,image_right=? "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setLong(1, dr.getId());
		ptmt.setString(2, dr.getName());
		ptmt.setInt(3, dr.getLike());
		ptmt.setString(4, dr.getTime());
		ptmt.setString(5, dr.getImage_left());
		ptmt.setString(6, dr.getImage_right());
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 4. 查询  可能返回多个数据
	public List<DynamicRecipes> queryDynamicRecipes() throws Exception {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name,like,time,image_left,image_right from dynamicrecipes ");
		
		List<DynamicRecipes> dr = new ArrayList<DynamicRecipes>();
		DynamicRecipes d = null;
		
		while(rs.next()) {
			d = new DynamicRecipes();
			d.setId(rs.getLong("id"));
			d.setName(rs.getString("name"));
			d.setLike(rs.getInt("like"));
			d.setTime(rs.getString("time"));
			d.setImage_left(rs.getString("image_left"));
			d.setImage_right(rs.getString("image_right"));
		
			dr.add(d);
		}
		return dr;	
	}
	
	// 查询单个数据
	public DynamicRecipes getDynamicRecipes(Integer id) throws SQLException {
		DynamicRecipes dr = null;
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " select * from dynamicrecipes "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值

		ptmt.setInt(1, id);
		
		//调用execute()执行查询sql语句
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			dr = new DynamicRecipes();
			dr.setId(rs.getLong("id"));
			dr.setName(rs.getString("name"));
			dr.setLike(rs.getInt("like"));
			dr.setTime(rs.getString("time"));
			dr.setImage_left(rs.getString("image_left"));
			dr.setImage_right(rs.getString("image_right"));
		}
		return dr;
	}
	
	// 按条件查询
	public List<DynamicRecipes> queryDynamicRecipes(List<Map<String,Object>> params) throws Exception { //String name,int id
		List<DynamicRecipes> result = new ArrayList<DynamicRecipes>();
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select * from dynamicrecipes where 1=1 ");
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
		
		DynamicRecipes dr = null;
		
		while(rs.next()) {
			dr = new DynamicRecipes();
			dr.setId(rs.getLong("id"));
			dr.setName(rs.getString("name"));
			dr.setLike(rs.getInt("like"));
			dr.setTime(rs.getString("time"));
			dr.setImage_left(rs.getString("image_left"));
			dr.setImage_right(rs.getString("image_right"));
			
			result.add(dr);
		}
		return result;	
	}
}
