package com.cts.project.outreachApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.outreachApp.service.AdminLoginService;
import com.cts.project.outreachApp.service.EventService;

@Controller
@SessionAttributes("username")
public class AdminController {

	@Autowired
	AdminLoginService adminLogin;
	
	@Autowired
	EventService eventService;

	@RequestMapping(value = "/admin-login", method = RequestMethod.GET)
	public String showAdminLoginPage() {
		return "admin-login";
	}

	@RequestMapping(value = "/admin-login", method = RequestMethod.POST)
	public String showAdminWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password) {
		boolean isValidUser = adminLogin.validateUser(username, password);
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials. Please try again!");
			return "admin-login";
		}
		model.put("username", username);
		model.put("password", password);
		return "admin-home";
	}
	
	@RequestMapping(value = "/admin-home", method = RequestMethod.GET)
	public String showAdminHomePage(ModelMap model) {
		if(model.containsAttribute("username")) {
		return "admin-home";
		}
		return "redirect:/admin-login";
	}
	


}
