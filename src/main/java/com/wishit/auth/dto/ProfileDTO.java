package com.wishit.auth.dto;

import java.sql.Timestamp;

public class ProfileDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
    private String email;
    private String profilePic;
    private Timestamp joinedOn;
    private Long mobileNo;
    private String gender;
    private Long alternativeMobNo;
    private String city;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Timestamp getJoinedOn() {
		return joinedOn;
	}
	public void setJoinedOn(Timestamp joinedOn) {
		this.joinedOn = joinedOn;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getAlternativeMobNo() {
		return alternativeMobNo;
	}
	public void setAlternativeMobNo(Long alternativeMobNo) {
		this.alternativeMobNo = alternativeMobNo;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}  
	
}
