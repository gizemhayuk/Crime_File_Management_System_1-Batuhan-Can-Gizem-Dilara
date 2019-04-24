package CrimeFile;

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
	
	
	//checks login condition
	@Test
	public void loginConnection() {
		assertFalse(login.getLogin("aliyilmaz","ali1995")); // returns false because in database there is no such a person.
		assertTrue(login.getLogin("gizemhayuk", "gizem123")); //returns true because this person is in the database.
	}
	
	//test for register 
	@Test
	public void registerControl() {
		assertTrue(criminalRecord.RegisterData("can","ozer","23697821621","29061997","Ankara")); //return true because database contains no such a person, so we can add.
		assertFalse(criminalRecord.RegisterData("", "tekin", "", "", "Izmir")); //returns false because some of inputs are not entered. 
	
	}
	
	

}
