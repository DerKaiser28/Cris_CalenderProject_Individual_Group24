package cosc310project_scheduling;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Random;

public class event{
	private String ueid, name, des, location, sk;
	private Timestamp timestamp; //Date it is happening or when it's due
	private boolean fixed, repeat;
	
	public event(String ueid, String name, String des, long timestamp, String location, String sk, boolean fixed, boolean repeat) {	//Existing Event
		this.setUeid(ueid);
		this.setName(name); 
		this.setDes(des);
		this.setLocation(location);
		this.setSk(sk);
		this.setTimestamp(timestamp); 
		this.setFixed(fixed);
		this.setRepeat(repeat);
	}
	
	public event(String name, String location, long timestamp) {	//Sporting Event
		setName(name);
		setDes(name);
		setTimestamp(timestamp);
		setUeid();
		setLocation(location);
		setSk();
		setFixed(true);
		setRepeat(false);
		writeEvent();
	}
	
	public event(String name, String des, long timestamp, String location, boolean fixed, boolean repeat) {	//Normal Event Declaration 
		setName(name);
		setDes(des);
		setTimestamp(timestamp);
		setUeid();
		setLocation(location);
		setSk();
		setFixed(fixed);
		setRepeat(repeat);
		writeEvent();
	}
	
	public void setTimestamp(long timeStamp) {
		timeStamp = timeStamp * 1000;
		timestamp = new Timestamp(timeStamp);
	}
	
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public int getHoursUntil() {	//redo Using timestamp
		 Timestamp now = new Timestamp(System.currentTimeMillis());
		 
		long hours = (long) ((timestamp.getTime() - now.getTime()) / 3.6e+6);
		//System.out.println(hours);
		
		return (int) hours;
	}

	public String getUeid() {
		return ueid;
	}

	private void setUeid(String ueid) {
		this.ueid = ueid;
	}
	
	private void setUeid() {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999999);
	    this.ueid = String.format("%09d", number);
	}
	
	private void setSk() {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999999);
	    this.sk = String.format("%09d", number);
	}
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSk() {
		return sk;
	}

	private void setSk(String sk) {
		this.sk = sk;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}
	
	public void writeEvent() {
		
	}
	
}
