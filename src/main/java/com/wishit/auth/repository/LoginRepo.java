package com.wishit.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wishit.auth.entity.Login;
import com.wishit.auth.entity.Registration;

public interface LoginRepo extends JpaRepository<Login,Long>{
	
	 Optional<Login> findByEmail(String email);
}
