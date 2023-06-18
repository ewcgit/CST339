package com.freshapples.model;


/*
 * UserModel creates variables for pertinent information 
 * needed from users. This information is populated through 
 * the RegisterModel
 * 
 * */

public class UserModel {
	
	private String firstName, lastName, phoneNum, emailAddress, username, password;
	
	public UserModel(String firstName, String lastName, String phoneNum, String emailAddress, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	

}
