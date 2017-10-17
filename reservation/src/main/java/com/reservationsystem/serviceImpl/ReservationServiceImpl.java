package com.reservationsystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservationsystem.converters.FormToReservation;
import com.reservationsystem.model.Reservation;
import com.reservationsystem.model.User;
import com.reservationsystem.repositories.ReservationRepository;
import com.reservationsystem.services.HotelService;
import com.reservationsystem.services.ReservationService;

public class ReservationServiceImpl implements ReservationService{

	private ReservationRepository reservationRepository;
	private HotelService hotelService;
	
	private FormToReservation formToReservation;
	
	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationRepository, FormToReservation formToReservation, HotelService hotelService) {
        this.reservationRepository = reservationRepository;
        this.formToReservation = formToReservation;
        this.hotelService = hotelService;
    }

	@Override
	public boolean makeReservation(Reservation reservation, User user) {
		boolean isAvailable = hotelService.checkAvailability(reservation.getStartDate(), reservation.getEndDate(), reservation.getGuests());
		reservationRepository.save(reservation);
		return isAvailable;
	}

	@Override
	public boolean cancelReservation(long reservationId, User user) {
		Reservation reservation = getById(reservationId);
		reservation.setStatus(5);
		reservationRepository.save(reservation);
		return true;
	}
	
	public Reservation getById(long id) {
		return reservationRepository.findOne(id);
	}
}
