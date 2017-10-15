package com.reservationsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reservationsystem.models.User.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
}
