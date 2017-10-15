package com.reservationsystem.models.Rentable;

import org.springframework.data.annotation.Id;

public class RoomType {
	
	@Id
	private long id;
	private String name;
	private int beds;
	private int bedrooms;
	private boolean airCondition;
	private boolean wiFi;
	private boolean terrase;
	private boolean goodView;
	private boolean kitchen;
	private boolean toilet;
	private boolean TV;
}
