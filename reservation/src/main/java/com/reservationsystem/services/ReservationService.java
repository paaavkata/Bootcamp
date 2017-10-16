package com.reservationsystem.services;

import org.springframework.stereotype.Service;

import com.reservationsystem.model.Reservation;
import com.reservationsystem.model.User;

@Service
public interface ReservationService {
	
	void makeReservation(Reservation reservation, User user);
	
	void cancelReservation(long reservationId, User user);

}
