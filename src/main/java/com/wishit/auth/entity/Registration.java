
	package com.wishit.auth.entity;
	import jakarta.persistence.*;
	import java.time.LocalDateTime;


	@Entity
	@Table(name = "users")
	public class Registration {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable=false)
	    private String name;

	    @Column(nullable= false,unique = true)
	    private String email;
	    @Column(nullable=false)
	    private String password;

	    //User Story 260127
	    @Column(unique=true, length=36)
	 private String uuid;
	 private String role;


	 public String getUuid() {
		return uuid;
	}
	 public void setUuid(String uuid) {
		 this.uuid = uuid;
	 }
	 public String getRole() {
		 return role;
	 }
	 public void setRole(String role) {
		 this.role = role;
	 }
//User Story 260127



	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }




	}




