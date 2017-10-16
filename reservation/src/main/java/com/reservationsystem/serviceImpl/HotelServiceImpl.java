package com.reservationsystem.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservationsystem.converters.FormToReservation;
import com.reservationsystem.modelForms.HotelForm;
import com.reservationsystem.modelForms.ReservationForm;
import com.reservationsystem.modelForms.UserForm;
import com.reservationsystem.models.Rentable.Hotel;
import com.reservationsystem.models.Rentable.Room;
import com.reservationsystem.models.User.User;
import com.reservationsystem.models.util.Reservation;
import com.reservationsystem.repositories.HotelRepository;
import com.reservationsystem.services.HotelService;

public class HotelServiceImpl implements HotelService {
	
	private HotelRepository hotelRepository;
	
	
	
	private FormToReservation formToReservation;
	
	@Autowired
	public HotelServiceImpl(HotelRepository hotelRepository, FormToReservation formToReservation) {
        this.hotelRepository = hotelRepository;
        this.formToReservation = formToReservation;
    }

	@Override
	public Hotel getHotel(HotelForm hotelForm) {
		return hotelRepository.findOne(hotelForm);
	}

	@Override
	public HashMap<Integer, String> getLevels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel makeNewHotel(HotelForm hotelForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getById(long id) {
		// TODO Auto-generated method stub
		return null;
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
	public Hotel addRooms(List<Room> rooms) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
