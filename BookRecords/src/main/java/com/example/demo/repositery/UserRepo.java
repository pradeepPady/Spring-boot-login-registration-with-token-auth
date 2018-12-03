package com.example.demo.repositery;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.honeybridge.model.User;
@Repository
public interface UserRepo extends MongoRepository<User, String> {
	List<User> findByEmailContains(String email);
	List<User> findByEmailContaining(String pat);
}