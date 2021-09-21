package com.cts.project.outreachApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("username")
public class AdminLogout {
	
	@RequestMapping("/admin-logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/welcome";
	}
	
}
