package com.revature.services;


import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.UserDao;
import com.revature.models.ReimbursementRequest;
import com.revature.models.User;



public class EmployeeServices {
	ReimbursementDao reimbDao = new ReimbursementDao();
	UserDao userDao = new UserDao();
	
	public ReimbursementRequest submitRequest(ReimbursementRequest request) {
		return reimbDao.createRequest(request);
	}
	
	public List<ReimbursementRequest> getPendingRequestsByUsername(String username){
		return reimbDao.UserPendingRequests(username);
	}
	
	public List<ReimbursementRequest> getProcessedRequestsByUsername(String username){
		return reimbDao.UserProcessedRequests(username);
	}
	
	public List<ReimbursementRequest> getAllRequestsByUsername(String username){
		return reimbDao.allUserRequests(username);
	}
	
	public String login(String username, String password) {
		User user = userDao.Login(username);
		String hashPassword = user.hashing(password);
		if(user!=null && user.getRole()==1) {
			if(hashPassword.equals(user.getPassword())){
				return user.getUsername();
			}
			
		}
		return "";
	}
	
	
}
