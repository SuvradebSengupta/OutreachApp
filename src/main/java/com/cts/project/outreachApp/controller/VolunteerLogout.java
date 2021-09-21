package com.cts.project.outreachApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("currentVolunteer")
public class VolunteerLogout {
	
	@RequestMapping("/volunteer-logout")
	public String adminLogout(SessionStatus status) {
		status.setComplete();
		return "redirect:/welcome";
	}
}
