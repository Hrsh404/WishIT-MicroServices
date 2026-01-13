package com.wishit.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wishit.auth.dto.VendorRequest;
import com.wishit.auth.entity.VendorRegistration;
import com.wishit.auth.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {


	@Autowired
	private VendorService vendorService;

//	private final VendorService vendorService;
//	public VendorController(VendorService vendorService) {
//
//this.vendorService=vendorService;
//	}


	@PostMapping("/register")
	public ResponseEntity<?> registerVendor(@RequestParam String userUuid, @RequestBody VendorRequest request){

		VendorRegistration vendor= vendorService.createVendor(userUuid, request);

		return ResponseEntity.ok(Map.of("vendorUuid", vendor.getVendorUuid() + "Verified"
				));

	}

}
