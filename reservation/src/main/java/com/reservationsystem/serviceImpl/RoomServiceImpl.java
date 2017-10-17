package com.reservationsystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.Room;
import com.reservationsystem.repositories.RoomRepository;
import com.reservationsystem.services.RoomService;

public class RoomServiceImpl implements RoomService{
	
	private RoomRepository roomRepository;
	
	@Autowired
	public RoomServiceImpl(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	
	@Override
	public void addRoom(Room room) {
		roomRepository.save(room);
	}

	@Override
	public List<Room> listAll() {
		List<Room> rooms = new ArrayList<Room>();
		roomRepository.findAll().forEach(rooms::add);
		return rooms;
	}

	@Override
	public List<Room> listAllHotel(Hotel hotel) {
		List<Room> rooms = new ArrayList<Room>();
		roomRepository.findByHotel(hotel).forEach(rooms::add);
		return rooms;
	}

	@Override
	public Room getById(long id) {
		return roomRepository.findOne(id);
	}

	@Override
	public Room saveOrUpdate(Room room) {
		roomRepository.save(room);
		return room;
	}

	@Override
	public void delete(Room room) {
		roomRepository.delete(room);
	}

}
