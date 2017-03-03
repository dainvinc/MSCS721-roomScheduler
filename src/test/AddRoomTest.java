package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.marist.mscs721.RoomScheduler;
import com.marist.mscs721.*;

/*
 *Test to see if it has same room name
 */
public class AddRoomTest {
	RoomScheduler rs = new RoomScheduler();
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	/*
	 * method which tests out the addRoom() method
	 */
	@Test
	public void addRoomNameTest() {
		Room r = new Room("LB", 5);
		rooms.add(r);
		//rs.addRoom(rooms);
		//checking if it has the same name
		assertEquals(r.getName(), "LB");
	}
}
