package com.cts.project.outreachApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "joined_event")
public class JoinedEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "volunteer_id")
	private long volunteerId;

	@Column(name = "event_id")
	private long eventId;

	@Column(name = "username")
	private String username;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "attendance")
	private String attendance;

	@Column(name = "feedback_one")
	private String feedbackOne;

	@Column(name = "feedback_two")
	private String feedbackTwo;

	@Column(name = "feedback_three")
	private String feedbackThree;

	@Column(name = "feedback_four")
	private String feedbackFour;

	@Column(name = "feedback_five")
	private String feedbackFive;

	protected JoinedEvent() {

	}

	public JoinedEvent(long volunteerId, long eventId, String username, String eventName, String attendance) {
		super();
		this.volunteerId = volunteerId;
		this.eventId = eventId;
		this.username = username;
		this.eventName = eventName;
		this.attendance = attendance;
		this.feedbackOne = "";
		this.feedbackTwo = "";
		this.feedbackThree = "";
		this.feedbackFour = "";
		this.feedbackFive = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(long volunteerId) {
		this.volunteerId = volunteerId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getFeedbackOne() {
		return feedbackOne;
	}

	public void setFeedbackOne(String feedbackOne) {
		this.feedbackOne = feedbackOne;
	}

	public String getFeedbackTwo() {
		return feedbackTwo;
	}

	public void setFeedbackTwo(String feedbackTwo) {
		this.feedbackTwo = feedbackTwo;
	}

	public String getFeedbackThree() {
		return feedbackThree;
	}

	public void setFeedbackThree(String feedbackThree) {
		this.feedbackThree = feedbackThree;
	}

	public String getFeedbackFour() {
		return feedbackFour;
	}

	public void setFeedbackFour(String feedbackFour) {
		this.feedbackFour = feedbackFour;
	}

	public String getFeedbackFive() {
		return feedbackFive;
	}

	public void setFeedbackFive(String feedbackFive) {
		this.feedbackFive = feedbackFive;
	}

	@Override
	public String toString() {
		return "JoinedEvent [id=" + id + ", volunteerId=" + volunteerId + ", eventId=" + eventId + ", username="
				+ username + ", eventName=" + eventName + ", attendance=" + attendance + ", feedbackOne=" + feedbackOne
				+ ", feedbackTwo=" + feedbackTwo + ", feedbackThree=" + feedbackThree + ", feedbackFour=" + feedbackFour
				+ ", feedbackFive=" + feedbackFive + "]";
	}

}
