package com.wishit.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wishit.auth.dto.VendorSyncRequest;
@Service
public class ProductServiceClient {
	 private final RestTemplate restTemplate;
	 public ProductServiceClient(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	 public void sendVendorToProduct(VendorSyncRequest request) {

	        String url = "http://localhost:8082/api/product/vendor";
	        ResponseEntity<Void> response =
	                restTemplate.postForEntity(url, request, Void.class);



	        if (!response.getStatusCode().is2xxSuccessful()) {
	            throw new RuntimeException(
	                "Failed to send vendor to Product MS. Status: "
	                + response.getStatusCode()
	            );
	    }

	        else {
	        ResponseEntity.ok("Data Sent Successfully");
	        System.out.print("Success!!!!!");
	        }
}
}
