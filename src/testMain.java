import java.sql.Date;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Timer;

import cosc310project_communication.*;
import cosc310project_databaseAndLogin.*;
import cosc310project_scheduling.*;


public class testMain {

	public static void main(String[] args) throws Exception {
		
		
		
		/*
		 * ArrayList<event> a = new ArrayList<event>(); a.add(new
		 * event("Lunch At John's","Lunch At John's Place",1670379762,"U5",true,false));
		 * 
		 * mailKey mk = new mailKey("userNotify310@gmail.com","icvointohnywrnwn");
		 * userKey uk = new userKey("chrisgrace281@gmail.com","Chris281");
		 * uk.setEventsNoDB(a);
		 * 
		 * new notifyUser(uk,mk).run();
		 */
		 
		 
		
//		Timer timer = new Timer();
	    
//		timer.schedule(new notifyUser(uk,mk), 100);
		
		//System.out.println(new event("","","",1672596000).getTimestamp());
		
		
		
		  scheduleSports ss = new scheduleSports(league.NFL,"chiefs"); 
		  ArrayList<event> ales = ss.getGames(); 
		  System.out.println(ales.size()); 
		  ListIterator<event> ale = ales.listIterator(); 
		  while (ale.hasNext()) { 
			  event a1 = ale.next();
			  System.out.println(a1.getName()+" on "+a1.getTimestamp()); 
		  }
		 
		
		
		
		
	}

}

//CFL link = "http://api.cfl.ca/v1/games/2015?key=HyP9UlqyhBHDTbKn2Kzdddk6KlyjzBJ2"
