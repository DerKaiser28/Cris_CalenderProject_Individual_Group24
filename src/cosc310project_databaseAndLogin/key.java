package cosc310project_databaseAndLogin;

import java.security.MessageDigest;

public abstract class key {
	protected String user, pass;	//User name and Password
	
	protected key(String user, String pass){	//Constructor adds user name and password to final fields
		this.user = user;
		this.pass = pass;	
	}
	
	protected key() {}; //For Empty Keys
	
	public String getUser() {	//Get User name
		return user;
	}
	
	public String getPass() { //Get Password
		return pass;
	}
	
	protected static String hash(String s) {	//Hash values so they are hidden and only known to the user
		try {
			MessageDigest SHAinstance = MessageDigest.getInstance("SHA-256");	//MessageDigest object is used to created an instance 
			byte[] hash = SHAinstance.digest(s.getBytes("UTF-8"));				//of SHA and then that object is used to SHA hash the String
			StringBuilder stringBuilder = new StringBuilder();					//which is then converted to a hex to be stored
			for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) 
	            	stringBuilder.append('0');
	            stringBuilder.append(hex);
	        }
	        return stringBuilder.toString();	
		}catch(Exception e) {
			System.err.println("FATAL ERROR(k-h): "+e);
		}
		return null;
	}
}
