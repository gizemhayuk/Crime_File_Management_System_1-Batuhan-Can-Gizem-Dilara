package tliy;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UnitTests {
	Login login = new Login();
	CriminalRecord criminalRecord = new CriminalRecord();

	//This is for controlling if database is connected or not
	@Test 
	public void isDatabaseConnected() throws SQLException {
		assertNotNull(login.getConnection()); // it works when db is connected.
	}
	
	
	//checks login condition for user
	@Test
	public void loginConnection() {
		assertFalse(login.getLogin("aliyilmaz","ali1995")); // returns false because in database there is no such a user.
		assertTrue(login.getLogin("gizemhayuk", "gizem123")); //returns true because this user is in the database.
	}
	
	//test for adding crime report 
	@Test
	public void registerControl() {
		assertTrue(criminalRecord.RegisterData("cem","tekin","23697821621","29061997","Ankara","robbery", "haha")); //return true because database contains no such a person with this crime.
		assertFalse(criminalRecord.RegisterData("", "tekin", "", "", "Izmir","","")); //returns false because some of inputs are not entered. 
	
	}
	
	

}
