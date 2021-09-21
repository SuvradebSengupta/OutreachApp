package com.cts.project.outreachApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.project.outreachApp.model.Volunteer;
import com.cts.project.outreachApp.repository.VolunteerRepository;

@Component
public class VolunteerLoginService {

	@Autowired
	VolunteerRepository volunteerRepository;

	public Volunteer validateUser(String username, String password) {
		try {
			Volunteer user = volunteerRepository.findByUsername(username);
			if (user.getPassword().equals(password)) {
				return user;
			}
		} catch (NullPointerException e) {
			return null;
		}
		return null;
	}
}
