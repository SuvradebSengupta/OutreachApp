package com.cts.project.outreachApp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.project.outreachApp.model.Event;
import com.cts.project.outreachApp.repository.EventRepository;

@Component
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	

	public void addNewEvent(String activity, String eventName, String description, String place, Date date,
			String contactNumber, int noOfVolunteers, String dos, String donts) {

		Event event = new Event(activity, eventName, description, place, date, contactNumber, noOfVolunteers, dos,
				donts);
		eventRepository.save(event);
	}

	public void updateEvent(long id, int donation) {
		Event event = eventRepository.findById(id).get();
		donation += event.getDonation();
		event.setDonation(donation);
		eventRepository.save(event);
	}

	public void updateDonation(long id, int donation) {
		Event event = eventRepository.findById(id).get();
		if(donation<event.getDonation())
		{
			donation = event.getDonation() - donation;
			event.setDonation(donation);
			eventRepository.save(event);
		}
		else
		{
			donation=0;
			event.setDonation(donation);
			eventRepository.save(event);
		}
	}

	public Iterable<Event> findAll() {
		return eventRepository.findAll();
	}

}
