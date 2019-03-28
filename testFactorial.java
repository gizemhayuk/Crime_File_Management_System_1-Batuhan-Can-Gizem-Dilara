package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class testFactorial {

	JUnit tobetested = new JUnit();
	int fact;
	
	
	   @Test
	   public void test1() {
		  fact=tobetested.factorial(7);			
	      assertEquals(5040, fact);
	   }
	   @Test
	   public void test2() { 
	     fact=tobetested.factorial(6);
	     assertNotSame(530, fact);
	   }

	  
}
