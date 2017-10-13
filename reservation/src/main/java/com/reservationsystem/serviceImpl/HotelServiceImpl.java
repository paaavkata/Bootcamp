package com.reservationsystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservationsystem.converters.FormToReservation;
import com.reservationsystem.modelForms.ReservationForm;
import com.reservationsystem.models.Reservation;
import com.reservationsystem.models.User;
import com.reservationsystem.repositories.HotelRepository;
import com.reservationsystem.services.HotelService;

public class HotelServiceImpl implements HotelService {
	
	private HotelRepository hotelRepository;
	
	private FormToReservation formToReservation;
	
	@Autowired
	public HotelServiceImpl(HotelRepository hotelRepository, FormToReservation formToReservation) {
        this.hotelRepository = hotelRepository;
        this.formToReservation = formToReservation;
    }
	
	@Override
	public void makeReservation(ReservationForm reservationForm, User user) {
		Reservation reservation = formToReservation.convert(reservationForm);
	}

}
