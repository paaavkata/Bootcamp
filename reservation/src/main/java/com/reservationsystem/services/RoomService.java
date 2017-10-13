package com.reservationsystem.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface RoomService {

	HashMap<Integer, String> getCategories();

}
