package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

	Iterable<Room> findByHotel(Hotel hotel);

}
