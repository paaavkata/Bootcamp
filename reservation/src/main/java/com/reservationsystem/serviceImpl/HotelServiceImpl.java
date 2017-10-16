package com.reservationsystem.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservationsystem.converters.FormToReservation;
import com.reservationsystem.model.ForRent;
import com.reservationsystem.model.Room;
import com.reservationsystem.repositories.HotelRepository;
import com.reservationsystem.services.HotelService;

public class HotelServiceImpl implements HotelService {
	
	private HotelRepository hotelRepository;

	
	@Autowired
	public HotelServiceImpl(HotelRepository hotelRepository, FormToReservation formToReservation) {
        this.hotelRepository = hotelRepository;
    }

	@Override
	public ForRent makeNewHotel(ForRent hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public List<ForRent> listAll() {
		List<ForRent> hotels = new ArrayList<ForRent>();
		hotelRepository.findAll().forEach(hotels::add);
		return hotels;
	}

	@Override
	public ForRent getById(long id) {
		return hotelRepository.findOne(id);
	}

	@Override
	public ForRent saveOrUpdate(ForRent hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRooms(List<Room> rooms, ForRent hotel) {
		hotel.setRooms(rooms);
		hotelRepository.save(hotel);
	}
	
}
