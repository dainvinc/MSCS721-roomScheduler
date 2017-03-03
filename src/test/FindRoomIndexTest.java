package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.marist.mscs721.Room;
import com.marist.mscs721.RoomScheduler;
/**
 * A test case to check the room index
 */
public class FindRoomIndexTest {
	@Test
	public void findRoomIndexTest() {
		RoomScheduler rs = new RoomScheduler();
		ArrayList<Room> rooms = new ArrayList<Room>();
		/**
		 * create a new room
		 * @param room name
		 * @param room capacity
		*/ 
		Room r = new Room("Dn", 5);
		rooms.add(r);
		//tests if the size is equals to 1 or not
		assertEquals(rooms.size(), 1);
	}
}
