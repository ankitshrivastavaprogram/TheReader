package com.ankit.reader.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ankit.reader.exception.InvalidEmailException;
import com.ankit.reader.model.Role;
import com.ankit.reader.model.User;
import com.ankit.reader.payload.RegistrationPayload;
import com.ankit.reader.repository.RoleRepository;
import com.ankit.reader.repository.UserRepository;


@Service
public class RegistrationService {
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public void registration(RegistrationPayload registrationPayload) throws Exception {
		
		
		String email = registrationPayload.getEmail();
		String firstName = registrationPayload.getFirstName();
		String lastName = registrationPayload.getLastName();
		String password = registrationPayload.getPassword();		
		
		if(userRepository.existsByEmail(email)) {
			throw new InvalidEmailException();
		}
		
		
		//creating user from RegisterPayload
		
		User user = new User(firstName, lastName,email, password);
		
		
		
		//creating roles add user as default role to all kind of user
		List<Role> roles = new ArrayList<Role>();
		Role defaultRole = roleRepository.findByRoleName("ROLE_USER").get();
		roles.add(defaultRole);
		Set<Role> roles_set = roles.stream().collect(Collectors.toSet());
		
		//setting roles and address to user object
		user.setRoles(roles_set);
		
		
		//encrip passwored befor saving
		user.setPassword(passwordEncoder.encode(password));
		
		//save user
		userRepository.save(user);
		
		
		
	}

}
