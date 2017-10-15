package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.models.Rentable.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

}
