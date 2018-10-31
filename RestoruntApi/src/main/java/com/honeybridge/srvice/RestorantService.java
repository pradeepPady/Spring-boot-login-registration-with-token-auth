package com.honeybridge.srvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybridge.models.Restorants;
import com.honeybridge.repositery.ResturantRepository;
@Service
public class RestorantService {
    @Autowired
    ResturantRepository repository;
    
	public List<Restorants> getAll() {
	
		return repository.findAll();
	}

	public List<Restorants> getByreating(String rating) {
		return repository.findByRating(rating);
	}

	public List<Restorants> gettypeOffood(String type) {
		return repository.findByTypeOfFood(type);
	}

}
