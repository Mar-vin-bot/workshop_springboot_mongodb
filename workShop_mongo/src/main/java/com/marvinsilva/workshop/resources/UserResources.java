package com.marvinsilva.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvinsilva.workshop.entities.User;

@RestController
@RequestMapping(value ="users")
public class UserResources {

	@GetMapping
	public ResponseEntity<List<User>>  findAll(){
		User obj = new User("1", "maria silva", "maria@gmail");
		User obj1 = new User("2", "daniel silva", "daniel@gmail");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(obj, obj1));
		return ResponseEntity.ok().body(list);
	}
	
	
}
