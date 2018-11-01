package com.revature.daos.interfaces;

import com.revature.models.User;

public interface UserDao {
	/**
	 * Retrieves a user instance from a 
	 * provided username, or null if
	 * no user with the provided username.
	 * @param username
	 * @return - user or null if not found
	 */
	User getUserByUsername(String username);
}
