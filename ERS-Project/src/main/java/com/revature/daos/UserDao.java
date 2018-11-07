package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDao {
	// ---------------------------------Employee Connection----------------------------------------
		private User extractEmployee(ResultSet rs) throws SQLException {
			User extracted = new User();
			extracted.setUser_id(rs.getInt("users.id"));
			extracted.setUsername(rs.getString("username"));
			extracted.setPassword(rs.getString("psswrd"));
			extracted.setFirstName(rs.getString("first_name"));
			extracted.setLastName(rs.getString("last_name"));
			extracted.setRole(rs.getInt("user_role_id"));

			return extracted;
		}
		
		private int extractUserId(ResultSet rs) throws SQLException {
			int id = rs.getInt("user_role_id");
			return id;
			
		}

		public User employeeLogin(String username) {
			try (Connection conn = ConnectionUtil.getConnection()) {
				User user = null;
				String query = "SELECT * FROM users  WHERE username = ?;";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				rs.next();
				user = extractEmployee(rs);
				System.out.println(user);
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public User createEmployee(User user) {
			try(Connection conn = ConnectionUtil.getConnection()){
				String query = "INSERT INTO users (username,psswrd,user_first_name,user_last_name,user_email,user_role_id) VALUES (?,?,?,?,?,?) RETURNING username;";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFirstName());
				ps.setString(4, user.getLastName());
				ps.setInt(5,1);
				
				ResultSet rs = ps.executeQuery();
				rs.next();
				user.setUser_id(rs.getInt("users_id"));
				System.out.println("Your employee was made.");
				return user;
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		
		//------------------------------------------------------------------------------------------
		/*
		 * 
		 */
		// -----------------------Neutral Functions-------------------------------------------------
		public void promoteByUsername(User user) {

			try(Connection conn = ConnectionUtil.getConnection()){
				String query = "UPDATE users SET user_role_id = ? WHERE = ?;";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, 2);
				ps.setString(2, user.getUsername());
				ps.execute();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void demoteByUsername(User user) {

			try(Connection conn = ConnectionUtil.getConnection()){
				String query = "UPDATE users SET user_role_id = ? WHERE = ?;";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, 1);
				ps.setString(2, user.getUsername());
				ps.execute();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		// ----------------------------------------------------------------------------------------
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		// -------------------------------------Manager DAO----------------------------------------------
		private User extractManager(ResultSet rs) throws SQLException {
			User extracted = new User();

			extracted.setUser_id(rs.getInt("users_id"));
			extracted.setUsername(rs.getString("username"));
			extracted.setPassword(rs.getString("psswrd"));
			extracted.setFirstName(rs.getString("user_first_name"));
			extracted.setLastName(rs.getString("user_last_name"));
			extracted.setRole(rs.getInt("user_role_id"));

			return extracted;
		}

		public User managerLogin(String username) {
			try (Connection conn = ConnectionUtil.getConnection()) {
				User user = null;
				String query = "SELECT * FROM users  WHERE username = ?;";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				rs.next();
				user = extractManager(rs);
				System.out.println(user);
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public User createManager(User user) {
			try(Connection conn = ConnectionUtil.getConnection()){
				String query = "INSERT INTO users (username,psswrd,user_first_name,user_last_name,user_email,user_role_id) VALUES (?,?,?,?,?,?) RETURNING username;";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFirstName());
				ps.setString(4, user.getLastName());
				ps.setInt(5,2);
				
				ResultSet rs = ps.executeQuery();
				rs.next();
				user.setUser_id(rs.getInt("users_id"));
				System.out.println("Your request has been sent!");
				return user;
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

		// ----------------------------------------------------------------------------------------------
		
}
