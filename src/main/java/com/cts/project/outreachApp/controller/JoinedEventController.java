package com.cts.project.outreachApp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.outreachApp.model.JoinedEvent;
import com.cts.project.outreachApp.model.JoinedEventExporter;
import com.cts.project.outreachApp.service.JoinedEventService;

@Controller
@SessionAttributes("username")
public class JoinedEventController {

	@Autowired
	JoinedEventService joinedEventService;

	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public String index1(HttpServletRequest request, ModelMap modelMap) {
		if (modelMap.containsAttribute("username")) {
			List<JoinedEvent> joinedevent = (List<JoinedEvent>) joinedEventService.findAllByAttendance("Pending");
			PagedListHolder<JoinedEvent> pagedListHolder = new PagedListHolder<JoinedEvent>(joinedevent);
			pagedListHolder.setPageSize(2);
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			pagedListHolder.setPage(page);
			modelMap.put("pagedListHolder", pagedListHolder);
			return "attendance";
		}
		return "redirect:/admin-login";
	}

	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	public String acceptAttendance(@RequestParam long id) {

		joinedEventService.updateAttendance(id, "Accepted");
		return "redirect:/attendance";
	}

	@RequestMapping(value = "/decline", method = RequestMethod.GET)
	public String declineAttendance(@RequestParam long id) {

		joinedEventService.updateAttendance(id, "Declined");
		return "redirect:/attendance";
	}

	@GetMapping("/users/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<JoinedEvent> listReport = joinedEventService.listAll();

		JoinedEventExporter excelExporter = new JoinedEventExporter(listReport);

		excelExporter.export(response);
	}
}
