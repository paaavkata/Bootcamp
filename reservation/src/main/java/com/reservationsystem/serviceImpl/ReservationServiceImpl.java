package com.reservationsystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservationsystem.converters.FormToReservation;
import com.reservationsystem.models.User.User;
import com.reservationsystem.models.util.Reservation;
import com.reservationsystem.repositories.ReservationRepository;
import com.reservationsystem.services.ReservationService;

public class ReservationServiceImpl implements ReservationService{

	private ReservationRepository reservationRepository;
	
	private FormToReservation formToReservation;
	
	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationRepository, FormToReservation formToReservation) {
        this.reservationRepository = reservationRepository;
        this.formToReservation = formToReservation;
    }

	@Override
	public void makeReservation(Reservation reservation, User user) {
		reservationRepository.save(reservation);
		
	}

	@Override
	public void cancelReservation(long reservationId, User user) {
		Reservation reservation = getById(reservationId);
		reservation.setStatus(5);
		reservationRepository.save(reservation);
	}
	
	public Reservation getById(long id) {
		return reservationRepository.findOne(id);
	}
}
