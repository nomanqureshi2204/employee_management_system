package com.example.auth.dto;

// Request DTO used internally by employee and client service to create users in auth-service
public class CreateUserRequest {
	
	private String name;
	private String email;
	private String role;
	
	public CreateUserRequest() {}
	
	

	public CreateUserRequest(String name, String email, String role) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}



