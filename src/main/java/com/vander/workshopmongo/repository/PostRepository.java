package com.vander.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vander.workshopmongo.domain.Post;
import java.lang.String;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String title);
}
