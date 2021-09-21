package com.cts.project.outreachApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.outreachApp.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByUsername(String username);

	Admin findByPassword(String password);

}
