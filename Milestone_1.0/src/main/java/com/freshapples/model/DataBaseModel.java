package com.freshapples.model;

import java.util.ArrayList;

public class DataBaseModel {
	
	private ArrayList<UserModel> users;
	
	public DataBaseModel() {
		users = new ArrayList<UserModel>();
	}
	
	public void addUser(UserModel user) {
		users.add(user);
	}
}
