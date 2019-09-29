package com.ankit.reader.service;

import org.springframework.stereotype.Service;

import com.ankit.reader.payload.LoginPayload;



@Service
public class LoginService {

	public void login(LoginPayload loginPayload) {
	
		String usernameOrEmail = loginPayload.getEmail();
		String password = loginPayload.getPassword();
		
	}

	
	
}
