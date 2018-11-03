package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.UserDao;
import com.revature.models.ReimbursementRequest;

public class EmployeeServices {
	ReimbursementDao reimbDao = new ReimbursementDao();
	
	public ReimbursementRequest submitRequest(ReimbursementRequest request) {
		return reimbDao.createRequest(request);
	}
	
	public List<ReimbursementRequest> getPendingRequestsByUsername(String username){
		return reimbDao.UserPendingRequests(username);
	}
	
	public List<ReimbursementRequest> getProcessedRequestsByUsername(String username){
		return reimbDao.UserProcessedRequests(username);
	}
	
}
