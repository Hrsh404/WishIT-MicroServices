package com.wishit.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wishit.auth.entity.Registration;
import com.wishit.auth.entity.VendorRegistration;

public interface VendorRepo extends JpaRepository <VendorRegistration, Long> {

	boolean existsByUser(Registration user);

	Optional<VendorRegistration> findByVendorUuid(String vendorUuid);
}
