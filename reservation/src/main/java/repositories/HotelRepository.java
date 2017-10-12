package repositories;

import org.springframework.data.repository.CrudRepository;

import models.Hotel;

public interface HotelRepository  extends CrudRepository<Hotel, Long>{

}
