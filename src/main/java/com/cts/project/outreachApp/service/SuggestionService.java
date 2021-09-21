package com.cts.project.outreachApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.project.outreachApp.model.Suggestion;
import com.cts.project.outreachApp.repository.SuggestionRepository;

@Component
public class SuggestionService {

	@Autowired
	SuggestionRepository suggestionRepository;
	
	public Suggestion addNewSuggestion(long volunteerId, String eventDetails, String targetGroup, long volunteersRequired,
			long approxCost,String status) {
		Suggestion suggestion = new Suggestion(volunteerId, eventDetails, targetGroup, volunteersRequired, approxCost,status);
		suggestionRepository.save(suggestion);
		return suggestion;
	}
	
	public List<Suggestion> findByStatus(String status){
		List<Suggestion> suggestion = suggestionRepository.findAll();
		List<Suggestion> pending = new ArrayList<>();
		for (Suggestion suggest : suggestion) {
			if (suggest.getStatus().equals(status)) {
				pending.add(suggest);
			}
		}
		return pending; 
	}
	
	public void updateStatus(long id ,String status) {
		Suggestion suggest = suggestionRepository.findById(id).get();
		suggest.setStatus(status);
		suggestionRepository.save(suggest);
	}
}
