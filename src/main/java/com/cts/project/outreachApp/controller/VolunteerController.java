package com.cts.project.outreachApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.outreachApp.model.Volunteer;
import com.cts.project.outreachApp.service.VolunteerLoginService;
import com.cts.project.outreachApp.service.VolunteerRegistrationService;

@Controller
@SessionAttributes("currentVolunteer")
public class VolunteerController {

	@Autowired
	VolunteerLoginService volunteerLogin;

	@Autowired
	VolunteerRegistrationService volunteerRegistration;

	@RequestMapping(value = "/volunteer-login", method = RequestMethod.GET)
	public String showVolunteerLoginPage() {
		return "volunteer-login";
	}

	@RequestMapping(value = "/volunteer-login", method = RequestMethod.POST)
	public String showVolunteerWelcomePage(ModelMap model, @RequestParam String username,
			@RequestParam String password) {
		Volunteer currentVolunteer = volunteerLogin.validateUser(username, password);
		if (currentVolunteer == null) {
			model.put("errorMessage", "Invalid Credentials. Please try again!");
			return "volunteer-login";
		}
		model.addAttribute("currentVolunteer", currentVolunteer);
		model.put("username", username);
		model.put("password", password);
		return "volunteer-home";
	}

	@RequestMapping(value = "/volunteer-register", method = RequestMethod.GET)
	public String showVolunteerRegistrationPage() {
		return "volunteer-register";
	}

	@RequestMapping(value = "/volunteer-register", method = RequestMethod.POST)
	public String volunteerRegistrationPage(ModelMap model, @RequestParam String firstname,
			@RequestParam String lastname, @RequestParam int age, @RequestParam String gender,
			@RequestParam String contactnumber, @RequestParam String password) {
		Volunteer currentVolunteer = volunteerRegistration.addNewVolunteer(firstname, lastname, age, gender,
				contactnumber, password);
		model.addAttribute("currentVolunteer", currentVolunteer);
		model.addAttribute("firstname", currentVolunteer.getFirstName());
		model.addAttribute("lastname", currentVolunteer.getLastName());
		model.addAttribute("username", currentVolunteer.getUsername());
		return "volunteer-info";
	}

	@RequestMapping(value = "/volunteer-home", method = RequestMethod.GET)
	public String showVolunteerHomePage(ModelMap model) {
		if (model.containsAttribute("currentVolunteer")) {
			return "volunteer-home";
		}
		return "redirect:/volunteer-login";
	}

}
