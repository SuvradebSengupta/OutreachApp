package com.cts.project.outreachApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.project.outreachApp.model.Event;
import com.cts.project.outreachApp.model.JoinedEvent;
import com.cts.project.outreachApp.model.Volunteer;
import com.cts.project.outreachApp.repository.EventRepository;
import com.cts.project.outreachApp.repository.JoinedEventRepository;

@Component
public class JoinedEventService {

	@Autowired
	JoinedEventRepository joinedEventRepository;

	@Autowired
	EventRepository eventRepository;

	public void addNewJoinedEvent(Volunteer volunteer, Event event, String attendance) {

		long volunteerId = volunteer.getId();
		long eventId = event.getId();
		String username = volunteer.getUsername();
		String eventName = event.getEventName();
		JoinedEvent joinedEvent = new JoinedEvent(volunteerId, eventId, username, eventName, attendance);
		joinedEventRepository.save(joinedEvent);
	}

	public List<JoinedEvent> findAllByAttendance(String attendance) {
		List<JoinedEvent> joinedEvent = joinedEventRepository.findAll();
		List<JoinedEvent> pending = new ArrayList<>();
		for (JoinedEvent event : joinedEvent) {
			if (event.getAttendance().equals(attendance)) {
				pending.add(event);
			}
		}
		return pending;
	}

	public void updateAttendance(long id, String attendance) {
		JoinedEvent joinedEvent = joinedEventRepository.findById(id).get();
		joinedEvent.setAttendance(attendance);
		joinedEventRepository.save(joinedEvent);
	}

	public List<Event> findMyEvents(long volunteerId) {
		List<Event> myEvents = new ArrayList<>();
		List<JoinedEvent> joinedEvent = joinedEventRepository.findAll();
		for (JoinedEvent event : joinedEvent) {
			if (event.getVolunteerId() == volunteerId) {
				Event myEvent = eventRepository.findById(event.getEventId()).get();
				myEvents.add(myEvent);
			}
		}
		return myEvents;
	}

	public List<Event> findMyCompletedEvents(long volunteerId) {
		List<Event> myEvents = new ArrayList<>();
		List<JoinedEvent> joinedEvent = joinedEventRepository.findAll();
		for (JoinedEvent event : joinedEvent) {
			if (event.getAttendance().equals("Accepted") && event.getVolunteerId() == volunteerId) {
				Event myEvent = eventRepository.findById(event.getEventId()).get();
				myEvents.add(myEvent);
			}
		}
		return myEvents;
	}

	public JoinedEvent findByVolunteerEvent(Volunteer volunteer, Event event) {
		List<JoinedEvent> joinedEvents = joinedEventRepository.findAll();
		for (JoinedEvent joinedEvent : joinedEvents) {
			if (joinedEvent.getVolunteerId() == volunteer.getId() && joinedEvent.getEventId() == event.getId()) {
				return joinedEvent;
			}
		}
		return null;
	}

	public void updateFeedback(long id, String feedbackOne, String feedbackTwo, String feedbackThree,
			String feedbackFour, String feedbackFive) {
		JoinedEvent joinedEvent = joinedEventRepository.findById(id).get();
		joinedEvent.setFeedbackOne(feedbackOne);
		joinedEvent.setFeedbackTwo(feedbackTwo);
		joinedEvent.setFeedbackThree(feedbackThree);
		joinedEvent.setFeedbackFour(feedbackFour);
		joinedEvent.setFeedbackFive(feedbackFive);
		joinedEventRepository.save(joinedEvent);
	}

	public Iterable<JoinedEvent> findAll() {
		return joinedEventRepository.findAll();
	}

	public List<JoinedEvent> listAll() {
		return joinedEventRepository.findAll();
	}
}
