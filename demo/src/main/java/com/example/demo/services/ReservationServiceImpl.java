package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Hotel;
import com.example.demo.models.Reservation;
import com.example.demo.repositories.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> listAll() {
		List<Reservation> reservations = new ArrayList<Reservation>();
		reservationRepository.findAll().forEach(reservations::add);
		return reservations;
	}

	@Override
	public Reservation getById(Long id) {
		return reservationRepository.findOne(id);
	}

	@Override
	public Reservation saveOrUpdate(Reservation reservation) {
		reservationRepository.save(reservation);
		return reservation;
	}

	@Override
	public void delete(Long id) {
		reservationRepository.delete(id);
	}

}
