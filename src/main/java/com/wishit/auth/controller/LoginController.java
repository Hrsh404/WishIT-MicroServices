package com.wishit.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishit.auth.dto.LoginRequest;
import com.wishit.auth.dto.LoginResponse;
import com.wishit.auth.entity.Login;
import com.wishit.auth.service.LoginService;
import com.wishit.auth.service.RegistrationService;

@RestController
@RequestMapping("/wishIt/auth")
public class LoginController {
	private final LoginService logService;  

	
	public LoginController(LoginService loginService) {
		this.logService=loginService;
	}
	   @PostMapping("/login")
	 public ResponseEntity<Login> login(@RequestBody LoginRequest request) {
	        
		
	
		
		   Login logRes= logService.loginUser(request.getEmail(), request.getPassword());
		   
		   return ResponseEntity.ok(logRes);
	   }
		   
}

