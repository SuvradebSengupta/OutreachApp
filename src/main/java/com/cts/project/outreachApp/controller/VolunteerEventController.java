package com.cts.project.outreachApp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.outreachApp.model.Event;
import com.cts.project.outreachApp.model.JoinedEvent;
import com.cts.project.outreachApp.model.Volunteer;
import com.cts.project.outreachApp.repository.EventRepository;
import com.cts.project.outreachApp.service.EventService;
import com.cts.project.outreachApp.service.JoinedEventService;

@Controller
@SessionAttributes("currentVolunteer")
public class VolunteerEventController {

	@Autowired
	EventService eventService;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	JoinedEventService joinedEventService;

	@RequestMapping(value = "/view-event", method = RequestMethod.GET)
	public String index1(HttpServletRequest request, ModelMap modelMap) {

		if (modelMap.containsAttribute("currentVolunteer")) {
			List<Event> event = (List<Event>) eventService.findAll();
			Date currentDate = new Date();
			Date previousDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate() - 1);
			Date requiredDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate() + 16);
			List<Event> events = new ArrayList<>();
			for (Event upcoming : event) {
				if (upcoming.getDate().after(previousDate) && upcoming.getDate().before(requiredDate)) {
					events.add(upcoming);
				}
			}
			PagedListHolder<Event> pagedListHolder = new PagedListHolder<Event>(events);
			pagedListHolder.setPageSize(2);
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			pagedListHolder.setPage(page);
			modelMap.put("pagedListHolder", pagedListHolder);
			return "view-event";
		}
		return "redirect:/volunteer-login";
	}

	@RequestMapping(value = "/invite", method = RequestMethod.GET)
	public String showInvitationPage(ModelMap modelMap) {
		if (modelMap.containsAttribute("currentVolunteer")) {
			return "invite";
		}
		return "redirect:/volunteer-login";
	}

	@RequestMapping(value = "/join-event", method = RequestMethod.GET)
	public String showEventPage(@RequestParam long id, ModelMap model) {
		Event event = eventRepository.findById(id).get();
		Volunteer volunteer = (Volunteer) model.get("currentVolunteer");
		joinedEventService.addNewJoinedEvent(volunteer, event, "Pending");
		model.put("event", event);
		return "event-info";
	}

	@RequestMapping(value = "/volunteer-myevent", method = RequestMethod.GET)
	public String index4(HttpServletRequest request, ModelMap modelMap) {
		Volunteer volunteer = (Volunteer) modelMap.get("currentVolunteer");
		List<Event> events = (List<Event>) joinedEventService.findMyEvents(volunteer.getId());
		PagedListHolder<Event> pagedListHolder = new PagedListHolder<Event>(events);
		pagedListHolder.setPageSize(2);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "volunteer-myevent";
	}

	@RequestMapping(value = "/donate-event", method = RequestMethod.GET)
	public String showDonationPage(@RequestParam long id, ModelMap model) {
		if (model.containsAttribute("currentVolunteer")) {
			model.addAttribute("event", new Event("", "", "", "", new Date(), "", 0, "", ""));
			return "transaction";
		}
		return "redirect:/volunteer-login";
	}

	@RequestMapping(value = "/donate-event", method = RequestMethod.POST)
	public String TransactionPage(@RequestParam long id, int donation) {
		eventService.updateEvent(id, donation);
		return "redirect:/volunteer-home";
	}

	@RequestMapping(value = "/view-completed-event", method = RequestMethod.GET)
	public String index6(HttpServletRequest request, ModelMap modelMap) {
		Volunteer volunteer = (Volunteer) modelMap.get("currentVolunteer");
		List<Event> events = (List<Event>) joinedEventService.findMyCompletedEvents(volunteer.getId());
		PagedListHolder<Event> pagedListHolder = new PagedListHolder<Event>(events);
		pagedListHolder.setPageSize(2);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "view-completed-event";
	}

	@RequestMapping(value = "/feedback-form", method = RequestMethod.GET)
	public String showFeedbackPage(@RequestParam long id, ModelMap model) {
		if (model.containsAttribute("currentVolunteer")) {
			return "feedback-form";
		}
		return "redirect:/volunteer-login";
	}

	@RequestMapping(value = "/feedback-form", method = RequestMethod.POST)
	public String feedbackFormPage(ModelMap map, @RequestParam long id, @RequestParam String ans1,
			@RequestParam String ans2, @RequestParam String ans3, @RequestParam String ans4,
			@RequestParam String ans5) {
		Event event = eventRepository.findById(id).get();
		Volunteer currentVolunteer = (Volunteer) map.get("currentVolunteer");
		JoinedEvent joinedEvent = joinedEventService.findByVolunteerEvent(currentVolunteer, event);
		joinedEventService.updateFeedback(joinedEvent.getId(), ans1, ans2, ans3, ans4, ans5);
		return "volunteer-home";
	}
}
