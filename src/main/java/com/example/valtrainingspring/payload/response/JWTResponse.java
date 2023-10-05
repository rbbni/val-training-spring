package com.example.valtrainingspring.payload.response;

import java.util.List;

public class JWTResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String name;
	private String surname;
	private List<String> roles;

	public JWTResponse(String accessToken, Long id, String username, String name, String surname, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
