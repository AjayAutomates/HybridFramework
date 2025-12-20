package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DropdownexpectedOptionsTest {
	
	 WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("https://dmytro-ch21.github.io/"); // Practice site
	    }

	    @Test
	    public void verifyDropdownOptions() {

	        // 1️⃣ Click dropdown to open it
	        driver.findElement(By.id("dropdownMenuButton")).click();

	        // 2️⃣ Capture all options
	        List<WebElement> options = driver.findElements(
	                By.xpath("//div[@class='dropdown-menu show']/a"));

	        List<String> actualOptions = new ArrayList<>();

	        // 3️⃣ Normal for loop to extract text
	        for (int i = 0; i < options.size(); i++) {
	            actualOptions.add(options.get(i).getText());
	        }

	        // 4️⃣ Define expected options
	        List<String> expectedOptions = List.of("Option 1", "Option 2", "Option 3");

	        // 5️⃣ Verify all expected options are present
	        Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options mismatch!");
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}
