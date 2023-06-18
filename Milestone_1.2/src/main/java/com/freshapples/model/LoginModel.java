package com.freshapples.model;

import org.springframework.stereotype.Service;

import com.freshapples.Application;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/*
 * LoginModel validates and stores data used as the users
 * login information
 * 
 * */
@Service
public class LoginModel {

	@NotNull(message="User name is a required field")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	public boolean validate() {
		
		for(UserModel i : Application.db.dataBase()) {
			if(i.getUsername().equals(this.getUsername()) && i.getPassword().equals(this.getPassword()))
				return true;
		}

		return false;
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
	
}
