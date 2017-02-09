package com.marist.mscs721;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RoomScheduler {
	protected static Scanner keyboard = new Scanner(System.in);
	private static int count = 0;

	private RoomScheduler() {
		mainMenu();
	}
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		RoomScheduler r = new RoomScheduler();
		Boolean end = false;
		System.out.println(gson.toJson(r));
		
		ArrayList<Room> rooms = new ArrayList<>();

		while (!end) {
			switch (mainMenu()) {

			case 1:
				System.out.println(r.addRoom(rooms));
				System.out.println(gson.toJson(r));
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

	protected static String listSchedule(ArrayList<Room> roomList) {
		String roomName = getRoomName();
		System.out.println(roomName + " Schedule");
		System.out.println("---------------------");
		
		for (Meeting m : getRoomFromName(roomList, roomName).getMeetings()) {
			System.out.println(m.toString());
		}

		return "";
	}
	
	protected static int mainMenu() {
		System.out.println("Main Menu:");
		System.out.println("  1 - Add a room");
		System.out.println("  2 - Remove a room");
		System.out.println("  3 - Schedule a room");
		System.out.println("  4 - List Schedule");
		System.out.println("  5 - List Rooms");
		System.out.println("  6 - Get Json");
		System.out.println("  7 - Exit");
		System.out.println("Enter your selection: ");
		count = 0;
		while(!keyboard.hasNextInt()){
			if(count >= 3) {
				System.out.println("Too many attempts!");
				return 0;
			}
			System.out.println("You entered a String! Try again...");
			keyboard.next();
			count++;
		}
		return keyboard.nextInt();
	}

	protected static String addRoom(ArrayList<Room> roomList) {
		System.out.println("Add a room:");
		String name = getRoomName();
		System.out.println("Room capacity?");
		count  = 0;
		while(!keyboard.hasNextInt()){
			if(count > 3) {
				System.out.println("You tried too many times now!");
				return "";
			}
			System.out.println("Invalid input! Try again.");
			keyboard.next();
			count++;
		}
		int capacity = keyboard.nextInt();

		Room newRoom = new Room(name, capacity);
		roomList.add(newRoom);

		return "Room '" + newRoom.getName() + "' added successfully!";
	}

	protected static String removeRoom(ArrayList<Room> roomList) {
		System.out.println("Remove a room:");
		roomList.remove(findRoomIndex(roomList, getRoomName()));
		
		return "Room removed successfully!";
	}

	protected static String listRooms(ArrayList<Room> roomList) {
		System.out.println("Room Name - Capacity");
		System.out.println("---------------------");

		for (Room room : roomList) {
			System.out.println(room.getName() + " - " + room.getCapacity());
		}

		System.out.println("---------------------");

		return roomList.size() + " Room(s)";
	}

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
			e.printStackTrace();
		}

		System.out.println("Subject?");
		String subject = keyboard.next();

		Room curRoom = getRoomFromName(roomList, name);

		Meeting meeting = new Meeting(startTimestamp, endTimestamp, subject);

		curRoom.addMeeting(meeting);

		return "Successfully scheduled meeting!";
	}

	protected static Room getRoomFromName(ArrayList<Room> roomList, String name) {
		return roomList.get(findRoomIndex(roomList, name));
	}

	protected static int findRoomIndex(ArrayList<Room> roomList, String roomName) {
		int roomIndex = 0;

		for (Room room : roomList) {
			if (room.getName().compareTo(roomName) == 0) {
				break;
			}
			roomIndex++;
		}

		return roomIndex;
	}

	protected static String getRoomName() {
		System.out.println("Room Name?");       
		while(keyboard.hasNextInt()) {
			System.out.println("Enter correct room name...");
			keyboard.next();
		}
		return keyboard.next();
	}
	
	public static void getDataFromRoomScheduler(ArrayList<Room> roomList) {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(roomList);
		try {
			FileWriter writer = new FileWriter("sample.json");
			writer.write(json);
			writer.close();
			System.out.println("File exported"+json);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
