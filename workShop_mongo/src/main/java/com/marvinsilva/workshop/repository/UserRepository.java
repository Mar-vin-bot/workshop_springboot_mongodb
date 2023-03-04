package com.marvinsilva.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marvinsilva.workshop.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
