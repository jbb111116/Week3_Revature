package com.revature.tests.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.revature.daos.interfaces.UserDao;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.services.UserService;

import util.exceptions.BadRequestException;
import util.exceptions.NotFoundException;

public class UserServiceTest {
	
	// Mock implementation
	UserDao mockUserDao = mock(UserDao.class);
	UserService userService = new UserService(mockUserDao);
	
	@Test(expected=BadRequestException.class)
	public void authenticateNoUsernameTest() throws Exception{
		Credentials credentials = new Credentials(null, "password");
		userService.authenitcate(credentials);
	}
	
	@Test(expected=BadRequestException.class)
	public void authenticateNoPasswordTest() throws Exception{
		Credentials credentials = new Credentials("username",null);
		userService.authenitcate(credentials);
	}
	
	@Test(expected=NotFoundException.class)
	public void authenticatNoUserWithUsername() throws Exception{
		
		/*
		 * When the userSerivice calls the getUserByUsername method on the dao
		 * with the String "NotFound" the dao will return null.
		 * This is an example of a stub method.
		 */
		when(mockUserDao.getUserByUsername("NotFound")).thenReturn(null);
		when(mockUserDao.getUserByUsername("password")).thenThrow(new RuntimeException());
		Credentials credentials = new Credentials("NotFound","password");
		userService.authenitcate(credentials);
	}
	
	@Test(expected=NotFoundException.class)
	public void authenticateIncorrectPassword() throws Exception{
		User user = new User(1, "BadPassword","abc");
		when(mockUserDao.getUserByUsername("BadPassword")).thenReturn(user);
		Credentials credentials = new Credentials("BadPassword","def");
		userService.authenitcate(credentials);
	}
	
	@Test
	public void authenticateGoodData() throws Exception {
		Credentials credentials = new Credentials("good","goodpass");
		User user = new User(1,"good","goodpass");
		when(mockUserDao.getUserByUsername("good")).thenReturn(user);
		String str = userService.authenitcate(credentials);
		assertNotNull(str);
		
	}
	
}
