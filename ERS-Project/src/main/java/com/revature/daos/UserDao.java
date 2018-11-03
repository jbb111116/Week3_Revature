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

		public List<User> employeeLogin(String username, String password) {
			try (Connection conn = ConnectionUtil.getConnection()) {
				String query = "SELECT * FROM users INNER JOIN user_roles ON user_roles.user_role_id = users.user_role_id WHERE username = ? AND psswrd = ? AND user_role_id = ?;";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setInt(3, 1);
				ResultSet rs = ps.executeQuery();
				List<User> users = new ArrayList<>();
				while(rs.next()) {
					User user = extractEmployee(rs);
					users.add(user);
				}
				return users;
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
				ps.setString(5, user.getEmail());
				ps.setInt(6,1);
				
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

			extracted.setUser_id(rs.getInt("users.id"));
			extracted.setUsername(rs.getString("username"));
			extracted.setPassword(rs.getString("psswrd"));
			extracted.setFirstName(rs.getString("first_name"));
			extracted.setLastName(rs.getString("last_name"));
			extracted.setRole(rs.getInt("user_role_id"));

			return extracted;
		}

		public List<User> managerLogin(String username, String password) {
			try (Connection conn = ConnectionUtil.getConnection()) {
				String query = "SELECT * FROM users INNER JOIN user_roles ON user_roles.user_role_id = users.user_role_id WHERE username = ? AND psswrd = ? AND user_role_id = ?;";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setInt(3, 2);
				ResultSet rs = ps.executeQuery();
				List<User> users = new ArrayList<>();
				while(rs.next()) {
					User user = extractManager(rs);
					users.add(user);
				}
				return users;
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
				ps.setString(5, user.getEmail());
				ps.setInt(6,2);
				
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
