package com.marvinsilva.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvinsilva.workshop.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	public User update(User obj) {	//obj inserido pelo user para update
		User newObj = findById(obj.getId());	//procurando obj que será att
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public void delete(String id) {
		findById(id);	//if id not exist return exception
		repository.deleteById(id);
	}
}
