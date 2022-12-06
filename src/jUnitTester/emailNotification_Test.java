package jUnitTester;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;

import org.junit.jupiter.api.Test;
import cosc310project_communication.*;
import cosc310project_databaseAndLogin.userKey;
import cosc310project_scheduling.event;

class emailNotification_Test {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	void testEmailNotificationSystem() {
		ArrayList<event> a = new ArrayList<event>();
		a.add(new event("091929930", "Lunch At John's","Lunch At John's Place",Date.valueOf("02-12-2022"),"U5","000",true));
		a.add(new event("091922222", "Lunch At Arshia's","Lunch At Arshia Place",Date.valueOf("09-12-2022"),"Kalamalka","000",true));
		a.add(new event("091929333", "COSC 310 Assignment","Finish COSC 310",Date.valueOf("02-20-2022"),"UBC","000",false));
		a.add(new event("091953343", "Take Out The Trash","take out the trash bro its been days",Date.valueOf("02-12-2022"),"U8","000",false));
		a.add(new event("091944533", "Going Out To Downtown","Downtown",Date.valueOf("02-12-2022"),"Downtown, Kelowna","000",true));
		mailKey mk = new mailKey("userNotify310@gmail.com","userNotifyJava310");
		userKey uk = new userKey("chrisgrace281@gmail.com","Chris281");
		uk.setEventsNoDB(a);
		Timer timer = new Timer();
		
		//DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    //Date date = dateFormatter.parse("2012-07-06 13:05:45");
	    
		timer.schedule(new notifyUser(uk,mk), 100000);
	}

}
