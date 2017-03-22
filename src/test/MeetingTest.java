package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Test;

import com.marist.mscs721.Meeting;

/**
 * Test case to test the Meeting class*/
public class MeetingTest {
	@Test
	public void meetingTest() {
		//Creates a meeting
		try{
			Meeting m = new Meeting(Timestamp.valueOf("2009-10-02 16:52:30"), Timestamp.valueOf("2009-10-03 16:52:30"), "Testing");
			assertEquals(m.getSubject(), "Testing");
		}catch(IllegalArgumentException e) {
			
		}
		//tests the start time
		//assertEquals(m.getStartTime(), Timestamp.valueOf("2017-01-02 10:00"));
		//tests the end time
		//assertEquals(m.getStopTime(), Timestamp.valueOf("2017-01-02 10:00"));
		//tests the subject
		
	}
}
