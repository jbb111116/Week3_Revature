package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.UserDao;
import com.revature.models.ReimbursementRequest;
import com.revature.models.User;

public class ManagerServices {
	// ---------------Required------------------------------------
		UserDao userDao = new UserDao();
		ReimbursementDao reimbDao = new ReimbursementDao();
		
		public List<ReimbursementRequest> getAllCompletedRequests() {
			return reimbDao.AllCompletedRequests();
		}
		
		public List<ReimbursementRequest> getAllPendingRequests() {
			return reimbDao.AllPendingRequests();
		}
		
		public List<ReimbursementRequest> getAllRequests() {
			return reimbDao.AllRequests();
		}
		
		public List<ReimbursementRequest> getPendingRequestsByUsername(String username){
			return reimbDao.UserPendingRequests(username);
		}
		
		public List<ReimbursementRequest> getProcessedRequestsByUsername(String username){
			return reimbDao.UserProcessedRequests(username);
		}
		
		public List<ReimbursementRequest> getAllRequestsByUsername(String username){
			return reimbDao.UserProcessedRequests(username);
		}
		
		public User manLogin(String username, String password) {
			User user = userDao.Login(username);
			String hashPassword = user.hashing(password);
			if(user!=null && user.getRole()==2) {
				if(hashPassword.equals(user.getPassword())){
					return user;
				}
				
			}
			return null;
		}
		
		public List<User> listOfUsers(){
			return userDao.allUsers();
		}
		
		
		//------------------------------------------------------------
		
		
		
		
		//---------------------Optional ----------------------------
		public ReimbursementRequest submitRequest(ReimbursementRequest request) {
			return reimbDao.createRequest(request);
		}
		
		public User saveManager(User user) {
			return userDao.createManager(user);
		}
		
		public User saveEmployee(User user) {
			return userDao.createEmployee(user);
		}
		
		
		public void promoteEmployee(User user) {
			if(user.getRole()==1) {
				userDao.promoteByUsername(user);
			}System.out.println("User is already a manager.");
		}
		
		public void demoteManager(User user) {
			if(user.getRole()==2) {
				userDao.demoteByUsername(user);
			}System.out.println("User is already an employee.");
		}
		//-----------------------------------------------------------
}
