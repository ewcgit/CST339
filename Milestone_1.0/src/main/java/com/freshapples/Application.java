package com.freshapples;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.freshapples.model.DataBaseModel;


/*
 * Main function of application, runs spring boot application.
 * 
 * Application is an e-commerce web-site for digital movies. 
 * It implements a login, registration, home, and products page.
 * Styling is done with Thymeleaf, bootstrap, and basic CSS.
 * 
 * */
@ComponentScan({"com.freshapples"})
@SpringBootApplication
public class Application {

	public static DataBaseModel db;
	
	public static void main(String[] args) {
		
		db = new DataBaseModel();
		
		ConfigurableApplicationContext app = SpringApplication.run(Application.class, args);
		Arrays.stream(app.getBeanDefinitionNames()).forEach(System.out::println);
		
	}

}
