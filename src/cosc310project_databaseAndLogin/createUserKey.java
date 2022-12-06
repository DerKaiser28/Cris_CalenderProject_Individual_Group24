package cosc310project_databaseAndLogin;

public class createUserKey extends key {
	
	private final dbKey dbk;
	
	public createUserKey(String user, String pass, dbKey dbk) {
		setUser(user);
		setPass(pass);
		this.dbk = dbk;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	void setPass(String pass) {
		this.pass = pass;

	}
	
	
	
	
	

	
	
	
	
	
}
