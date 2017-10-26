package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	private int roomNumber;
	private int singleBeds;
	private int doubleBeds;
	private boolean occupied;
	private boolean TV;
	private boolean airCon;
	private boolean wifi;
	private boolean goodView;
	private boolean terrase;
	
	public Room() {
		
	}
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
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

	public int getSingleBeds() {
		return singleBeds;
	}

	public void setSingleBeds(int singleBeds) {
		this.singleBeds = singleBeds;
	}

	public int getDoubleBeds() {
		return doubleBeds;
	}

	public void setDoubleBeds(int doubleBeds) {
		this.doubleBeds = doubleBeds;
	}

	public boolean isTV() {
		return TV;
	}

	public void setTV(boolean tV) {
		TV = tV;
	}

	public boolean isAirCon() {
		return airCon;
	}

	public void setAirCon(boolean airCon) {
		this.airCon = airCon;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isGoodView() {
		return goodView;
	}

	public void setGoodView(boolean goodView) {
		this.goodView = goodView;
	}

	public boolean isTerrase() {
		return terrase;
	}

	public void setTerrase(boolean terrase) {
		this.terrase = terrase;
	}
	
}
