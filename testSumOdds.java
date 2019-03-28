package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class testSumOdds {
	
	JUnit tobetested = new JUnit();
	int sum;
	
	
	   @Test
	   public void test3() {
		  sum=tobetested.sumOdds(7);			
	      assertEquals(16, sum);
	   }
	   @Test
	   public void test4() { 
	     sum=tobetested.sumOdds(6);
	     assertNotSame(7, sum);
	   }
}
