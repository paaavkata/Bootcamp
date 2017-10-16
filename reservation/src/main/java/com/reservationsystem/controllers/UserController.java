package com.reservationsystem.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservationsystem.model.User;
import com.reservationsystem.modelForms.UserForm;
import com.reservationsystem.services.UserService;

@Controller
public class UserController {
	private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
    	this.userService = userService;
    }
        
	@GetMapping(value="/profile/{id}")
	public String profile(@PathVariable Long id, Model model, HttpSession session){
		UserForm userForm = (UserForm) session.getAttribute("user");
    	if(userForm != null){
			if(userForm.getId() == id) {
				session.removeAttribute("notification");
				User user = userService.getById(id);
				session.setAttribute("user", user);
				session.setAttribute("levels", userService.getLevels());
				session.setAttribute("notifications", userService.getNotifications(user));
				session.setAttribute("user", user);
				return "profile";
			}
		}
		return "login";
	}
	
	@GetMapping(value="/login")
	public String loginForm(HttpSession session) {
		session.removeAttribute("notification");
		if (session.getAttribute("user") != null) {
			session.setAttribute("notification", "You are already logged in.");
			return "index";
		}
		else{
			session.removeAttribute("notifsignup");
			return "login";
		}	
	}
	
	@PostMapping(value="/login")
	public String login(@Valid UserForm userForm, BindingResult bindingResult, HttpSession session) {
		if(session.isNew()){
			session.invalidate();
			return "login";
		}
		
		if(bindingResult.hasErrors()) {
			return "login";
		}
		
		User user = userService.validLogin(userForm);
		if(user != null){
			session.setAttribute("user", user);
			session.setAttribute("notifications", userService.getNotifications(user));
			switch(user.getRole()) {
			case 1:
			case 2:
				return "/";
			case 3:
			case 4:
				return "/worker";
			case 5:
				return "/manager";
			case 6:
				return "/admin";	
			}
	        return "/";
		}		
		else{
			session.setAttribute("notifsignup", "Wrong username or password. Try again!");
			return "login";
		}
	}
	
	@GetMapping(value="/signup")
	public String signupForm(HttpSession session) {
		session.removeAttribute("notification");
		if (session.getAttribute("user") != null) {
			session.setAttribute("notification", "You are already logged in.");
			return "index";
		}
		else{
			session.removeAttribute("notifsignup");
			return "/signup";
		}
		
	}
	@PostMapping(value="/signup")
	public String signup(@Valid UserForm userForm, BindingResult bindingResult, HttpSession session, HttpServletRequest request) {
		if(session.getAttribute("user") != null) {
			session.setAttribute("notification", "You are already logged in.");
			return "index";
		}
		if(bindingResult.hasErrors()) {
			request.setAttribute("userForm", userForm);
			return "signup";
		}
		userForm.setLevel(1);
		User user = userService.registerUser(userForm);
		if(user != null){
			session.setAttribute("user", user);	
			session.removeAttribute("notification");
			session.setAttribute("notifications", userService.getNotifications(user));
			
			
	        return "/";
		}		
		else{
			session.setAttribute("notifsignup", "Wrong username or password. Try again!");
			return "login";
		}
	}
	
	
}
