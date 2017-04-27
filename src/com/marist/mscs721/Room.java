package com.marist.mscs721;

import java.util.ArrayList;

public class Room {	
	
	private String name;
	private String building;
	private String location;
	private int capacity;
	private ArrayList<Meeting> meetings;
	
	
	public Room(String newName, int newCapacity) {
		setName(newName);
		setCapacity(newCapacity);
		setMeetings(new ArrayList<Meeting>());
		setBuilding(building);
		setLocation(location);
	}

	public void setLocation(String location) {
		// TODO Auto-generated method stub
		this.location = location;
	}

	public String getLocation() {
		return this.location;
	}
	
	public void setBuilding(String building) {
		// TODO Auto-generated method stub
		this.building = building;
	}
	
	public String getBuilding() {
		return this.building;
	}
	
	public String addNewMeeting(Meeting newMeeting) {
		if(checkSchedule(newMeeting)) {
			getMeetings().add(newMeeting);
			return "Successfully scheduled meeting!";
		} else
			return "Room isn't free";
	}
	
	public boolean checkSchedule(Meeting newMeeting) {
		ArrayList<Meeting> meetingsList = this.meetings;
		for(Meeting m : meetingsList) {
			if((newMeeting.getStartTime() == m.getStartTime())) 
				return false;
		}
		return true;
	}

	public void addMeeting(Meeting newMeeting) {
		this.getMeetings().add(newMeeting);
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}


	public void setMeetings(ArrayList<Meeting> meetings) {
		this.meetings = meetings;
	}
	
}
