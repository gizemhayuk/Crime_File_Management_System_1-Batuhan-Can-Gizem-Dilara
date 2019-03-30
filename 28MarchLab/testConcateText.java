package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class testConcateText {

	JUnit tobetested = new JUnit();
	String conc;
	
	
	   @Test
	   public void test3() {
		  conc=tobetested.concateText("xd","lol");			
	      assertEquals("xdloltestingisgood", conc);
	   }
	   @Test
	   public void test4() { 
	     conc=tobetested.concateText("gizem","denver");
	     assertNotSame("gizemdenvertestingisgoo", conc);
	   }

}
