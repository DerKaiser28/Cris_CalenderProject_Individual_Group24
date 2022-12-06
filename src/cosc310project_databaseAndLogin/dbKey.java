package cosc310project_databaseAndLogin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbKey extends key{
	private String url;	//URL of the DB to connect
	
	
	public dbKey(String usr, String pw, String url) throws SQLCredentialException{  //DB Access KEY
		super(usr,pw);
		this.url = url;
		if (!validateDBCredentials()) throw new SQLCredentialException();
	}
	
	public String getURL() {	//Get URL of DB
		return url;
	}
	
	private boolean validateDBCredentials() {
		return new testRequest(this).test();
	}
}

class SQLCredentialException extends Exception{
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "FATAL ERROR(dbk-Class-sqlc-ts): Incorrect Credentials)";
	}

}

class testRequest extends request {	//testRequest extends abstract class request

	public testRequest(dbKey key){
		super(key);
	}
	
	public boolean test() {	//returns a true or false based on a db test
		try {
			connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT code FROM test;"); rs.next();
			String code = rs.getString("code");
			close();
			if (code.equals("@ab3u48tbnz34eu4)(#74kj")) return true; else return false;
		} catch (SQLException e) {
			System.out.println("FATAL ERROR(tr-t): "+e);
			return false;
		}	
	}
	
}
