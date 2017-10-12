package repositories;

import org.springframework.data.repository.CrudRepository;

import models.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
