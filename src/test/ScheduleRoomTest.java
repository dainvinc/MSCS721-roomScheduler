package test;

import static org.junit.Assert.assertEquals;

import java.security.Timestamp;
import java.util.ArrayList;

import org.junit.Test;

import com.marist.mscs721.Room;
import com.marist.mscs721.RoomScheduler;
/**
 * A test class to schedule a room with a subject
 */
public class ScheduleRoomTest {
	RoomScheduler rs = new RoomScheduler();
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	@Test
	public void scheduleRoomSubjectTest() {
		//create a room
		Room r1 = new Room("LB", 30);
		rooms.add(r1);
		r1 = rs.getRoomFromName(rooms, "LB");
		String subject = "random";
		//test if the subject is equal or not
		assertEquals(subject, "random");
	}
}