package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.marist.mscs721.Room;
import com.marist.mscs721.RoomScheduler;
/**
 * Test to check the list of rooms
 */
public class ListRoomTest {
	RoomScheduler rs = new RoomScheduler();
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	@Test
	public void listRoomTest() {
		Room r = new Room("Dn", 4);
		rooms.add(r);
		//rs.addRoom(rooms);
		/**
		 * checks the list of rooms
		 * @param room list
		 */
		rs.listRooms(rooms);
		assertEquals(rooms.size(), 1);
	}
}
