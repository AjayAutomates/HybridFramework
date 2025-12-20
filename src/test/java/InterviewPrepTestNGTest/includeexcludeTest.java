package InterviewPrepTestNGTest;

import org.testng.annotations.Test;
public class includeexcludeTest {
	    @Test (enabled=true)
	    public void ALogin1() {
	        System.out.println("Executing login1");
	    }
	    
	    @Test (enabled=false)
	    public void Login2() {
	        System.out.println("Executing login2");
	    }
	    
	    @Test (enabled=true)
	    public void Login3() {
	        System.out.println("No run");
	    }
}
