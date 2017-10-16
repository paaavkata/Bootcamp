package com.reservationsystem.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.reservationsystem.model.Reservation;
import com.reservationsystem.modelForms.ReservationForm;

@Component	
public class FormToReservation implements Converter<ReservationForm, Reservation>{

	@Override
	public Reservation convert(ReservationForm reservationForm) {
		
		Reservation reservation = new Reservation();
		
		reservation.setHotel(reservationForm.getHotel());
		reservation.setEndDate(reservationForm.getEndDate());
		reservation.setStartDate(reservationForm.getStartDate());
		reservation.setGuests(reservationForm.getGuests());
		reservation.setRooms(reservationForm.getRooms());
		reservation.setUser(reservationForm.getUser());
		
		return reservation;
	}

}
