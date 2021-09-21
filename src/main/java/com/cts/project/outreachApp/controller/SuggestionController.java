package com.cts.project.outreachApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.outreachApp.model.Volunteer;
import com.cts.project.outreachApp.service.SuggestionService;

@Controller
@SessionAttributes("currentVolunteer")
public class SuggestionController {
	
	
	@Autowired
	SuggestionService suggestionService;
	
	@RequestMapping(value = "/volunteer-suggestion", method = RequestMethod.GET)
	public String showSuggestionForm() {
		return "volunteer-suggestion";
	}
	
	@RequestMapping(value = "/volunteer-suggestion", method = RequestMethod.POST)
	public String showVolunteerSuggestions(ModelMap model, @RequestParam String eventDetails,
			@RequestParam String targetGroup, @RequestParam long volunteersRequired, @RequestParam long approxCost) {
		Volunteer volunteer = (Volunteer) model.get("currentVolunteer"); 
		suggestionService.addNewSuggestion(volunteer.getId(),eventDetails,targetGroup,volunteersRequired,approxCost,"pending");
		return "volunteer-home";
	}
	
	
}
