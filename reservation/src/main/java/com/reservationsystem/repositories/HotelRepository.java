package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.User;

public interface HotelRepository  extends CrudRepository<Hotel, Long>{

	Hotel findByManager(User user);

}
