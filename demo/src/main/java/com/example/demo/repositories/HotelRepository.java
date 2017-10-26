package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long>{

}
