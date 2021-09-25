package com.revature.training.service;

import java.util.Optional;

import com.revature.training.model.Admin;

public interface AdminService {
	boolean adminLogin(int adminId, String adminPassword);

	public Admin getAdminById(int adminId);
	
	public boolean isAdminExist(int adminId);
}
