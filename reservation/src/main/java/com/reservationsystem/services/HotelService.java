package com.reservationsystem.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.Room;
import com.reservationsystem.model.User;

@Service
public interface HotelService {

	Hotel makeNewHotel(Hotel hotel);
	
	List<Hotel> listAll();

    Hotel getById(long id);

    Hotel saveOrUpdate(Hotel hotel);

    void delete(long id);

    void addRooms(List<Room> rooms, Hotel forRent);

    boolean checkAvailability(Date startDate, Date endDate, int guests);
    
    boolean checkHotelAvailability(Hotel hotel, Date startDate, Date endDate, int guests);

	Hotel getHotelByManager(User user);
}
