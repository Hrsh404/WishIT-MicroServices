package com.wishit.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishit.auth.entity.Registration;
import com.wishit.auth.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;



//King Slayer Api (Do not TOUCH!!!!!!!!!!!!!)
@Slf4j
@RestController
@RequestMapping("/wishIt/auth")
public class RegistrationController {
private final RegistrationService regisService ;

public RegistrationController(RegistrationService regService) {
	this.regisService=regService;
}


@GetMapping("/hello")
public String HelloConnection() {
	return "Hello Server";

}


@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody Registration user) {
    try {
        Registration registeredUser = regisService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

}
