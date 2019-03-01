package com.vander.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vander.workshopmongo.domain.User;
import com.vander.workshopmongo.dto.UserDto;
import com.vander.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method = RequestMethod.GET,  value = "/findAll")
	public ResponseEntity<List<UserDto>> findAll() {
		List<User> listUsers = service.findAll();
		List<UserDto> listUsersDto = listUsers.stream().map(listUser -> new UserDto(listUser)).collect(Collectors.toList());
		return  new ResponseEntity<List<UserDto>>(listUsersDto, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id) {
		User user = service.findById(id);
		return new ResponseEntity<UserDto>(new UserDto(user), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertUser(@RequestBody UserDto userDto) {
		User user = service.fromDto(userDto);
		user = service.insertUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	

}
