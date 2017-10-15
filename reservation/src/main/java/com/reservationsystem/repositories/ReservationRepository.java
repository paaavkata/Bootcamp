package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.models.util.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
