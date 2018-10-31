package com.honeybridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honeybridge.models.Restorants;
import com.honeybridge.srvice.RestorantService;

@RestController
public class RestoruntController {
	@Autowired
	RestorantService restorantService;
	
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

}
