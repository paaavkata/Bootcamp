package com.reservationsystem.services;

import org.springframework.stereotype.Service;

import com.reservationsystem.modelForms.ReservationForm;
import com.reservationsystem.models.User;

@Service
public interface HotelService {

	void makeReservation(ReservationForm reservationForm, User user);

}
