package com.wishit.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishit.auth.dto.RegistrationDTO;
import com.wishit.auth.entity.Registration;
import com.wishit.auth.service.RegistrationService;



//King Slayer Api (Do not TOUCH!!!!!!!!!!!!!)
@RestController
@RequestMapping("/wishIt/auth")
public class RegistrationController {
private final RegistrationService regisService ;

public RegistrationController(RegistrationService regService) {
	this.regisService=regService;
}


@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody RegistrationDTO regDTO) {
    try {
        Registration registeredUser = regisService.registerUser(regDTO); 
        return ResponseEntity.ok(registeredUser);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

}
