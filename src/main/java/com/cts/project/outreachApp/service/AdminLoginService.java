package com.cts.project.outreachApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.project.outreachApp.model.Admin;
import com.cts.project.outreachApp.repository.AdminRepository;

@Component
public class AdminLoginService {

	@Autowired
	AdminRepository adminRepository;

	public boolean validateUser(String username, String password) {
		try {
			Admin user = adminRepository.findByUsername(username);
			Admin pass = adminRepository.findByPassword(password);
			return user.equals(pass);
		} catch (NullPointerException e) {
			return false;
		}
	}
}
