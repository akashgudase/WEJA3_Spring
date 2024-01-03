package com.jspiders.smswithspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.smswithspringrest.pojo.Admin;
import com.jspiders.smswithspringrest.repository.AdminRespository;

@Service
public class AdminService {

	@Autowired
	private AdminRespository adminRespository;

	public Admin addAdmin(Admin admin) {
		return adminRespository.addAdmin(admin);
	}

	public Admin getAdminByEmailAndPassword(Admin admin) {
		Admin adminToBeLoggedIn = null;
		List<Admin> admins = adminRespository.getAllAdmins();
		for (Admin a : admins) {
			if (a.getEmail().equals(admin.getEmail()) && a.getPassword().equals(admin.getPassword())) {
				adminToBeLoggedIn = a;
			}
		}
		return adminToBeLoggedIn;
	}

}
