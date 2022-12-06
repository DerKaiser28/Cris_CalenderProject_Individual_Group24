package jUnitTester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import cosc310project_databaseAndLogin.dbKey;
import cosc310project_databaseAndLogin.key;
import cosc310project_databaseAndLogin.userKey;

class key_Test {
	dbKey dbk;
	
	void init() throws Exception {
		dbk = new dbKey("user","userpw","jdbc:mysql://localhost/wsDB");
	}
	
	@Test
	void testUserKey_getUser() {
		try {
			
			String user = new userKey("test","testpw",dbk).getUser();
			Assertions.assertEquals(user, "test");
		} catch (Exception e) {
			Assertions.fail("DBK ERROR: U");
		}
	}
	
	void testUserKey_getPass() {
		try {
			dbk = new dbKey("user","userpw","jdbc:mysql://localhost/wsDB");
			String pass = new userKey("test","testpw",dbk).getPass();
			Assertions.assertEquals(pass, "testpw");
		} catch (Exception e) {
			Assertions.fail("DBK ERROR: P");
		}
	}
	
	void testUserKey_hash() {
		String test = new testKey("test","testpw").hash("test");
		Assertions.assertEquals(test, "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08");
	}
	
	void testdbKey_getURL() throws Exception {
		String dbkURL = new dbKey("user","userpw","jdbc:mysql://localhost/wsDB").getURL();
		Assertions.assertEquals(dbkURL,"jdbc:mysql://localhost/wsDB");
	}

}

class testKey extends key{

	testKey(String user, String pass) {
		super(user, pass);
	}
	
	public static String hash(String s) {
		return hash(s);
	}
}
