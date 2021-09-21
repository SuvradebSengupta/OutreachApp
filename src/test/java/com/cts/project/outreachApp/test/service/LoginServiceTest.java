package com.cts.project.outreachApp.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.project.outreachApp.service.AdminLoginService;
import com.cts.project.outreachApp.service.VolunteerLoginService;
import com.cts.project.outreachApp.service.VolunteerRegistrationService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoginServiceTest {

	@Autowired
	AdminLoginService adminLoginService;

	@Autowired
	VolunteerLoginService volunteerLoginService;

	@Autowired
	VolunteerRegistrationService volunteerRegistrationService;

	@Test
	public void testAdminValidateUser() {
		assertTrue(adminLoginService.validateUser("admin", "admin"));
	}

	@Test
	public void testVolunteerLogin() {
		assertEquals(null,volunteerLoginService.validateUser("test", "test"));

	}


	
}
