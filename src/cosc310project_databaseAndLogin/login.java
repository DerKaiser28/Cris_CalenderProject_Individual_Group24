package cosc310project_databaseAndLogin;

public class login {

	private static userKey user;	//Variables to get user name and password from user 
	
	public static void loginMain(dbKey k) {
		user = getLogin(k);
		
		
		
		
	}
	
	private static userKey getLogin(dbKey k) {
		//ADD CODE TO POST/GET VALUES FROM FRONTEND
		
		
		
		
		
		
		//END
		try {
			//return new userKey(username, password, k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Enter Correct info");
			//Call method to refresh page and try again
		}
		return null;
	}
	
	
}
