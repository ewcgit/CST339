package com.freshapples.controllers;

import com.freshapples.Application;
import com.freshapples.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshapples.model.RegisterModel;

import jakarta.validation.Valid;

/*
 * Class is a controller for /Register, /, /doRegister URLs. /Register is
 * the root directive, / displays the model and creates a new RegisterModel.
 *  /doRegister is called post submission to the / page, it validates the 
 *  data and then submits it to a database 
 * 
 * */

@Controller
@RequestMapping("/Register")
public class RegisterController {
	
	private RegisterModel registerModel;
	
	public RegisterController(RegisterModel registerModel) {
		this.registerModel = registerModel;
	}
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", registerModel);
		
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
		
		Application.db.addUser(user);

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
