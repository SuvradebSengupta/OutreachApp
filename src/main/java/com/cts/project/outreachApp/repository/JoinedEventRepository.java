package com.cts.project.outreachApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.outreachApp.model.JoinedEvent;

public interface JoinedEventRepository extends JpaRepository<JoinedEvent, Long> {

	JoinedEvent findByAttendance(String attendance);

	JoinedEvent findByEventId(Long eventId);
}
