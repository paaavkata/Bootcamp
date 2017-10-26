package com.example.demo.services;

import java.util.List;

import com.example.demo.models.User;

public interface UserService {

	public List<User> listAll();

    public User getById(Long id);

    public User saveOrUpdate(User user);

    public void delete(Long id);
}
