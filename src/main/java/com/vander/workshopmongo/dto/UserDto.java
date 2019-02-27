package com.vander.workshopmongo.dto;

import java.io.Serializable;

import com.vander.workshopmongo.domain.User;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 4246873283858566611L;

	private String id;
	private String name;
	private String email;
	
	public UserDto() {
		
	}
	
	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
