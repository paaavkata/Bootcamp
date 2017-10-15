package com.reservationsystem.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservationsystem.converters.FormToReservation;
import com.reservationsystem.modelForms.ReservationForm;
import com.reservationsystem.models.User.User;
import com.reservationsystem.services.HotelService;
import com.reservationsystem.services.RoomService;
import com.reservationsystem.services.UserService;

@Controller
public class HotelController {
	
	private UserService userService;
	
	private HotelService hotelService;
	
	private RoomService roomService;
	
	private FormToReservation formToReservation;

    @Autowired
    public void setFormToReservation(FormToReservation formToReservation) {
    	this.formToReservation = formToReservation;
    }
	@Autowired
    public void setRoomService(RoomService roomService) {
    	this.roomService = roomService;
    }
	@Autowired
    public void setHotelService(HotelService hotelService) {
    	this.hotelService = hotelService;
    }
	
    @Autowired
    public void setUserService(UserService userService) {
    	this.userService = userService;
    }
		
	@PostMapping(value="/makereservation")
	public String reservation(@Valid ReservationForm reservationForm, BindingResult bindingResult, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null){
			session.removeAttribute("notification");
			session.setAttribute("notifications", userService.getNotifications(user));
			hotelService.makeReservation(reservationForm, user);
			return "/";
		}
		else {
			session.setAttribute("notification", "You are not logged in.");
			return "/login";
		}
	}
	@GetMapping(value="/makereservation")
	public String reservationForm(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null){
			session.removeAttribute("notification");
			session.setAttribute("notifications", userService.getNotifications(user));
			HashMap<Integer, String> categories = roomService.getCategories();
			session.setAttribute("categories", categories);
			return "makereservation";
		}
		return "/";
	}
}
