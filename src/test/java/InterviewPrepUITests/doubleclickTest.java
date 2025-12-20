package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class doubleclickTest {

	WebDriver driver;

	@BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
    }

    @Test
    public void checkBoxSelectionTest() throws InterruptedException {
        // Locate the Double Click button
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        // Create Actions instance
        Actions actions = new Actions(driver);
        // Perform double-click action
        actions.doubleClick(doubleClickBtn).perform();
        // Verify result message
        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        System.out.println("Message after double click: " + message.getText());     
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


