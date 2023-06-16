package com.freshapples.model;

import java.util.ArrayList;

/* 
 * Temp class DataBaseModel models a database that stores
 * UserModel type data populated from the RegisterModel
 * */

public class DataBaseModel {
	
	private ArrayList<UserModel> users;
	
	public DataBaseModel() {
		users = new ArrayList<UserModel>();
	}
	
	public void addUser(UserModel user) {
		users.add(user);
	}
}
