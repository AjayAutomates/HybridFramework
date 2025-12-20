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

public class DragandDropTest {
	
	WebDriver driver;

	@BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    public void draganddropTest() throws InterruptedException {
    	WebElement from= driver.findElement(By.id("column-a"));
        WebElement to= driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        action.dragAndDrop(from, to).perform();
        Thread.sleep(5000);
        }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


