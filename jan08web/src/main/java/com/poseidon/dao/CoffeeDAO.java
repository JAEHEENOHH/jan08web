package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poseidon.dto.CoffeeDTO;

public class CoffeeDAO extends AbstractDAO {

	public int Coffee(String str) {
		int result = 0;
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO coffee (coffee_menu) VALUES(?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str); 
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, pstmt, con);
		}
		return result;
	
	}

	public List<Map<String, Object>> coffeeList() {
		List<Map<String, Object>> list = null;
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *, COUNT(coffee_menu) AS count FROM coffee GROUP BY coffee_menu";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Map<String, Object> e = new HashMap<>();
				e.put("menu", rs.getString("coffee_menu"));
				e.put("count", rs.getInt("count"));
				
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return list;
	}
}