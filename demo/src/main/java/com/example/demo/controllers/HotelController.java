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
import com.example.demo.models.Room;
import com.example.demo.services.HotelService;
import com.example.demo.services.RoomService;

@Controller
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	@Autowired
	RoomService roomService;
	
	@PostMapping(value = "/addhotel")
	@ResponseBody
	public Hotel signin(@RequestBody Hotel hotel){
		Hotel newHotel = hotelService.saveOrUpdate(hotel);
		return newHotel;
	}
	
	@GetMapping(value = "/viewhotel/{id}")
	@ResponseBody
	public Hotel viewprofile(@PathVariable long id) {
		return hotelService.getById(id);
	}
	
	@GetMapping(value = "/allhotels")
	@ResponseBody
	public List<Hotel> listall(){
		return hotelService.listAll();
	}
	
	@PostMapping(value = "/addrooms")
	@ResponseBody
	public Hotel addrooms(@RequestBody Hotel hotel) {
		List<Room> rooms = hotel.getRooms();
		for(Room room : rooms) {
			roomService.saveOrUpdate(room);
		}
		hotelService.saveOrUpdate(hotel);
		return hotel;
	}
	
	@GetMapping(value = "/viewhotelrooms/{id}")
	@ResponseBody
	public List<Room> getHotelRooms(@PathVariable long id){
		Hotel hotel = hotelService.getById(id);
		return hotel.getRooms();
	}
	
	@GetMapping(value = "/viewroom/{id}")
	@ResponseBody
	public Room getRoom(@PathVariable long id){
		return roomService.getById(id);
	}
}
