package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iFrameHandlingTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames"); 
    }

    @Test
    public void handleIframe() {
        //Switch to iframe by ID
        driver.switchTo().frame("frame1");

        //Interact with element inside iframe
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        System.out.println("Iframe Heading: " + heading.getText());

        //Switch back to main page
        driver.switchTo().defaultContent();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
