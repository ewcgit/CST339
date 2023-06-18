package com.freshapples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.freshapples.model.LoginModel;


import jakarta.validation.Valid;


/*
 * Login Controller directs the mapping for GET requests
 * sent to the root URI and redirect to /dologin upon successful
 * submission. Purpose is to log the user from the UserModel into 
 * the application through validation in the database.
 * 
 * */
@Controller
@RequestMapping("/")
public class LoginController {

	private LoginModel loginModel;
	
	public LoginController(LoginModel loginModel) {
		this.loginModel = loginModel;
	}
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", loginModel);
		
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}

		System.out.println(String.format("Form with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()));
		
		if(loginModel.validate()) {
			return "home";
		}
		else {
			System.out.println("Incorrect");
			model.addAttribute("title", "Login Form");
			return "login";
		}
			
		
	}


}


