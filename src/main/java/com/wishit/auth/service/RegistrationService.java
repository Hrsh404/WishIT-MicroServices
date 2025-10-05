package com.wishit.auth.service;


import org.springframework.stereotype.Service;

import com.wishit.auth.entity.Registration;
import com.wishit.auth.repository.RegistrationRepo;


@Service
public class RegistrationService {

	 private final RegistrationRepo repository;

	    public RegistrationService(RegistrationRepo repository) {
	        this.repository = repository;
	    }

	    public Registration registerUser(Registration user) {
	      
	    	if (repository.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent()) {
	    	    throw new RuntimeException("Email already in use");
	    	    
	    	}

	        return repository.save(user);
	    }
	}
