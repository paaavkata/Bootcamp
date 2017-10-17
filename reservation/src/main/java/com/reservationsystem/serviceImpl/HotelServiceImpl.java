package com.reservationsystem.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservationsystem.converters.FormToReservation;
import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.Room;
import com.reservationsystem.model.User;
import com.reservationsystem.repositories.HotelRepository;
import com.reservationsystem.services.HotelService;

public class HotelServiceImpl implements HotelService {
	
	private HotelRepository hotelRepository;

	
	@Autowired
	public HotelServiceImpl(HotelRepository hotelRepository, FormToReservation formToReservation) {
        this.hotelRepository = hotelRepository;
    }

	@Override
	public Hotel makeNewHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> listAll() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotelRepository.findAll().forEach(hotels::add);
		return hotels;
	}

	@Override
	public Hotel getById(long id) {
		return hotelRepository.findOne(id);
	}

	@Override
	public Hotel saveOrUpdate(Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRooms(List<Room> rooms, Hotel hotel) {
		hotel.setRooms(rooms);
		hotelRepository.save(hotel);
	}

	@Override
	public boolean checkAvailability(Date startDate, Date endDate, int guests) {
		boolean isAvailable = false;
		List<Hotel> forRent = new ArrayList<Hotel>();
		hotelRepository.findAll().forEach(forRent::add);
		
		return isAvailable;
	}
	
	@Override
	public boolean checkHotelAvailability(Hotel hotel, Date startDate, Date endDate, int guests) {
		boolean isAvailable = false;
		List<Hotel> forRent = new ArrayList<Hotel>();
		hotelRepository.findAll().forEach(forRent::add);
		
		return isAvailable;
	}

	@Override
	public Hotel getHotelByManager(User user) {
		return hotelRepository.findByManager(user);
	}
}
