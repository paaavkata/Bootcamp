package main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.Scanner;

import model.Delux;
import model.Luxury;
import model.Room;
import model.SuperDelux;

public class ReservationSystem {
	
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	private static Scanner scan = new Scanner(System.in);
	private static String file = "reservations.txt";
	private static ObjectInputStream is;
	private static ObjectOutputStream os;
	private static FileInputStream fi;
	private static FileOutputStream fo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		importRooms();
		
		if(rooms.isEmpty()) {
			makeRooms();
		}
		
		int choice;
		System.out.println("Welcome to hotel room reservation facility");
		boolean shouldBrake = false;
		while(true) {
			System.out.println();
			System.out.println("What do you want to do? Enter number and press ENTER");
			System.out.println("1. Make room reservation");
			System.out.println("2. Check rooms availability");
			System.out.println("3. Check exact room occupant");
			System.out.println("0. Exit");
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
				case 1:
					makeReservation();
					break;
				case 2:
					checkAvailability();
					break;
				case 3:
					int room;
					while(true) {
						System.out.println("Enter room number that you want to check(from 1 to 30):");
						room = scan.nextInt();
						if(room > 0 && room < 31) {
							break;
						}
					}
					checkRoom(room-1);
					break;
				case 4:
				default:
					shouldBrake = true;
				
			}
			if(shouldBrake) {
				scan.close();
				break;
			}
		}
		
	}
	
	private static void checkRoom(int room) {
		if(rooms.get(room-1).isOccupied()) {
			System.out.println("Room is occupied by " + rooms.get(room-1).getOccupant());
		}
		else {
			System.out.println("Room is empty");
		}
	}
	private static void checkAvailability() {
		int luxury1 = 0;
		int luxury2 = 0;
		int deluxe1 = 0;
		int deluxe2 = 0;
		int superDeluxe1 = 0;
		int superDeluxe2 = 0;
		for(Room room : rooms) {
			if(room instanceof Luxury && !room.isOccupied()) {
				if(room.getPlaces() == 2) {
					luxury2++;
				}
				else {
					luxury1++;
				}
				continue;
			}
			if(room instanceof Delux && !room.isOccupied()) {
				if(room.getPlaces() == 2) {
					deluxe2++;
				}
				else {
					deluxe1++;
				}
				continue;
			}
			if(room instanceof SuperDelux && !room.isOccupied()) {
				if(room.getPlaces() == 2) {
					superDeluxe2++;
				}
				else {
					superDeluxe1++;
				}
				continue;
			}
		}
		System.out.println("Free rooms:");
		System.out.println("Luxury (1 person): " + luxury1);
		System.out.println("Luxury (2 persons): " + luxury2);
		System.out.println("Deluxe (1 person): " + deluxe1);
		System.out.println("Deluxe (2 persons): " + deluxe2);
		System.out.println("Super Deluxe (1 person): " + superDeluxe1);
		System.out.println("Super Deluxe (2 persons): " + superDeluxe2);
		return;
	}
	private static void makeReservation() {
		int type;
		while(true) {
			System.out.println("Enter room type:");
			System.out.println("1. Luxury");
			System.out.println("2. Delux");
			System.out.println("3. Super Delux");
			type = scan.nextInt();
			if(type >= 1 && type <= 3) {
				break;
			}
		}
		int beds;
		while(true) {
			System.out.println("Enter number of places(1 or 2)");
			beds = scan.nextInt();
			if(beds == 1 || beds == 2) {
				break;
			}
		}
		scan.nextLine();
		boolean isThereFreeRoom = false;
		int roomNumber = 1;
		for(Room room : rooms) {
			if(!room.isOccupied() && room.getPlaces() == beds && room.getType() == type) {
				room.setOccupied(true);
				System.out.println("Enter your name:");
				String name = scan.nextLine();
				System.out.println("For how many nights would you like to book the room?");
				int nights = scan.nextInt();
				room.setOccupant(name);
				isThereFreeRoom = true;
				roomNumber++;
				System.out.println(name + ", you have booked your room. Your room number is " + roomNumber);
				System.out.println("We expect your payment. The amount you have to pay is: " + nights*room.getRate());
				persistRooms();
				break;
			}
			roomNumber++;
		}
		
		if(!isThereFreeRoom) {
			System.out.println("There is no free room with this criteria");
			System.out.println("Would you like to try again with the search?");
			System.out.println("1. YES");
			System.out.println("Anything else: NO");
			if(scan.nextInt() == 1) {
				makeReservation();
			}
		}

	}
	
	private static void persistRooms() {
		try {
			fo = new FileOutputStream(file);
			os = new ObjectOutputStream(fo);
			for(Room room : rooms) {
				os.writeObject(room);
			}
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	private static void importRooms() {
		try {
			fi = new FileInputStream(new File(file));
			is = new ObjectInputStream(fi);
			while(true) {
				try {
				rooms.add((Room) is.readObject());
				} catch (EOFException e){
					is.close();
					break;
				}
				System.out.println((Room) is.readObject());
			}	
		}
		catch(EOFException e) {
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found. Creating new one.");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void makeRooms() {
		for(int i = 0; i < 30; i++) {
			if(i < 5) {
				rooms.add(new Delux(1));
				continue;
			}
			if(i < 10) {
				rooms.add(new Delux(2));
				continue;
			}
			if(i < 15) {
				rooms.add(new SuperDelux(1));
				
				continue;
			}
			if(i < 20) {
				rooms.add(new SuperDelux(2));
				
				continue;
			}
			if(i < 25) {
				rooms.add(new Luxury(1));
				continue;
			}
			if(i < 30) {
				rooms.add(new Luxury(2));
				continue;
			}
		}
		persistRooms();
	}
}