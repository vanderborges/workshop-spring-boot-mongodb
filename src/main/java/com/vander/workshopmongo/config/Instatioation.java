package com.vander.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vander.workshopmongo.domain.Post;
import com.vander.workshopmongo.domain.User;
import com.vander.workshopmongo.dto.AuthorDto;
import com.vander.workshopmongo.dto.CommentDto;
import com.vander.workshopmongo.repository.PostRepository;
import com.vander.workshopmongo.repository.UserRepository;

@Configuration
public class Instatioation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		sdt.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
		
		userRepository.insert(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdt.parse("03/03/2019"), "Teste de Post", "Teste de Post", new AuthorDto(maria));
		Post post2 = new Post(null, sdt.parse("02/02/2018"), "Teste de Post2", "Teste de Post2", new AuthorDto(maria));
		
		CommentDto c1 = new CommentDto("comentario 1", sdt.parse("04/03/2018"), new AuthorDto(maria)); 
		CommentDto c2 = new CommentDto("comentario 2", sdt.parse("04/03/2018"), new AuthorDto(alex)); 
		CommentDto c3 = new CommentDto("comentario 3", sdt.parse("04/03/2018"), new AuthorDto(bob)); 
		CommentDto c4 = new CommentDto("comentario 4", sdt.parse("04/03/2018"), new AuthorDto(alex)); 
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3, c4));
		
		maria.getPostUser().addAll(Arrays.asList(post1, post2));
		
		postRepository.insert(Arrays.asList(post1, post2));

		userRepository.save(maria);
		
	}

}
