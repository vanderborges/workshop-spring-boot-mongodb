package com.vander.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vander.workshopmongo.domain.Post;
import com.vander.workshopmongo.repository.PostRepository;
import com.vander.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository rep;
	
	public List<Post> findAll() {
		return rep.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Obj não encontrado"));
	}
	
}
