package cosc310project_scheduling;

import java.util.Date;
import java.util.ListIterator;

import cosc310project_databaseAndLogin.userKey;

public class eventHandler {
	
	private userKey uk;
	
	eventHandler(userKey uk){
		this.uk = uk;
	}
	
	public void addEvent() {
		
	}
	
	public void removeEvent(String ueid) {
		
	}
	
	public void modifyEvent(String aspect, String value) {
		
	}
	
	public void modifyEventDate(Date date) {
		
	}
	
	public event getEvent(String ueid) {
		ListIterator<event> li = uk.getEvents().listIterator(); 
		while (li.hasNext()) {
			event currentEvent = li.next();
			if(currentEvent.getUeid() == ueid) {
				return currentEvent;
			}
		}
		System.err.println("FATAL ERROR(eh-g): Invalid UEID");
		return null;
	}
	
	
	
	
}
