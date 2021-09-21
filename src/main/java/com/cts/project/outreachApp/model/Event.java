package com.cts.project.outreachApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "activity")
	private String activity;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "description")
	private String description;

	@Column(name = "place")
	private String place;

	@Column(name = "event_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "no_of_volunteers")
	private int noOfVolunteers;

	@Column(name = "dos")
	private String dos;

	@Column(name = "donts")
	private String donts;

	@Column(name = "donation")
	private int donation;

	public Event(String activity, String eventName, String description, String place, Date date, String contactNumber,
			int noOfVolunteers, String dos, String donts) {
		super();
		this.activity = activity;
		this.eventName = eventName;
		this.description = description;
		this.place = place;
		this.date = date;
		this.contactNumber = contactNumber;
		this.noOfVolunteers = noOfVolunteers;
		this.dos = dos;
		this.donts = donts;
		this.donation = 0;
	}

	protected Event() {

	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDos() {
		return dos;
	}

	public void setDos(String dos) {
		this.dos = dos;
	}

	public String getDonts() {
		return donts;
	}

	public void setDonts(String donts) {
		this.donts = donts;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getNoOfVolunteers() {
		return noOfVolunteers;
	}

	public void setNoOfVolunteers(int noOfVolunteers) {
		this.noOfVolunteers = noOfVolunteers;
	}

	public int getDonation() {
		return donation;
	}

	public void setDonation(int donation) {
		this.donation = donation;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", activity=" + activity + ", eventName=" + eventName + ", description="
				+ description + ", place=" + place + ", date=" + date + ", contactNumber=" + contactNumber
				+ ", noOfVolunteers=" + noOfVolunteers + ", dos=" + dos + ", donts=" + donts + ", donation=" + donation
				+ "]";
	}

}
