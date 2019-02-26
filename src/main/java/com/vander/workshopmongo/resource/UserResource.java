package com.vander.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vander.workshopmongo.domain.User;
import com.vander.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method = RequestMethod.GET,  value = "/findAll")
	public ResponseEntity<List<User>> findAll() {
		List<User> listUsers = service.findAll();
		
		return  new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
	}

}
