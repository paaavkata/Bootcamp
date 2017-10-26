package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Hotel;
import com.example.demo.models.Room;

public interface RoomService {

    public List<Room> listAll();


    public Room getById(Long id);


    public Room saveOrUpdate(Room room);


    public void delete(Long id);

}
