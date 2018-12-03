package com.honeybridge.repositery;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.honeybridge.beans.FormeProfile;

@Repository
public interface FormeRepositery extends MongoRepository<FormeProfile, String>{

}
