package com.reservationsystem.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.Reservation;
import com.reservationsystem.model.User;

@Service
public interface ReservationService {
	
	boolean makeReservation(Reservation reservation, User user);
	
	boolean cancelReservation(long reservationId, User user);

}
