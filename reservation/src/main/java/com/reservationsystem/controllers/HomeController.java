package com.reservationsystem.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.reservationsystem.models.User.User;
import com.reservationsystem.services.UserService;

@Controller
public class HomeController {
	private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
    	this.userService = userService;
    }
    
    @GetMapping(value="/")
    public String index(HttpServletRequest request, HttpSession session){
		session.removeAttribute("notification");
		if(session.getAttribute("user") != null){
			User user = (User) session.getAttribute("user");
			session.setAttribute("notifications", userService.getNotifications(user));
			request.setAttribute("user", user);
		}
		return "index";
	}
    
    
}
