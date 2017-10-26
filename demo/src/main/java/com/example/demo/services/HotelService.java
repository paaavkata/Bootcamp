package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Hotel;
import com.example.demo.models.Reservation;
import com.example.demo.models.Room;
import com.example.demo.models.User;

public interface HotelService {

	public List<Hotel> listAll();

    public Hotel getById(Long id);

    public Hotel saveOrUpdate(Hotel hotel);

    public void delete(Long id);

	public boolean makeReservation(Reservation reservation, Hotel hotel, User user);

}
