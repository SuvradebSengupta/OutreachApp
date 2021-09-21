package com.cts.project.outreachApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.outreachApp.model.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long>  {

}
