package model;

import java.io.Serializable;

public abstract class Room implements Serializable{
	@Override
	public String toString() {
		return "Room [places=" + places + ", wifi=" + wifi + ", occupied=" + occupied + ", rate=" + rate + ", occupant="
				+ occupant + ", type=" + type + "]";
	}
	private static final long serialVersionUID = 1L;
	private int places;
	private final boolean wifi;
	private boolean occupied;
	private int rate;
	private String occupant;
	private int type;
	
	public Room(int places, boolean wifi, boolean occupied, int rate, int type) {
		this.places = places;
		this.wifi = wifi;
		this.occupied = occupied;
		this.rate = rate;
		this.type = type;
	}
	public int getType() {
		return type;
	}
	public boolean isOccupied() {
		return occupied;
	}
	
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public int getPlaces() {
		return places;
	}
	
	public boolean isWifi() {
		return wifi;
	}
	
	public int getRate() {
		return rate;
	}

	public String getOccupant() {
		return occupant;
	}
	public void setOccupant(String name) {
		this.occupant = name;		
	}
	
}
