package com.reservationsystem.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Reservation {

	@Id
	private long id;
	private Hotel hotel;
	private User user;
	private int guests;
	private List<Room> rooms;
	private Date startDate;
	private Date endDate;
	private int status;
	
	public Reservation() {
		
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public long getId() {
		return id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
}
