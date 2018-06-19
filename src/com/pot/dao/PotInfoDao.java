package com.pot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pot.bean.AllPotInfo;
import com.pot.bean.RecipesDetail;

public class PotInfoDao {
	// 1. 增加
	public void addPotInfo(AllPotInfo pi) throws Exception  {
		//获得数据库连接
		Connection conn = DBUtil.getConnection();
		String sql = ""
				 	 + "insert into potinfo"
				 	 + "(record,other)"
				 	 + "values(" 
				 	 + "?,?)";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参　向　？　中赋值
		ptmt.setString(1, pi.getRecord());
		ptmt.setString(2, pi.getOther());
//		ptmt.setString(3, pi.getDefaults());

		
		//调用execute()执行改sql语句
		ptmt.execute();
	}
}
