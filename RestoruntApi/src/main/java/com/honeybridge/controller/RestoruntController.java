package com.honeybridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honeybridge.model.User;
import com.honeybridge.models.Restorants;
import com.honeybridge.repositery.ResturantRepository;
import com.honeybridge.repositery.UserRepositery;
import com.honeybridge.srvice.RestorantService;

@RestController
public class RestoruntController {
	@Autowired
	RestorantService restorantService;
	@Autowired
	UserRepositery userrepositery;
	@Autowired
	ResturantRepository repositery;
	
	@RequestMapping("/restarunts")
	public List<Restorants> getAll(){
		return restorantService.getAll();
		
	}
	@RequestMapping("/restarunts/{ratings}")
	public List<Restorants>getByRatings(@PathVariable("ratings")@RequestParam String rating){
		return restorantService.getByreating(rating);
	}
	@RequestMapping("/restarunts/tofood/{typeOfFood}")
	public List<Restorants>getBytypeoffood(@PathVariable("typeOfFood") String typeOfFood){
		return restorantService.gettypeOffood(typeOfFood);
				
	}
	@RequestMapping("/restarunts/users")
	public List<User> getAllUsers(){
		return userrepositery.findAll();
	}
	@RequestMapping("/restarunts/sorting")
	public ResponseEntity<?> sorting(){
		
		Sort sort=new Sort(Direction.DESC,"rating");
		return new ResponseEntity<List<Restorants>>(repositery.findAll(sort), HttpStatus.OK);
		
	}

}
