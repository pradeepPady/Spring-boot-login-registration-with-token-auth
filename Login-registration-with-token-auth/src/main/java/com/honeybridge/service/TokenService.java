package com.honeybridge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import com.honeybridge.model.User;
import com.honeybridge.repositery.UserRepositery;

@Service
public class TokenService {

	@Autowired
	UserRepositery repositery;
	
	public User isUserAuthenticated(String token) {
		String decodedAuth = "";
        
        String[] auths = token.split("\\s+");
        String authInfo = auths[1];
        Base64 base64 = new Base64();
        byte[] bytes = null;
        bytes = base64.decode(authInfo.getBytes());
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
        String authInfos[]=decodedAuth.split(":");
        String username=authInfos[0];
        String password=authInfos[1];
        User authUser=authentication(username, password);
        return authUser;
	}

	public User authentication(String username, String password) {
		User user=repositery.findByUsername(username);
		if(user!=null) {
			return user;
		}
		return null;
		
	}

	public void saveUser(User user) {
		repositery.save(user);
	}

}
