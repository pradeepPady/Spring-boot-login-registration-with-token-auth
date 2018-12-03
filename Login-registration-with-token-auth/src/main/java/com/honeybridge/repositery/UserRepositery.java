package com.honeybridge.repositery;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.honeybridge.model.User;

@Repository
public interface UserRepositery extends MongoRepository<User, Long>{
User findByUsername(String username);
}
