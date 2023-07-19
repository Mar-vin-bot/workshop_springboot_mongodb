package com.marvinsilva.workshop.repository;

import java.util.List;
import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marvinsilva.workshop.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//{ <field>: { $regex: /pattern/, $options: 'option' } }
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);

	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

	
	
	// as parametros da consulta ?0, ?1, ?2 são definidas de modo que
	// os parametros da função são enumerado como arrays

}
