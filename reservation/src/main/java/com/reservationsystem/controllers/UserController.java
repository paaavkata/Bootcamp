package com.reservationsystem.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservationsystem.modelForms.UserForm;
import com.reservationsystem.models.User.User;
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
				User user = userService.getProfile(userForm);
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
		if (session.getAttribute("user") != null) {
			session.removeAttribute("notification");
			session.setAttribute("notification", "You are already logged in.");
			return "index";
		}
		else{
			session.removeAttribute("notification");
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
			if(user.getRole() == 7){
				session.setAttribute("user", user);
				session.setAttribute("notifications", userService.getNotifications(user));
				return "admin";
			}
			session.setAttribute("user", user);
			session.removeAttribute("notification");
	        return "index";
		}		
		else{
			session.setAttribute("notifsignup", "Wrong username or password. Try again!");
			return "login";
		}
	}
	
	@GetMapping(value="/signup")
	public String signupForm(HttpSession session) {
		if (session.getAttribute("user") != null) {
			session.removeAttribute("notification");
			session.setAttribute("notification", "You are already logged in.");
			return "index";
		}
		else{
			session.removeAttribute("notification");
			session.removeAttribute("notifsignup");
			return "/signup";
		}
		
	}
	@PostMapping(value="/signup")
	public String signup(@Valid UserForm userForm, BindingResult bindingResult, HttpSession session) {
		if(session.getAttribute("user") != null) {
			session.setAttribute("notification", "You are already logged in.");
			return "index";
		}
		
		if(bindingResult.hasErrors()) {
			return "login";
		}
		
		User user = userService.registerUser(userForm);
		if(user != null){
			if(user.getRole() == 7){
				session.setAttribute("user", user);
				session.setAttribute("notifications", userService.getNotifications(user));
				return "admin";
			}
			session.setAttribute("user", user);
			session.removeAttribute("notification");
	        return "index";
		}		
		else{
			session.setAttribute("notifsignup", "Wrong username or password. Try again!");
			return "login";
		}
	}
}
