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
import com.pot.bean.RecipesDetail;
import com.pot.bean.RecipesDetail;

public class RecipesDetailDao {


	// 1. 增加
	public void addRecipesDetail(RecipesDetail rd) throws Exception  {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + "insert into recipesdetail"
				 	 + "(recipeid,image,score,time,source,other)"
				 	 + "values(" 
				 	 + "?,?,?,?,?,?)";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setLong(1, rd.getRecipeId());
		ptmt.setString(2, rd.getImage());
		ptmt.setFloat(3, rd.getScore());
		ptmt.setInt(4, rd.getTime());
		ptmt.setString(5, rd.getSource());
		ptmt.setString(6, rd.getOther());

		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 2. 删除
	public void deleteRecipesDetail(Integer id) throws SQLException {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " delete from recipesdetail "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setInt(1, id);
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 3. 修改
	public void updateRecipesDetail(RecipesDetail rd) throws SQLException {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " update recipesdetail "
				 	 + " set recipeid=?,image=?,score=?,time=?,source=?,other=? "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setLong(1, rd.getRecipeId());
		ptmt.setString(2, rd.getImage());
		ptmt.setFloat(3, rd.getScore());
		ptmt.setInt(4, rd.getTime());
		ptmt.setString(5, rd.getSource());
		ptmt.setString(6, rd.getOther());


		//调用execute()执行改sql语句
		ptmt.execute();
	}
	
	// 4. 查询  可能返回多个数据
	public List<RecipesDetail> queryRecipesDetail() throws Exception {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from recipesdetail ");
		
		List<RecipesDetail> rd = new ArrayList<RecipesDetail>();
		RecipesDetail r = null;
		
		while(rs.next()) {
			r = new RecipesDetail();
			r.setRecipeId(rs.getLong("recipeid"));
			r.setImage(rs.getString("image"));
			r.setScore(rs.getFloat("score"));
			r.setTime(rs.getInt("time"));
			r.setSource(rs.getString("source"));
			r.setOther(rs.getString("other"));
			
		
			rd.add(r);
		}
		return rd;	
	}
	
	// 查询单个数据
	public RecipesDetail getRecipesDetail(Integer id) throws SQLException {
		RecipesDetail rd = null;
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + " select * from recipesdetail "
				 	 + " where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值

		ptmt.setInt(1, id);
		
		//调用execute()执行查询sql语句
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			rd = new RecipesDetail();
			rd.setRecipeId(rs.getLong("id"));
			rd.setImage(rs.getString("image"));
			rd.setScore(rs.getFloat("score"));
			rd.setTime(rs.getInt("time"));
			rd.setSource(rs.getString("source"));
			rd.setOther(rs.getString("other"));

			
		}
		return rd;
	}
	
	// 按条件查询
	public List<RecipesDetail> queryRecipesDetail(List<Map<String,Object>> params) throws Exception { //String name,int id
		List<RecipesDetail> result = new ArrayList<RecipesDetail>();
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select * from recipesdetail where 1=1 ");

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
		
		RecipesDetail rd = null;
		
		while(rs.next()) {
			rd = new RecipesDetail();
			rd.setRecipeId(rs.getLong("recipeid"));
			rd.setImage(rs.getString("image"));
			rd.setScore(rs.getFloat("score"));
			rd.setTime(rs.getInt("time"));
			rd.setSource(rs.getString("source"));
			rd.setOther(rs.getString("other"));
			
			result.add(rd);
		}
		return result;	
	}

}
