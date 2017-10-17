package com.reservationsystem.modelForms;

public class RoomForm {
	private String name;
	private int roomNumber;
	private int bedrooms;
	private int beds;
	private boolean airCondition;
	private boolean wiFi;
	private boolean terrase;
	private boolean goodView;
	private boolean kitchen;
	private boolean toilet;
	private boolean TV;
	
	
	public RoomForm() {
		
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
