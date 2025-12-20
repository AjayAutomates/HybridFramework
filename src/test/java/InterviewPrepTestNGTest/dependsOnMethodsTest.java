package InterviewPrepTestNGTest;

import org.testng.annotations.Test;

public class dependsOnMethodsTest {
	
	@Test(enabled=true)
	public void login()
	
	{
		System.out.println("Logged in");
	}
	
	@Test(enabled=true, dependsOnMethods="login")
	public void searchproduct()
	{
		System.out.println("I am disabled");
	}
	


}
