package com.wishit.auth.service;

import org.springframework.stereotype.Service;

import com.wishit.auth.dto.NameDTO;
import com.wishit.auth.dto.ProfileDTO;
import com.wishit.auth.dto.RegistrationDTO;
import com.wishit.auth.entity.Registration;
import com.wishit.auth.repository.RegistrationRepo;


@Service
public class RegistrationService {

	 private final RegistrationRepo repository;
	 private final UserProfileService userProfileService;

	    public RegistrationService(RegistrationRepo repository, UserProfileService userProfileService) {
	        this.repository = repository;
	        this.userProfileService = userProfileService;
	    }

	    public Registration registerUser(RegistrationDTO regDTO) {
	      
	    	if (repository.findByEmail(regDTO.getEmail()).isPresent()) {
	    	    throw new RuntimeException("Email already in use");   
	    	}
	    	
	    	Registration newUser = new Registration();
	    	newUser.setEmail(regDTO.getEmail());
	    	NameDTO userName = regDTO.getName();
	    	newUser.setPassword(regDTO.getPassword());
	    	newUser.setName(userName.toString());
	    	
	    	ProfileDTO profileDTO = new ProfileDTO();
	    	profileDTO.setAge(regDTO.getAge());
	    	profileDTO.setCity(regDTO.getCity());
	    	profileDTO.setGender(regDTO.getGender());
	    	profileDTO.setMobileNo(regDTO.getMobileNo());
	    	profileDTO.setFirstName(userName.getFirstName());
	    	profileDTO.setMiddleName(userName.getMiddleName());
	    	profileDTO.setLastName(userName.getLastName());
	    	
	        Registration savedUser = repository.save(newUser);
	        userProfileService.addUserProfile(profileDTO, savedUser);
	        return savedUser;
	    }
	}
