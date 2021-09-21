package com.cts.project.outreachApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.outreachApp.model.Suggestion;
import com.cts.project.outreachApp.service.SuggestionService;

@Controller
@SessionAttributes("username")
public class ViewSuggestionController {

	@Autowired
	SuggestionService suggestionService;
	
	@RequestMapping(value = "/view-suggestion", method = RequestMethod.GET)
	public String suggestionApproval(ModelMap modelMap) {
		List<Suggestion> suggested = (List<Suggestion>) suggestionService.findByStatus("pending");
		modelMap.put("suggested", suggested);
		return "view-suggestion";
	}
	
	@RequestMapping(value = "/approve", method = RequestMethod.GET)
	public String approveSuggesstion(@RequestParam long id) {

		suggestionService.updateStatus(id,"Approved");
		return "redirect:/view-suggestion";
	}

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public String rejectSuggestion(@RequestParam long id) {

		suggestionService.updateStatus(id,"Rejected");
		return "redirect:/view-suggestion";
	}
}
