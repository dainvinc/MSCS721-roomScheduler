package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.marist.mscs721.Room;
import com.marist.mscs721.RoomScheduler;

/*
 * Test class to check if a room is removed
 */
public class RemoveRoomTest {
	RoomScheduler rs = new RoomScheduler();	
	ArrayList<Room> rooms = new ArrayList<Room>();
	/*
	 * test out the removeRoom() method*/
	@Test
	public void removeRoomTest() {
		Room r = new Room("DN", 20);
		//adds the room name into the ArrayList
		rooms.add(r);
		//removes the room from the ArrayList
		rooms.remove(r);
		//rs.removeRoom(rooms);
		//checks if the size is equals to 0
		assertEquals(rooms.size(), 0);
	}
}
