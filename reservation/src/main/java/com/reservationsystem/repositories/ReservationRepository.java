package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
