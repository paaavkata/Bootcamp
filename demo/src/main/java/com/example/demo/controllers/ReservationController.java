package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Hotel;
import com.example.demo.models.Reservation;
import com.example.demo.models.User;
import com.example.demo.services.HotelService;
import com.example.demo.services.ReservationService;
import com.example.demo.services.UserService;

@Controller
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	@Autowired
	HotelService hotelService;
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/makereservation")
	@ResponseBody
	public String signin(@RequestBody Reservation reservation, long userId, long hotelId){
		Hotel hotel = hotelService.getById(hotelId);
		User user = userService.getById(userId);
		boolean success = hotelService.makeReservation(reservation, hotel, user);
		return success ? "Reservation successfull!" : "There isnt enough rooms available for your reservation";
	}
	
	@GetMapping(value = "/viewreservation/{id}")
	@ResponseBody
	public Reservation viewprofile(@PathVariable long id) {
		return reservationService.getById(id);
	}
	
	@GetMapping(value = "/allreservationsforhotel/{id}")
	@ResponseBody
	public List<Reservation> listAllForHotel(@PathVariable long id){
		Hotel hotel = hotelService.getById(id);
		return hotel.getReservations();
	}
	
	@PostMapping(value = "/cancelreservation/{id}")
	@ResponseBody
	public String cancelreservation(@PathVariable long id) {
		reservationService.getById(id).setStatus(3);
		return "reservation successfully canceled";
	}
	
}
