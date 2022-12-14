package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.Controller;

@SpringBootApplication
public class DemoApplication {
		
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		//Controller controller = new Controller();
		//controller.read();
	}
	
}
