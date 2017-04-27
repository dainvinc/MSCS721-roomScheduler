package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.marist.mscs721.Room;
import com.marist.mscs721.RoomScheduler;

public class NewScheduleMeeting {
	RoomScheduler rs = new RoomScheduler();
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	@Test
	public void newSchedulerMeetingTest() {
		Room r = new Room("Lowell Thomas", 5);
		r.setLocation("Marist Poughkeepsie Campus");
		r.setBuilding("Lowell Thomas");
		
		assertEquals(r.getName(), r.getBuilding());
	}
	
}
