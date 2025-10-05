package com.wishit.auth.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "userLogin")
public class Login {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String email;

	    @Column(nullable = false)
	    private String password;
	    
	    private String fullName;
	    private String loginFlag;
	    private String loginTime;
	    
	    
	    
	    
	    
	    public String getLoginTime() {
			return loginTime;
		}

		public void setLoginTime(String loginTime) {
			this.loginTime = loginTime;
		}

	    
	    

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getLoginFlag() {
			return loginFlag;
		}

		public void setLoginFlag(String loginFlag) {
			this.loginFlag = loginFlag;
		}


	    

	
	    
	    
	    

	

}
