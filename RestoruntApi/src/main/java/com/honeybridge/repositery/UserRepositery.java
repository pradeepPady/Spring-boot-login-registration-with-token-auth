package com.honeybridge.repositery;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.honeybridge.model.User;


@Repository
public interface UserRepositery extends MongoRepository<User, String> {
List<User> findByEmail(String mail);
}
