package com.cts.project.outreachApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.outreachApp.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	Optional<Event> findById(Long id);

	Event findByActivity(String activity);
	
	Event findByPlace(String place);
}
