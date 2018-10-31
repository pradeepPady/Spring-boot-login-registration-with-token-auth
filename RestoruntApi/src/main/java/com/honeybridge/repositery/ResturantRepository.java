package com.honeybridge.repositery;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.honeybridge.models.Restorants;

@Repository
public interface ResturantRepository extends MongoRepository<Restorants, String>{
	List<Restorants> findByName(String name);
	List<Restorants>findByTypeOfFood(String type);
	List<Restorants>findByRating(String rating);
}
