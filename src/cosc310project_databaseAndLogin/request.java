package cosc310project_databaseAndLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


abstract public class request{ 
	
	private final dbKey DBkey;	//dbKey to interact with DB
	
	//DB variables	
	protected Connection conn;
	
	
	public request(dbKey key){	//Sets dbKey to DBKey Variable
		this.DBkey = key;	
		//test();	//Comment Out If Stable Connection Exists
	}
	
	protected Connection connect() { //Connect to DB
		try {
			conn = DriverManager.getConnection(DBkey.getURL(), 
					DBkey.getUser(), DBkey.getPass());
		}catch(SQLException e) {
			System.err.println("FATAL ERROR(br-i): "+e);
		}
		return conn;
	}
	
	protected void close() {	//Close DB;
		try {
			if (!conn.isClosed()) 
				conn.close();
			else 
				System.out.println("DB Already Closed!");
		}catch(SQLException e) {
			System.out.println("FATAL ERROR(br-c): "+e);
		}		
	}
	
}
