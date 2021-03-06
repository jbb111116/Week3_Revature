package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Costume;
import com.revature.utils.ConnectionUtil;

public class CostumeDao {
	
	public Costume getById(int id) {
		String query = "SELECT * FROM costumes WHERE id = ?";
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Costume costume = new Costume();
				costume.setId(rs.getInt("id"));
				costume.setGenre(rs.getString("genre"));
				costume.setAuthenticity(rs.getInt("authenticity"));
				costume.setCreativeness(rs.getInt("creativeness"));
				costume.setCuteness(rs.getInt("cuteness"));
				costume.setScariness(rs.getInt("scariness"));
				costume.setName(rs.getString("name"));
				return costume;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
