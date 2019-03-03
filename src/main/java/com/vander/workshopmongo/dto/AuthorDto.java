package com.vander.workshopmongo.dto;

import com.vander.workshopmongo.domain.User;

public class AuthorDto {
	private String id;
	private String Name;
	
	public AuthorDto() {
		
	}
	
	public AuthorDto(User obj) {
		this.id = obj.getId();
		this.Name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
