package com.freshapples.controller;

import com.freshapples.model.DataBaseModel;
import com.freshapples.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshapples.model.RegisterModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/Register")
public class RegisterController {
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", new RegisterModel());
		
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doLogin(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		}
		
		UserModel user = new UserModel(
				registerModel.getFirstName(), 
				registerModel.getLastName(), 
				registerModel.getPhoneNum(), 
				registerModel.getEmailAddress(), 
				registerModel.getUsername(), 
				registerModel.getPassword()
				);
		
		//temp use until database is implemented and connected to DataBaseModel
		DataBaseModel db = new DataBaseModel();
		
		db.addUser(user);

		System.out.println(String.format("New Registration "
				+ "with Username of %s, and Password of %s, First "
				+ "Name of %s, Last Name of %s, Phone number of %s,"
				+ " and email address of %s", 
				registerModel.getUsername(), 
				registerModel.getPassword(),
				registerModel.getFirstName(),
				registerModel.getLastName(),
				registerModel.getPhoneNum(),
				registerModel.getEmailAddress()));

		return "home";
	}

}