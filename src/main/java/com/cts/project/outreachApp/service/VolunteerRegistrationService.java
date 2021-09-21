package com.cts.project.outreachApp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.project.outreachApp.model.Volunteer;
import com.cts.project.outreachApp.repository.VolunteerRepository;

@Component
public class VolunteerRegistrationService {

	@Autowired
	VolunteerRepository volunteerRepository;

	public Volunteer addNewVolunteer(String firstname, String lastname, int age, String gender, String contactnumber,
			String password) {

		Random rand = new Random();
		String username = firstname + lastname;
		while (true) {
			if (volunteerRepository.findByUsername(username) == null) {
				break;
			}
			username = firstname + lastname + rand.nextInt(100);
		}
		Volunteer volunteer = new Volunteer(firstname, lastname, username, password, gender, age, contactnumber);
		volunteerRepository.save(volunteer);
		return volunteer;
	}
}
