package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AddRoomTest.class, RemoveRoomTest.class, 
	ScheduleRoomTest.class, RemoveRoomTest.class, 
	ListRoomTest.class, RoomTest.class, MeetingTest.class})

/**
 * A test suite to run all the tests included in the package
 */
public class JUnitTestSuite {

}
