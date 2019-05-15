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
	
	
	//checks login condition for user
	@Test
	public void loginConnection() {
		assertFalse(login.getLogin("aliyilmaz","ali1995")); // returns false because in database there is no such a user.
		assertTrue(login.getLogin("gizemhayuk", "gizem123")); //returns true because this user is in the database.
	}
	
	//test for adding crime report 
	@Test
	public void registerControl() {
		
		//return true because database contains no such a person with this crime.
		assertTrue(criminalRecord.RegisterData("cem","tekin","23697821621","29061997","Ankara","robbery", "At around 8 am Bank manager Julian Davis arrived to prepare "
				+ "the bank for opening. He noticed a black van parked in front of the bank, he did not give much heed to it as it was a public "
				+ " There are two suspects and they entered to the bank and attacked suddenly."
				+ "After obtaining the money from the bank, the two suspects ran out of the store. The parking lot had been painted earlier that afternoon,"
				+ " and Cem Tekin identified one of the suspect’s footprints in the drying paint.  "));
		
		 //returns false because some of inputs are not entered. 
		assertFalse(criminalRecord.RegisterData("", "ozkan", "", "", "Izmir","",""));
		
		
	
	}
	
	

}
