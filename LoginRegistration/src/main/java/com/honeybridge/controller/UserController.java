package com.honeybridge.controller;

import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honeybridge.model.User;
import com.honeybridge.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl serviceImpl;
	@RequestMapping("/")
	public String msg() {
		return "Wellcome";
	}
	@RequestMapping(value="/sign-up",method=RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		String msg=serviceImpl.create(user);
		return msg;
		
	}
	
	@GetMapping("/sign-in")
	public User signIn(@RequestParam String phonenumber) {
		return serviceImpl.getUser(phonenumber);	
	}
	@GetMapping("/sign-in/{id}")
	public Optional<User> signInById(@PathVariable("id") String id) {
		return serviceImpl.getUserById(id);
		
	}
	@GetMapping("/login")
	public User find(@RequestParam String email,String password) {
		return serviceImpl.find(email,password);
		
	}
}
