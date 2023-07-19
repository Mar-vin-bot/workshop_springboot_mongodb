package com.marvinsilva.workshop.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvinsilva.workshop.entities.Post;
import com.marvinsilva.workshop.repository.PostRepository;
import com.marvinsilva.workshop.services.exception.ObejectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoundException ("Post não encontrado")); 
	}
	
	public List<Post> findByTitle (String text){
		return repository.newFindByTitle(text);
	}
	
	/*
	public List<Post> findByTitle (String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
	*/

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//+1 dia no maxDate para find all day
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(maxDate);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		maxDate = calendar.getTime();

		return repository.fullSearch(text, minDate, maxDate);
	}
	
}
	

