package com.vander.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vander.workshopmongo.domain.Post;
import com.vander.workshopmongo.domain.User;
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
		
		Post post1 = new Post(null, sdt.parse("03/03/2019"), "Teste de Post", "Teste de Post", maria);
		Post post2 = new Post(null, sdt.parse("02/02/2018"), "Teste de Post2", "Teste de Post2", maria);
		
		userRepository.insert(Arrays.asList(maria, alex, bob));
		postRepository.insert(Arrays.asList(post1, post2));
		
	}

}
