package com.cts.project.outreachApp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.outreachApp.model.Event;
import com.cts.project.outreachApp.model.JoinedEvent;
import com.cts.project.outreachApp.repository.EventRepository;
import com.cts.project.outreachApp.service.EventService;
import com.cts.project.outreachApp.service.JoinedEventService;

@Controller
@SessionAttributes("username")
public class AdminEventController {

	@Autowired
	EventService eventService;

	@Autowired
	EventRepository eventRepo;
	
	@Autowired
	JoinedEventService joinedEventService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/create-event", method = RequestMethod.GET)
	public String showEventCreationPage(ModelMap model) {
		if (model.containsAttribute("username")) {
			model.addAttribute("event", new Event("", "", "", "", new Date(), "", 0, "", ""));
			return "create-event";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/create-event", method = RequestMethod.POST)
	public String eventCreationPage(ModelMap model, @Valid Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "/create-event";
		}
		eventService.addNewEvent(event.getActivity(), event.getEventName(), event.getDescription(), event.getPlace(),
				event.getDate(), event.getContactNumber(), event.getNoOfVolunteers(), event.getDos(), event.getDonts());
		return "admin-home";
	}

	@RequestMapping(value = "/admin-view-event", method = RequestMethod.GET)
	public String index3(HttpServletRequest request, ModelMap modelMap) {

		if (modelMap.containsAttribute("username")) {
			List<Event> event = (List<Event>) eventService.findAll();
			Date currentDate = new Date();
			Date previousDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate() - 1);
			List<Event> events = new ArrayList<>();
			for (Event upcoming : event) {
				if (upcoming.getDate().after(previousDate)) {
					events.add(upcoming);
				}
			}
			PagedListHolder<Event> pagedListHolder = new PagedListHolder<Event>(events);
			pagedListHolder.setPageSize(2);
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			pagedListHolder.setPage(page);
			modelMap.put("pagedListHolder", pagedListHolder);
			return "admin-view-event";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/admin-event-info", method = RequestMethod.GET)
	public String showEventPage(@RequestParam long id, ModelMap model) {
		Event event = eventRepo.findById(id).get();
		model.put("event", event);
		return "admin-event-info";
	}

	@RequestMapping(value = "/volunteer-donation-info", method = RequestMethod.GET)
	public String index1(HttpServletRequest request, ModelMap model) {

		if (model.containsAttribute("username")) {
			List<Event> events = (List<Event>) eventService.findAll();
			PagedListHolder<Event> pagedListHolder = new PagedListHolder<Event>(events);
			pagedListHolder.setPageSize(2);
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			pagedListHolder.setPage(page);
			model.put("pagedListHolder", pagedListHolder);
			return "volunteer-donation-info";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/transfer-donation", method = RequestMethod.GET)
	public String showDonationPage(@RequestParam long id, ModelMap model) {
		if (model.containsAttribute("username")) {
			model.addAttribute("event", new Event("", "", "", "", new Date(), "", 0, "", ""));
			return "transaction";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/transfer-donation", method = RequestMethod.POST)
	public String TransactionPage(@RequestParam long id, int donation) {
		eventService.updateDonation(id, donation);
		return "redirect:/admin-home";
	}

	@RequestMapping(value = "/admin-donate-event", method = RequestMethod.GET)
	public String showTransactionPage(@RequestParam long id, ModelMap model) {
		if (model.containsAttribute("username")) {
			model.addAttribute("event", new Event("", "", "", "", new Date(), "", 0, "", ""));
			return "transaction";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/admin-donate-event", method = RequestMethod.POST)
	public String donatePage(@RequestParam long id, int donation) {
		eventService.updateEvent(id, donation);
		return "redirect:/admin-home";
	}

	@RequestMapping(value = "/view-feedback", method = RequestMethod.GET)
	public String index7(HttpServletRequest request, ModelMap modelMap) {

		if (modelMap.containsAttribute("username")) {
			List<JoinedEvent> events = (List<JoinedEvent>) joinedEventService.findAll();
			PagedListHolder<JoinedEvent> pagedListHolder = new PagedListHolder<JoinedEvent>(events);
			pagedListHolder.setPageSize(2);
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			pagedListHolder.setPage(page);
			modelMap.put("pagedListHolder", pagedListHolder);
			return "view-feedback";
		}
		return "redirect:/admin-login";
	}

}
