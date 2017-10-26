package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Hotel;
import com.example.demo.models.Room;
import com.example.demo.repositories.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository roomRepository;
 
    @Override
    public List<Room> listAll() {
    	List<Room> rooms = new ArrayList<>();
    	roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    @Override
    public Room getById(Long id) {
        return roomRepository.findOne(id);
    }

    @Override
    public Room saveOrUpdate(Room room) {
    	roomRepository.save(room);
        return room;
    }

    @Override
    public void delete(Long id) {
    	roomRepository.delete(id);

    }
}
