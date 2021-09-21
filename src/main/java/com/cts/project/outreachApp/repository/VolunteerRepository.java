package com.cts.project.outreachApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.outreachApp.model.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

	Volunteer findByUsername(String username);

	Volunteer findByPassword(String password);

}