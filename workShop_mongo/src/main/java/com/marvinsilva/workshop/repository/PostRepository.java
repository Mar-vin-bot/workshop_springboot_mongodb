package com.marvinsilva.workshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marvinsilva.workshop.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//{ <field>: { $regex: /pattern/, $options: 'option' } }
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> newFindByTitle (String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
