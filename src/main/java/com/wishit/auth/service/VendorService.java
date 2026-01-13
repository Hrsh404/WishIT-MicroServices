package com.wishit.auth.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishit.auth.dto.VendorRequest;
import com.wishit.auth.entity.Registration;
import com.wishit.auth.entity.VendorRegistration;
import com.wishit.auth.repository.RegistrationRepo;
import com.wishit.auth.repository.VendorRepo;
@Service
public class VendorService {

	@Autowired
	private RegistrationRepo regisRepo;

	@Autowired
	private  VendorRepo vendorRepo;




	public VendorRegistration createVendor(String uuid, VendorRequest request ) {

		Registration register= regisRepo.findByUuid(uuid).orElseThrow(()-> new RuntimeException("User not found"));


		if (vendorRepo.existsByUser(register)) {
throw new RuntimeException("Vendor profile already exists");

		}


		VendorRegistration vendor= new VendorRegistration();

		vendor.setVendorUuid(UUID.randomUUID().toString());
		vendor.setUser(register);
		vendor.setStoreName(request.getStoreName());
		vendor.setBusinessEmail(request.getBusinessEmail());
		vendor.setGstNumber(request.getGstNumber());
		vendor.setPanNumber(request.getPanNumber());

		vendorRepo.save(vendor);

		register.setRole("VENDOR");
		return vendor;







	}


}
