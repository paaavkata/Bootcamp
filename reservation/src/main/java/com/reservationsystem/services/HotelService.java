package com.reservationsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservationsystem.model.ForRent;
import com.reservationsystem.model.Room;

@Service
public interface HotelService {

	ForRent makeNewHotel(ForRent hotel);
	
	List<ForRent> listAll();

    ForRent getById(long id);

    ForRent saveOrUpdate(ForRent hotel);

    void delete(long id);

    void addRooms(List<Room> rooms, ForRent forRent);
}
