package InterviewPrepUITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchAppSafariTest {
	
	 WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        driver = new SafariDriver();   // Launch Safari
	        driver.get("https://www.saucedemo.com/");
	    }

	    @Test
	    public void verifyPageTitle() {
	        String expectedTitle = "Swag Labs";
	        String actualTitle = driver.getTitle();

	        Assert.assertEquals(actualTitle, expectedTitle,
	                "Page title mismatch!");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}