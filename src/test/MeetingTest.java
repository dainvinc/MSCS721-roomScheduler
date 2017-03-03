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
		Meeting m = new Meeting(Timestamp.valueOf("2017-01-02 10:00"), Timestamp.valueOf("2017-01-09 12:00"), "Testing");
		//tests the start time
		assertEquals(m.getStartTime(), Timestamp.valueOf("2017-01-02 10:00"));
		//tests the end time
		assertEquals(m.getStopTime(), Timestamp.valueOf("2017-01-02 10:00"));
		//tests the subject
		assertEquals(m.getSubject(), "Testing");
	}
}
