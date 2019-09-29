package com.ankit.reader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.reader.model.User;
import com.ankit.reader.payload.ApiResponse;
import com.ankit.reader.payload.LoginPayload;
import com.ankit.reader.payload.LoginResponse;
import com.ankit.reader.payload.RegistrationPayload;
import com.ankit.reader.repository.RoleRepository;
import com.ankit.reader.repository.UserRepository;
import com.ankit.reader.security.JwtTokenProvider;
import com.ankit.reader.security.UserPrincipal;
import com.ankit.reader.service.RegistrationService;




@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
	
	@GetMapping("hello/testing")
	public ResponseEntity<Object> hello() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("registration")
	public ResponseEntity<ApiResponse> registration(@RequestBody RegistrationPayload registrationPayload){
		try {
			
			registrationService.registration(registrationPayload);
		} catch (Exception e) {
			
			return new ResponseEntity<>(new ApiResponse(e.getMessage(), false),HttpStatus.UNAUTHORIZED);
			
		}
		return new ResponseEntity<>(new ApiResponse("registration is done", true),HttpStatus.OK);
	}
	
	@PostMapping("login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginPayload loginPayload){
		
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		loginPayload.getEmail(),
                		loginPayload.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        String jwt = tokenProvider.generateToken(userPrincipal.getId());
        return ResponseEntity.ok(new LoginResponse(jwt,true));
	}
	
	@GetMapping("/get/{email}")
	public ResponseEntity<User> get(@PathVariable String email ){
		//System.out.println(userNameOrEmail);
		User user = userRepository.findByEmail(email).get();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
