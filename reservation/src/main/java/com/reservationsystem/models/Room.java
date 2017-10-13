package com.reservationsystem.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Room {

	@Id
	private long id;
	private int roomNumber;
	private int beds;
	private int roomType;
	private Reservation reservation;
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
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
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
	
	
	
}
