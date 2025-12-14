package com.wishit.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.wishit.auth.dto.ProfileDTO;
import com.wishit.auth.entity.Registration;
import com.wishit.auth.entity.UserProfile;
import com.wishit.auth.repository.RegistrationRepo;
import com.wishit.auth.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepo;
	@Autowired
	RegistrationRepo regRepo;
	
	public ProfileDTO getUserProfile(Long userId) {
		Registration user = regRepo.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		UserProfile profile = userProfileRepo.findByUser_Id(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
		

        ProfileDTO dto = new ProfileDTO();
        dto.setFirstName(profile.getFirstName());
        dto.setMiddleName(profile.getMiddleName());
        dto.setLastName(profile.getLastName());
        dto.setEmail(profile.getEmail());
        dto.setProfilePic(profile.getProfilePic());
        dto.setMobileNo(profile.getMobileNo());
        dto.setGender(profile.getGender());
        dto.setJoinedOn(user.getJoinedOn());
        dto.setAlternativeMobNo(profile.getAlternativeMobNo());
        dto.setAge(profile.getAge());
        dto.setCity(profile.getCity());
        dto.setMiddleName(profile.getMiddleName());
        
        return dto;
	}
	
	public ResponseEntity<?> addUserProfile(ProfileDTO profileDTO, Registration user) {
		UserProfile profile = new UserProfile();
		profile.setUser(user);
		profile.setEmail(user.getEmail());
		profile.setAge(profileDTO.getAge());
		profile.setCity(profileDTO.getCity());
		profile.setGender(profileDTO.getGender());
		profile.setMobileNo(profileDTO.getMobileNo());
		profile.setFirstName(profileDTO.getFirstName());
		profile.setMiddleName(profileDTO.getMiddleName());
		profile.setLastName(profileDTO.getLastName());
		
		return ResponseEntity.ok(userProfileRepo.save(profile));
	}
	
	
}
