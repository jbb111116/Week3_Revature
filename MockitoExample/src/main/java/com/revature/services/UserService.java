package com.revature.services;

import com.revature.daos.interfaces.UserDao;
import com.revature.models.Credentials;
import com.revature.models.User;

import util.exceptions.BadRequestException;
import util.exceptions.NotFoundException;

public class UserService {

	private UserDao userDao;
	/**
	 * This method authenticates a user and returns a token string to be used
	 * to identify the authenticated in the future.
	 * 
	 * @param credentials
	 * @throws BadRequestException if username or password is null in credentials object
	 * @throws NotFoundException if no user is found with the given username or passwords don't match
	 * @return 
	 */
	public String authenitcate(Credentials credentials) {
		if(credentials.getUsername() == null || credentials.getPassword() == null) {
			throw new BadRequestException();
		}
		User user = userDao.getUserByUsername(credentials.getUsername());
		if(user==null) throw new NotFoundException();
		if(!user.getPassword().equals(credentials.getPassword())){
			throw new NotFoundException();
		}
		return "token";
	}
	
	public UserService(UserDao dao) {
		this.userDao = dao;
	}
	
}
