package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/registeruser")
	@ResponseBody
	public User signin(@RequestBody User user){
		User newUser = userService.saveOrUpdate(user);
		return newUser;
	}
	
	@GetMapping(value = "/viewprofile/{id}")
	@ResponseBody
	public User viewprofile(@PathVariable long id) {
		return userService.getById(id);
	}
	
	@GetMapping(value = "/allusers")
	@ResponseBody
	public List<User> listall(){
		return userService.listAll();
	}
}
