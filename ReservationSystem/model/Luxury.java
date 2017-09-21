package model;

import java.io.Serializable;

public class Luxury extends Room implements Serializable{

	private static final long serialVersionUID = 2L;
	
	public Luxury(int places) {
		super(places, false, false, 100, 1);
	}
	
}
