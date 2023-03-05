package com.marvinsilva.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvinsilva.workshop.entities.User;
import com.marvinsilva.workshop.repository.UserRepository;
import com.marvinsilva.workshop.services.exception.ObejectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional <User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoundException ("Objeto não encontrado"));
	}
	
}
