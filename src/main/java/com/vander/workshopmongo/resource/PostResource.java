package com.vander.workshopmongo.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vander.workshopmongo.domain.Post;
import com.vander.workshopmongo.resource.util.Url;
import com.vander.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	PostService service;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findtitle" )
	public ResponseEntity<List<Post>> findTitle (@RequestParam(value = "text", defaultValue = "") String text) {
		List<Post> posts = service.findByTitle(Url.urlDeconding(text));
		return ResponseEntity.ok().body(posts);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchTitle")
	public ResponseEntity<List<Post>> searchTitle (@RequestParam(value = "text", defaultValue = "")String text) {
		text = Url.urlDeconding(text);
		List<Post> posts = service.searchTitle(text);
		return ResponseEntity.ok().body(posts);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchfull")
	public ResponseEntity<List<Post>> searchFull(
			@RequestParam(value = "text", defaultValue = "")String text, 
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		
		Date miDate = Url.convertDate(minDate, new Date(0l));
		Date maDate = Url.convertDate(maxDate, new Date());
		
		List<Post> posts = service.searchFull(text, miDate, maDate);
		
		return ResponseEntity.ok().body(posts);
	}
	
}
