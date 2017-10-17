package com.reservationsystem.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reservationsystem.converters.FormToRoom;
import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.Room;
import com.reservationsystem.model.User;
import com.reservationsystem.modelForms.RoomForm;
import com.reservationsystem.services.HotelService;
import com.reservationsystem.services.RoomService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	RoomService roomService;
	HotelService hotelService;
	FormToRoom formToRoom;
	
	@Autowired
	public void setRoomService(RoomService roomService) {
    	this.roomService = roomService;
    }
	
	@Autowired
	public void setHotelService(HotelService hotelService) {
    	this.hotelService = hotelService;
    }
	
	@Autowired
	public void setFormToRoom(FormToRoom formToRoom) {
		this.formToRoom = formToRoom;
	}
	
	@PostMapping("/addroom")
	public String profile(RoomForm roomForm, BindingResult bindingResult, HttpSession session){
		User user = (User) session.getAttribute("user");
		if(bindingResult.hasErrors()) {
			session.setAttribute("notification", "There are errors in the form. Try again.");
		}
    	if(user != null && user.getRole() == 5){
			session.removeAttribute("notification");
			Hotel hotel = hotelService.getHotelByManager(user);
			Room room = formToRoom.convert(roomForm);
			room.setHotel(hotel);
			roomService.addRoom(room);
		}
    	else {
    		session.setAttribute("notification", "You don't have persmission to access this page.");
    		return "/";
    	}
		return "/rooms";
	}
	
	@PostMapping(value="/editroom/{id}")
	public String editRoom(@PathVariable Long id, Model model, HttpSession session){
		return "/rooms";
	}
}
