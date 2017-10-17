package com.reservationsystem.converters;

import org.springframework.stereotype.Component;

import com.reservationsystem.model.Room;
import com.reservationsystem.modelForms.RoomForm;

@Component
public class FormToRoom {

	public Room convert(RoomForm roomForm) {
		Room room = new Room();
		room.setName(roomForm.getName());
		room.setRoomNumber(roomForm.getRoomNumber());
		room.setBedrooms(roomForm.getBedrooms());
		room.setBeds(roomForm.getBeds());
		room.setAirCondition(roomForm.isAirCondition());
		room.setWiFi(roomForm.isWiFi());
		room.setTerrase(roomForm.isTerrase());
		room.setGoodView(roomForm.isGoodView());
		room.setKitchen(roomForm.isKitchen());
		room.setToilet(roomForm.isToilet());
		room.setTV(roomForm.isTV());
		return room;
	}

}
