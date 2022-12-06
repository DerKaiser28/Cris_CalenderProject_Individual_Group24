package cosc310project_communication;

import cosc310project_databaseAndLogin.key;
import cosc310project_databaseAndLogin.userKey;
import cosc310project_scheduling.event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Properties;
import java.util.TimerTask;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class notifyUser extends TimerTask{
	
	private static String to;	//To email address 
	
	private static String from; //Email To Send From
	
	final static private String smtp = "smtp.gmail.com"; //SMTP server, change if not using google
	
	private Properties properties; //System Properties
	private Session SMTPserver;	//SMTPserver Session
	
	private static ArrayList<event> ALE; //ArrayList Of Events
	
	private String lastName;
	
	public notifyUser(userKey uk, mailKey k) {
		lastName = uk.getLastName();
		this.properties = System.getProperties();
		from = k.getUser();
		to = uk.getUser();
		setupSMTPServer(k);
		ALE = uk.getEvents();
	}
	
	private void setupSMTPServer(mailKey mk) { //Setup SMTP server
		properties.put("mail.smtp.host", smtp);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        SMTPserver = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(mk.getUser(), mk.getPass());

            }

        });
        SMTPserver.setDebug(true);
	}
	
	public void sendReminder(event currentEvent) { //Send Reminder
		try {
			MimeMessage message = new MimeMessage(SMTPserver); 
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Event Reminder: "+currentEvent.getName());
			DateFormat format = new SimpleDateFormat("HH:mm");
			message.setText("Dear "+lastName+", "
						+ "\n\nToday at "+format.format(currentEvent.getTimestamp())+", You have an event at "
					    + currentEvent.getLocation()+"."
						+ "\n\nEvent Description: "+currentEvent.getDes()
						+ "\n\n\nThank You,\nThe Kondo Team"
							);
			Transport.send(message);
		}catch(Exception e1) {
			System.err.println("FATAL ERROR(nu-sr): "+e1);
		}
	}
	
	@Override
	public void run() {		//Timer Run Method
		ListIterator<event> li = ALE.listIterator();
		while(li.hasNext()) {
			event ce = li.next();
			if (ce.getHoursUntil() < 24 && ce.isFixed() == true) {
				sendReminder(ce);
				li.remove();
				System.out.println("sent");
			}
		}
	}
	
	//Getter Methods
	
	public Properties getProperties() {
		return this.properties;
	}
	
	public String getRecipient() {
		return to;
	}
	
	public String getSender() {
		return from;
	}
	
	public String getSMTPserver() {
		return smtp;
	}

}


