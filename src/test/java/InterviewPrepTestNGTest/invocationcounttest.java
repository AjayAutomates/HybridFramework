package InterviewPrepTestNGTest;

import org.testng.annotations.Test;

public class invocationcounttest {
	@Test(invocationCount=3)
	public void method1()
	
	{
		System.out.println("run me 3 times");
	}
	
	@Test(enabled=true, invocationCount=10)
	public void method2()
	
	{
		System.out.println("I am disabled");
	}
	

}
