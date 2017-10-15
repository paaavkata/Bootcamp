package com.reservationsystem.models.Rentable;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.reservationsystem.models.User.User;
import com.reservationsystem.models.util.Reservation;

public class Room extends Rentable{

	@Id
	private long id;
	private Hotel hotel;
	private int roomNumber;
	private int beds;
	private RoomType roomType;
	private List<Reservation> reservations;
	private boolean isFree;
	private List<User> occupants;
	
	public Room() {
		
	}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public boolean isFree() {
		return isFree;
	}
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	public List<User> getOccupants() {
		return occupants;
	}
	public void setOccupants(List<User> occupants) {
		this.occupants = occupants;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
}
