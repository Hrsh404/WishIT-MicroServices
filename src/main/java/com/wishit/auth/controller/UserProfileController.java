package com.wishit.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishit.auth.dto.ProfileDTO;
import com.wishit.auth.service.UserProfileService;

@RestController
@RequestMapping("/user/{userId}/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService profileService;

    @GetMapping("/view")
    public ResponseEntity<?> getProfile(@PathVariable Long userId) {
        try {
            ProfileDTO profileDTO = profileService.getUserProfile(userId);
            if (profileDTO == null) {
                return ResponseEntity.status(404).body("Profile not found for userId: " + userId);
            }
            return ResponseEntity.ok(profileDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error occurred: " + e.getMessage());
        }
    }
}
