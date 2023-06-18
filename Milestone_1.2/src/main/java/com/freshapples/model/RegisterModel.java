package com.freshapples.model;

import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/*
 * RegisterModel validates and stores data used as the registration 
 * information for the user
 * 
 * */

@Service
public class RegisterModel {
	
	@NotNull(message="First name is a required field")
	@Size(min=1, max=32, message="First name must be between 1 and 32 characters")
	private String firstName;
	@NotNull(message="Last name is a required field")
	@Size(min=1, max=32, message="Last name must be between 1 and 32 characters")
	private String lastName;
	@NotNull(message="Email Address is a required field")
	@Size(min=1, max=100, message="Email Address must be between 1 and 100 characters")
	private String emailAddress;
	@NotNull(message="Phone Number is a required field")
	@Size(min=10, max=10, message="Phone Number must be a 10 digit number")
	private String phoneNum;
	@NotNull(message="User name is a required field")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
	private String username;
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
