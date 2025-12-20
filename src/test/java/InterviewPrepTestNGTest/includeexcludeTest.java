package InterviewPrepTestNGTest;

import org.testng.annotations.Test;
public class includeexcludeTest {
	    @Test (priority=0, enabled=true)
	    public void Login1() {
	        System.out.println("Executing login1");
	    }
	    
	    @Test (priority=1, enabled=false)
	    public void Login2() {
	        System.out.println("Executing login2");
	    }
	    
	    @Test (priority=2, enabled=true)
	    public void Login3() {
	        System.out.println("No run");
	    }
}
