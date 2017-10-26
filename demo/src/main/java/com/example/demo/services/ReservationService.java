package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Hotel;
import com.example.demo.models.Reservation;

public interface ReservationService {
	
	public List<Reservation> listAll();

    public Reservation getById(Long id);

    public Reservation saveOrUpdate(Reservation reservation);

    public void delete(Long id);

}
