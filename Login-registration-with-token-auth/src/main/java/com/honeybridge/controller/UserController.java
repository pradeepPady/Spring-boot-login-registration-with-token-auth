package com.honeybridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honeybridge.model.User;
import com.honeybridge.service.TokenService;

@RestController
public class UserController {

	@Autowired
	public TokenService tokenService;
	@RequestMapping("/login")
	public String login(@RequestParam String username ,@RequestParam String password) {
		User auth=tokenService.authentication(username,password);
		if(auth!=null) {
			String authString=username+":"+password;
			Base64 base64=new Base64();
			byte[] authStringEncrptd=base64.encode(authString.getBytes());
			String authEncrypt=new String(authStringEncrptd);
			return authEncrypt;
		}
		return "validation failed........";
		
	}
	@RequestMapping("/get-user")
	public ResponseEntity<User> getUser(@RequestHeader(value="authorization")String token) {
		User user=tokenService.isUserAuthenticated(token);
		if((user)!=null) {
			return new ResponseEntity<User>(user, HttpStatus.FOUND);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String registration(@RequestBody User user) {
		tokenService.saveUser(user);
		return "User account is created sucsessfully.....";
		
	}
	@RequestMapping("/encode")
	public String test(){
		String username="pad";
		String password="pad123";
		String authString=username+":"+password;
		Base64 base64=new Base64();
		byte[] authStringEncrptd=base64.encode(authString.getBytes());
		String authEncrypt=new String(authStringEncrptd);
		return authEncrypt;
		
	}
	@RequestMapping("/decode")
	public String test1() {
		String username="pad";
		String password="pad123";
		String authString=username+":"+password;
		Base64 base64=new Base64();
		byte[] authStringEncrptd=base64.encode(authString.getBytes());
		String authEncrypt=new String(authStringEncrptd);
		byte[] bytes = null;
        bytes = base64.decode(authEncrypt.getBytes());
        String decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
        String authInfos[]=decodedAuth.split(":");
        String username1=authInfos[0];
        String password1=authInfos[1];
		return username1+" "+password1;
		
	}
}
