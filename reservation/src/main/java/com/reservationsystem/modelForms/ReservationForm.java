package com.reservationsystem.modelForms;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.reservationsystem.model.Hotel;
import com.reservationsystem.model.Room;
import com.reservationsystem.model.User;

public class ReservationForm {
	
	private long id;
	@NotNull
	private Hotel hotel;
	@NotNull
	private User user;
	@NotNull
	private List<Room> rooms;
	@NotNull
	private List<User> guests;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	public long getId() {
		return id;
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
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<User> getGuests() {
		return guests;
	}
	public void setGuests(List<User> guests) {
		this.guests = guests;
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
	
	
}
