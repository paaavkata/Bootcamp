package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	@ResponseBody	
	public String home() {
		System.out.println("in home controller");
		return "Home controller";
	}
}
