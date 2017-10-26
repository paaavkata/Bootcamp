package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Hotel;
import com.example.demo.models.Reservation;
import com.example.demo.models.User;
import com.example.demo.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public List<Hotel> listAll() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotelRepository.findAll().forEach(hotels::add);
		return null;
	}

	@Override
	public Hotel getById(Long id) {
		return hotelRepository.findOne(id);
	}

	@Override
	public Hotel saveOrUpdate(Hotel hotel) {
		hotelRepository.save(hotel);
		return hotel;
	}

	@Override
	public void delete(Long id) {
		hotelRepository.delete(id);
	}

	@Override
	public boolean makeReservation(Reservation reservation, Hotel hotel, User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
