package InterviewPrepTestNGTest;

import org.testng.annotations.Test;

public class groupingTest {
	
	@Test(enabled=true, groups= {"smoke","region","pagename"})
	public void login3()
	
	{
		System.out.println("I am login 3");
	}
	
	@Test(enabled=true, groups= {"regression"})
	public void login2()
	{
		System.out.println("I am login 2");
	}
	
	@Test(enabled=true, groups= {"regression"})
	public void login1()
	{
		System.out.println("I am login 1");
	}

}
