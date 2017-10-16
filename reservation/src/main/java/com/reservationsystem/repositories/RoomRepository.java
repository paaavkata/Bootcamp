package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

}
