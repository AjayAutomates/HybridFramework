package InterviewPrepTestNGTest;

import org.testng.annotations.Test;

public class multipletestswithoutpriority {
	
	@Test(enabled=true)
	public void login3()
	
	{
		System.out.println("I am login 3");
	}
	
	@Test(enabled=true)
	public void login2()
	{
		System.out.println("I am login 2");
	}
	
	@Test(enabled=true)
	public void login1()
	{
		System.out.println("I am login 1");
	}

}
