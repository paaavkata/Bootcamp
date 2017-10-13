package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.models.Hotel;

public interface HotelRepository  extends CrudRepository<Hotel, Long>{

}
