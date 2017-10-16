package com.reservationsystem.services;

import org.springframework.stereotype.Service;

import com.reservationsystem.models.User.User;
import com.reservationsystem.models.util.Reservation;

@Service
public interface ReservationService {
	
	void makeReservation(Reservation reservation, User user);
	
	void cancelReservation(long reservationId, User user);

}
