package com.cts.project.outreachApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suggestion")
public class Suggestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "volunteer_id")
	private long volunteerId;

	@Column(name = "event_details")
	private String eventDetails;

	@Column(name = "target_group")
	private String targetGroup;

	@Column(name = "volunteers_required")
	private long volunteersRequired;

	@Column(name = "approx_cost")
	private long approxCost;

	@Column(name = "status")
	private String status;

	protected Suggestion() {

	}

	public Suggestion(long volunteerId, String eventDetails, String targetGroup, long volunteersRequired,
			long approxCost, String status) {
		this.volunteerId = volunteerId;
		this.eventDetails = eventDetails;
		this.targetGroup = targetGroup;
		this.volunteersRequired = volunteersRequired;
		this.approxCost = approxCost;
		this.status = status;
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

	public String getEventDetails() {
		return eventDetails;
	}

	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}

	public String getTargetGroup() {
		return targetGroup;
	}

	public void setTargetGroup(String targetGroup) {
		this.targetGroup = targetGroup;
	}

	public long getVolunteersRequired() {
		return volunteersRequired;
	}

	public void setVolunteersRequired(long volunteersRequired) {
		this.volunteersRequired = volunteersRequired;
	}

	public long getApproxCost() {
		return approxCost;
	}

	public void setApproxCost(long approxCost) {
		this.approxCost = approxCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
