package com.wishit.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wishit.auth.entity.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
	  Optional<Registration> findByEmail(String email);
}
