package com.reservationsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.Room;

@Service
public interface RoomService {

	void addRoom(Room room);
	
	List<Room> listAll();
	
	List<Room> listAllHotel(Hotel hotel);

    Room getById(long id);

    Room saveOrUpdate(Room room);

    void delete(Room room);

}
