package com.honeybridge.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.honeybridge.model.User;
import com.honeybridge.repositery.UserRepositery;
@Service
public class UserServiceImpl {

	@Autowired
	UserRepositery repositery;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public String create(User user) {
		System.out.println("*******"+bCryptPasswordEncoder.toString()+"******");
		User u = new User();
		u.setEmail(user.getEmail());
		u.setGender(user.getGender());
		u.setId(user.getId());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setPassword(passwordHash(user.getPassword()));
		repositery.save(u);
		mailSending();
		return "Account created";
	}

	private String passwordHash(String password) {
		return bCryptPasswordEncoder.encode(password);
	}

	public void mailSending() {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("pradeepdesai063@gmail.com");
		mail.setFrom("pradeepdesai063@gmail.com");
		mail.setSubject("Account creation sucsessfull");
		mail.setText("Hurray ! You have done that dude...");
		javaMailSender.send(mail);
	}

	public User getUser(String phonenumber) {
		return repositery.findByPhoneNumber(phonenumber);
	}

	public Optional<User> getUserById(String id) {
		return repositery.findById(id);
	}

	public User find(String email, String password) {
		return repositery.findByEmailAndPassword(email, password);
	}

}
