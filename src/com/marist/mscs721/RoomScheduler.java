package com.marist.mscs721;


import java.io.FileWriter;
import org.junit.Assert.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RoomScheduler {
	protected static final Logger logger = Logger.getLogger(RoomScheduler.class.getName());
	protected static final Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		Boolean end = false;		
		ArrayList<Room> rooms = new ArrayList<Room>();

		while (!end) {
			switch (mainMenu()) {

			case 1:
				System.out.println(addRoom(rooms));
				break;
			case 2:
				System.out.println(removeRoom(rooms));
				break;
			case 3:
				
				System.out.println(scheduleRoom(rooms));
				break;
			case 4:
				System.out.println(listSchedule(rooms));
				break;
			case 5:
				System.out.println(listRooms(rooms));
				break;
			case 6: 
				getDataFromRoomScheduler(rooms);
				break;
			case 7: 
				System.out.println("You exited successfully.");
				end = true;
				break;
            default:
                System.out.println("Invalid Selection! Try again.");
                break;
           		}

		}
	}
	//lists all the schedules
	protected static String listSchedule(ArrayList<Room> roomList) {
		String roomName = getRoomName();
		System.out.println(roomName + " Schedule");
		System.out.println("---------------------");
		
		for (Meeting m : getRoomFromName(roomList, roomName).getMeetings()) {
			System.out.println(m.toString());
		}

		return "";
	}
	//console which shows the options
	public static int mainMenu() {
		System.out.println("Main Menu:");
		System.out.println("  1 - Add a room");
		System.out.println("  2 - Remove a room");
		System.out.println("  3 - Schedule a room");
		System.out.println("  4 - List Schedule");
		System.out.println("  5 - List Rooms");
		System.out.println("  6 - Get Json");
		System.out.println("  7 - Exit");
		System.out.println("Enter your selection: ");
		int count = 0;
		//verifying if a user enters proper input
		while(!keyboard.hasNextInt()){
			if(count >= 3) {
				logger.info("Too many attempts!");
				return 0;
			}
			logger.warning("You entered a String! Try again...");
			keyboard.next();
			count++;
		}
		return keyboard.nextInt();
	}
	/**
	*Returns with a room name that has been added.
	*@param roomList name or names of the room.
	*/
	public static String addRoom(ArrayList<Room> roomList) {
		System.out.println("Add a room:");
		String name = getRoomName();
		System.out.println("Room capacity?");
		int count  = 0;
		while(!keyboard.hasNextInt()){
			if(count > 3) {
				logger.info("You tried too many times now!");
				return "";
			}
			logger.warning("Invalid input! Try again.");
			keyboard.next();
			count++;
		}
		int capacity = keyboard.nextInt();

		Room newRoom = new Room(name, capacity);
		roomList.add(newRoom);

		return "Room '" + newRoom.getName() + "' added successfully!";
	}
	/**
	*removes the room based on the correct input.
	*@param roomList enter the room to be removed.
	*/
	public static String removeRoom(ArrayList<Room> roomList) {
		System.out.println("Remove a room:");
		roomList.remove(findRoomIndex(roomList, getRoomName()));
		
		return "Room removed successfully!";
	}
	/**
	*displays the list of rooms and their capacity.
	*returns the number of room/rooms.
	*/
	public static String listRooms(ArrayList<Room> roomList) {
		System.out.println("Room Name - Capacity");
		System.out.println("---------------------");

		for (Room room : roomList) {
			System.out.println(room.getName() + " - " + room.getCapacity());
		}

		System.out.println("---------------------");

		return roomList.size() + " Room(s)";
	}
	/**
	*schedules the respective room
	*based on date and time which the user inputs
	*returns with a message stating scheduled successfully
	*/
	protected static String scheduleRoom(ArrayList<Room> roomList) {
		System.out.println("Schedule a room:");
		String name = getRoomName();

		System.out.println("Start Date? (yyyy-mm-dd):");
		String startDate = keyboard.next();
		System.out.println(startDate);
		System.out.println("Start Time?");
		String startTime = keyboard.next();
		startTime = startTime + ":00.0";
		System.out.println(startTime);

		System.out.println("End Date? (yyyy-mm-dd):");
		String endDate = keyboard.next();
		System.out.println("End Time?");
		String endTime = keyboard.next();
		endTime = endTime + ":00.0";
		System.out.println(endTime);
		Timestamp startTimestamp = null;
		Timestamp endTimestamp = null;
		try{
		startTimestamp = Timestamp.valueOf(startDate + " " + startTime);
		//System.out.println(startTimestamp);
		endTimestamp = Timestamp.valueOf(endDate + " " + endTime);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		System.out.println("Subject?");
		String subject = keyboard.nextLine();

		Room curRoom = getRoomFromName(roomList, name);

		Meeting meeting = new Meeting(startTimestamp, endTimestamp, subject);

		curRoom.addMeeting(meeting);

		return "Successfully scheduled meeting!";
	}
	
	public static Room getRoomFromName(ArrayList<Room> roomList, String name) {
		return roomList.get(findRoomIndex(roomList, name));
	}

	public static int findRoomIndex(ArrayList<Room> roomList, String roomName) {
		int roomIndex = 0;

		for (Room room : roomList) {
			if (room.getName().compareTo(roomName) == 0) {
				break;
			}
			roomIndex++;
		}

		return roomIndex;
	}
	/**
	*accepts the room name
	*checks if it contains any integers
	*and asks to reneter room name
	*/
	public static String getRoomName() {
		System.out.println("Room Name?");       
		while(keyboard.hasNextInt()) {
			System.out.println("Enter correct room name...");
			keyboard.next();
		}
		return keyboard.next();
	}
	/**
	*stores the data in the file named sample.json
	*even prints the data to the console.
	*/
	public static void getDataFromRoomScheduler(ArrayList<Room> roomList) throws IOException {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(roomList);
		FileWriter writer = null;
		try {
			//to write the data into sample.json
			writer = new FileWriter("sample.json");
			writer.write(json);
			logger.info("File exported"+json);
		} catch(Exception e) {
			throw new IOException(e);
		} finally {
			writer.close();
		}
	}
	
}