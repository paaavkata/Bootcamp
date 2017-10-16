package com.reservationsystem.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Room {

	@Id
	private long id;
	private ForRent hotel;
	private int roomNumber;
	private int beds;
	private List<Reservation> reservations;
	private boolean isFree;
	private List<User> occupants;
	private String name;
	private int bedrooms;
	private boolean airCondition;
	private boolean wiFi;
	private boolean terrase;
	private boolean goodView;
	private boolean kitchen;
	private boolean toilet;
	private boolean TV;
	
	
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

	public ForRent getHotel() {
		return hotel;
	}

	public void setHotel(ForRent hotel) {
		this.hotel = hotel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public boolean isAirCondition() {
		return airCondition;
	}
	public void setAirCondition(boolean airCondition) {
		this.airCondition = airCondition;
	}
	public boolean isWiFi() {
		return wiFi;
	}
	public void setWiFi(boolean wiFi) {
		this.wiFi = wiFi;
	}
	public boolean isTerrase() {
		return terrase;
	}
	public void setTerrase(boolean terrase) {
		this.terrase = terrase;
	}
	public boolean isGoodView() {
		return goodView;
	}
	public void setGoodView(boolean goodView) {
		this.goodView = goodView;
	}
	public boolean isKitchen() {
		return kitchen;
	}
	public void setKitchen(boolean kitchen) {
		this.kitchen = kitchen;
	}
	public boolean isToilet() {
		return toilet;
	}
	public void setToilet(boolean toilet) {
		this.toilet = toilet;
	}
	public boolean isTV() {
		return TV;
	}
	public void setTV(boolean tV) {
		TV = tV;
	}

	
}
