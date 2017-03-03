package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marist.mscs721.Room;
/**
 * Tests the class Room*/
public class RoomTest {
	@Test
	public void roomTest() {
		Room r = new Room("Dn", 5);
		//test the room name
		assertEquals(r.getName(), "Dn");
		//tests the room capacity
		assertEquals(r.getCapacity(), 4);
	}
}
