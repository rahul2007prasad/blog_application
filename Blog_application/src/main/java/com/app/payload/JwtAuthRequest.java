package com.app.payload;

public class JwtAuthRequest {

	public JwtAuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String username; //email
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
