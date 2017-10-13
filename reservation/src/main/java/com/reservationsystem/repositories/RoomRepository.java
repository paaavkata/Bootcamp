package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.models.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

}
