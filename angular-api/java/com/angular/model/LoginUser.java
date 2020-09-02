package com.angular.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_user")
public class LoginUser {
	
	@Id
	private int id;
	private String username;
	private String password;
	private String role; 
	private String email;
	private boolean active;
	
	public LoginUser(int id,String username, String password,String role,boolean active,String email) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
		this.email=email;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LoginUser()
	{
		
	}
	
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", email=" + email + ", active=" + active + "]";
	}
	
}
