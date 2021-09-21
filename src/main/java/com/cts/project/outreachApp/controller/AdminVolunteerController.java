package com.cts.project.outreachApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.cts.project.outreachApp.repository.EventRepository;
import com.cts.project.outreachApp.repository.JoinedEventRepository;
import com.cts.project.outreachApp.service.EventService;
import com.cts.project.outreachApp.service.JoinedEventService;

@Controller
@SessionAttributes("username")
public class AdminVolunteerController {

	@Autowired
	EventService eventService;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	JoinedEventService joinedEventService;

	@Autowired
	JoinedEventRepository joinedEventRepository;

	@RequestMapping(value = "/volunteer-report", method = RequestMethod.GET)
	public String searchVolunteer(ModelMap modelMap) {
		if (modelMap.containsAttribute("username")) {
			return "volunteer-report";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/volunteer-activity", method = RequestMethod.GET)
	public String searchByActivity(ModelMap modelMap) {
		if (modelMap.containsAttribute("username")) {
			return "volunteer-activity";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/volunteer-activity", method = RequestMethod.POST)
	public String index9(HttpServletRequest request, @RequestParam String activity, ModelMap modelMap) {

		if (modelMap.containsAttribute("username")) {
			Event event;
			List<JoinedEvent> joinedEvents = (List<JoinedEvent>) joinedEventService.findAll();
			List<JoinedEvent> volunteerList = new ArrayList<>();

			for (JoinedEvent events : joinedEvents) {

				event = eventRepository.findById(events.getEventId()).get();
				if(event.getActivity().equals(activity)) {
					volunteerList.add(events);
				}
			}

			PagedListHolder<JoinedEvent> pagedListHolder = new PagedListHolder<JoinedEvent>(volunteerList);
			pagedListHolder.setPageSize(2);
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			pagedListHolder.setPage(page);
			modelMap.put("pagedListHolder", pagedListHolder);
			return "volunteer-list";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/volunteer-location", method = RequestMethod.GET)
	public String searchByLocation(ModelMap modelMap) {
		if (modelMap.containsAttribute("username")) {
			return "volunteer-location";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/volunteer-location", method = RequestMethod.POST)
	public String index10(HttpServletRequest request, @RequestParam String place, ModelMap modelMap) {

		if (modelMap.containsAttribute("username")) {
			Event event;
			List<JoinedEvent> joinedEvents = (List<JoinedEvent>) joinedEventService.findAll();
			List<JoinedEvent> volunteerList = new ArrayList<>();

			for (JoinedEvent events : joinedEvents) {

				event = eventRepository.findById(events.getEventId()).get();
				if(event.getPlace().equals(place)) {
					volunteerList.add(events);
				}
			}
			PagedListHolder<JoinedEvent> pagedListHolder = new PagedListHolder<JoinedEvent>(volunteerList);
			pagedListHolder.setPageSize(2);
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			pagedListHolder.setPage(page);
			modelMap.put("pagedListHolder", pagedListHolder);
			return "volunteer-list";
		}
		return "redirect:/admin-login";
	}

}
