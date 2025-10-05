package com.wishit.auth.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wishit.auth.repository.LoginRepo;
import com.wishit.auth.repository.RegistrationRepo;
import com.wishit.auth.dto.LoginRequest;
import com.wishit.auth.dto.LoginResponse;
import com.wishit.auth.entity.Login;
import com.wishit.auth.entity.Registration;

@Service
public class LoginService {
	
	private final RegistrationRepo regisRepo;
	private final LoginRepo loginRepo; 
	
	
	public LoginService(RegistrationRepo regisRepo, LoginRepo loginRepo) { 
		
		this.regisRepo=regisRepo;
		this.loginRepo=loginRepo;
		
	}
	
	public Login loginUser(String email, String password) { 
		Registration regUser= regisRepo.findByEmailAndPassword(email, password).orElse(null);
		
		
		
		Optional<Login>  existingLogin =loginRepo.findByEmail(email);
		
		
		Login login= new Login();
		
		LocalDateTime currTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formatted = currTime.format(formatter);
		
		if (existingLogin.isPresent()) { 
			login=existingLogin.get();
			login.setLoginTime(formatted);
			
		}
		else  { 
		
		
		
		if (regUser!=null) { 
			login.setLoginFlag("L");
			login.setFullName(regUser.getName());
			login.setPassword(regUser.getPassword());
			login.setEmail(regUser.getEmail());
		
			login.setLoginTime(formatted);			
		}
		else { 
			throw new RuntimeException("Invalid email or password");
		}
	
		
		}
		
		
		
		return loginRepo.save(login);
		
		
	}
	
	
	
}
