package com.vander.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vander.workshopmongo.domain.User;
import com.vander.workshopmongo.repository.UserRepository;
import com.vander.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;
	
	public List<User> findAll() {
		return rep.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Obj não encontrado"));
	}

}
