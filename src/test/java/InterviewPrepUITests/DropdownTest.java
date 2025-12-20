package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTest {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void handleDropdownTest() throws InterruptedException {
	
	 WebElement dropdownElement = driver.findElement(By.id("dropdown"));
     //Select object creation
     Select dropdown = new Select(dropdownElement); 
     // Select by Value
     dropdown.selectByValue("2");
     System.out.println("Selected by Value: Option 2");
     Thread.sleep(2000);
     
     // Select by Visible Text
    /* dropdown.selectByVisibleText("Option 1");
     System.out.println("Selected by Visible Text: Option 1");
     Thread.sleep(2000);

     // Select by Index (0-based)
     dropdown.selectByIndex(1);
     System.out.println("Selected by Index: Option 1 again");
     Thread.sleep(2000); */

     //Get currently selected option
     String selectedText = dropdown.getFirstSelectedOption().getText();
     System.out.println("Currently selected: " + selectedText);
}
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
