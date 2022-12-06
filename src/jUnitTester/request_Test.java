package jUnitTester;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import cosc310project_databaseAndLogin.dbKey;
import cosc310project_databaseAndLogin.userKey;
import cosc310project_scheduling.event;

class request_Test {
	
	dbKey dbk;
	
	@Test
	void testInit() throws Exception {
		try {
			dbk = new dbKey("user","userpw","jdbc:mysql://localhost/wsDB");
		}catch(Exception e) {
			Assertions.fail("Invalid DBKey!");
		}
	}
	
	void testUserRequest_GetUUID() {
		String uuid = new userKey("test","testpw",dbk).getUUID();
		
		Assertions.assertEquals(uuid, "00000000");
	}
	
	void testUserRequest_GetEvents() {
		ArrayList<event> userEvents = new userKey("test","testpw",dbk).getEvents();
		ArrayList<event> testEvents = new ArrayList<event>();
		testEvents.add(new event("2437834854378345", "Test Event", 
						"Test Event", new Date(0), 
						"Test Location", "346854387234", true));
		Assertions.assertEquals(userEvents, testEvents);
	}

}
