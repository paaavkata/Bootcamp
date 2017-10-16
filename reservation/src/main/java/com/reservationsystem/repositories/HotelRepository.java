package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.model.ForRent;

public interface HotelRepository  extends CrudRepository<ForRent, Long>{

}
