package com.vander.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vander.workshopmongo.domain.User;
import com.vander.workshopmongo.dto.UserDto;
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
	
	public User insertUser(User obj) {
		return rep.insert(obj);
	}
	
	public void deleteUser(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public User update(User user) {
		User newObj = findById(user.getId());
		newObj = updateData(newObj, user);
		
		return rep.save(newObj);
	}
	
	public User updateData(User newObj, User user) {
		newObj.setEmail(user.getEmail());
		newObj.setName(user.getName());
	
		return newObj;
	}
	
	public User fromDto(UserDto userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}

}
