package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Hotel;
import com.example.demo.models.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{


}
