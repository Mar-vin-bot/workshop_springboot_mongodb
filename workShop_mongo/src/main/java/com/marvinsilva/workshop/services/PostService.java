package com.marvinsilva.workshop.services;

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
	
}
	

