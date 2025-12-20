package InterviewPrepUITests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTest {

	 WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	    	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	    }

	    @Test
	    public void alertverificationTest() throws InterruptedException {
	
	    	//identify webelement for button -> Click for JS Confirm
	    	//click on the button
	    	//driver.switchTo().alert().accept();
	    	//driver.switchTo().alert().dismiss();
	    	//driver.switchTo().alert().getText();
	    	
	    	// Click on "Click for JS Prompt" button
	        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	        // Switch to alert
	        Alert alert = driver.switchTo().alert();
	        // Print alert message
	        System.out.println("Alert Text: " + alert.getText());
	        //alert.sendKeys("Testing");
	        Thread.sleep(5000); // just to visualize
	        // Accept the alert
	        alert.accept();
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}

