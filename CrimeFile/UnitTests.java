package tliy;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

// In this class we create 20 unit tests and test all classes.
class UnitTests {
	
	Login login = new Login();
	CriminalRecord criminalRecord = new CriminalRecord();
	EditingRecord editRecord = new EditingRecord();
	AdminPage admin = new AdminPage();

	//This is for controlling if database is connected or not
	@Test 
	public void isDatabaseConnected() throws SQLException {
		assertNotNull(login.getConnection()); // it works when db is connected.
		assertNull(login.getConnection()); // it works when database is NOT connected. ( for now it returns failure, because out db is connected.)
	}
	
	
	//checks login condition for user
	@Test
	public void loginConnection() {
		assertFalse(login.getLogin("aliyilmaz","ali1995")); // returns false but not failure(because of assertFalse) because in database there is no such a user.
		assertTrue(login.getLogin("samidogan","sami123")); // we expect true but the actual value is false.
		assertTrue(login.getLogin("gizemhayuk", "gizem123"));//returns true because this user is in the database.
		assertEquals(login.getLogin("gizemhayuk", "gizem123"),login.getLogin("gizemhayuk", "gizem123")); // it returns equal because we have this user in database.
		
	}
	
	//test for adding crime report 
	@Test
	public void registerControl() {
		
		//return true because database contains no such a person with this crime.
		assertTrue(criminalRecord.RegisterData("alp", "akar","23657984216","12061985","Istanbul","robbery","stole money from bank","3"));
		
		 //returns false because some of inputs are not entered. 
		assertFalse(criminalRecord.RegisterData("", "ozkan", "", "", "Izmir","","","2"));
	
	}
	
	@Test
	public void editControlForUser() {
		//updates this user's crime report successfully.
		assertTrue(editRecord.UpdateCrimeReport("alp","akar","23657984216","12061985","Istanbul","robbery","stole clothes from a store.","3"));
		
		//we expect false but actual value is true.
		assertFalse(editRecord.UpdateCrimeReport("alp","akar","23657984216","12061985","Istanbul","robbery","stole clothes from a store.","3"));
		
		//actual value is true and we expect it to be true as well.
		assertTrue(editRecord.InsertCrimeReport("mert","demir","36562365193","06121999","Edirne","damage to public property", " dat","6"));
		
		//actual value is true but we expect false.
		assertFalse(editRecord.InsertCrimeReport("kerem","gulsoy","98563145786","28061967","Edirne","damage to public property", "make graffiti on the wall","6"));
	
	}
	public void editControlForAdmin() throws SQLException {
		
		assertNotNull(admin.getConnection()); // It works when admin is connected to the database.
		assertTrue(admin.showTableData()); // It works when admin can show the database table's data.
		assertFalse(admin.showTableData()); // we are expecting false for showing the table data, but actual value is true.
		assertFalse(admin.DeleteCrimeReport("2")); // Returns false but we expect it return false, too.
		assertTrue(admin.DeleteCrimeReport("3")); // it works when a specified id exists in database.
		assertFalse(admin.DeleteCrimeReport("4")); // we are expecting false but it returns true.
		assertTrue(admin.DeleteCrimeReport("5")); // return failure because there is no such a report id in database.
	}
	
	

}
