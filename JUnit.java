package test;

public class JUnit {

	public int factorial(int a){
		  int i,fact=1;  
		 for(i=1;i<=a;i++){    
		      fact=fact*i;    
		  }    		
		return fact;
	}
	
	public int sumOdds(int b){
		int result=0;	
		for(int i=1;i<=b;i++){    
		      if(i%2!=0){
		    	  result+=i;
		      }
		  }   
	return result;
	}
	public String concateText(String c,String d){
		c = c.concat(d+"testingisgood"); 
		return c;
	}
	
	
	
}
