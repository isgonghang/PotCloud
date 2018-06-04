package com.pot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pot.bean.DynamicRecipes;
import com.pot.bean.SpecialDynamicRecipes;

public class SpecialDynamicRecipesDao {

	// 1. 增加
	public void addSpecialDynamicRecipes(SpecialDynamicRecipes sdr) throws Exception  {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + "insert into dynamicrecipes"
				 	 + "(id,count_image)"
				 	 + "values(" 
				 	 + "?,?)";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setLong(1, sdr.getId());
		ptmt.setString(2, sdr.getCount_image());
		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
	// 4. 查询  可能返回多个数据
	public List<SpecialDynamicRecipes> querySpecialDynamicRecipes() throws Exception {

		List<SpecialDynamicRecipes> result=new ArrayList<SpecialDynamicRecipes>();
		
		//获得数据库连接
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from dynamicrecipes ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		SpecialDynamicRecipes sd = null;
		while(rs.next()) {
			sd = new SpecialDynamicRecipes();
			sd.setId(rs.getLong("id"));
			sd.setCount_image(rs.getString("count_image"));

			result.add(sd);
		}
		return result;	
	}
	
	
	// 按条件查询
	public List<SpecialDynamicRecipes> querySpecialDynamicRecipes(List<Map<String,Object>> params) throws Exception { //String name,int id
		List<SpecialDynamicRecipes> result = new ArrayList<SpecialDynamicRecipes>();
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
		
		SpecialDynamicRecipes sdr = null;
		
		while(rs.next()) {
			sdr = new SpecialDynamicRecipes();
			sdr.setId(rs.getLong("id"));
			sdr.setCount_image(rs.getString("count_image"));;
			
			result.add(sdr);
		}
		return result;	
	}
}
