package com.reservationsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservationsystem.modelForms.HotelForm;
import com.reservationsystem.models.Rentable.Hotel;
import com.reservationsystem.models.Rentable.Room;

@Service
public interface HotelService {

	Hotel addRooms(List<Room> rooms);

	Hotel makeNewHotel(HotelForm hotelForm);
	
	List<Hotel> listAll();

    Hotel getById(long id);

    Hotel saveOrUpdate(Hotel hotel);

    void delete(long id);

}
