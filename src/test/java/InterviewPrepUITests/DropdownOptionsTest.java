package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownOptionsTest {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://dmytro-ch21.github.io/"); // real practice site
    }

    @Test
    public void selectOptionFromDropdown() {

        // 1️⃣ Click the dropdown to open it
        driver.findElement(By.id("dropdownMenuButton")).click();

        // 2️⃣ Capture all dropdown options
        List<WebElement> options = driver.findElements(
                By.xpath("//div[@class='dropdown-menu show']/a"));

        // 3️⃣ Normal for loop to select the required option
        for (int i = 0; i < options.size(); i++) {
            String text = options.get(i).getText();
            if (text.equalsIgnoreCase("Option 2")) {
                options.get(i).click();
                System.out.println("Selected option: " + text);
                break;
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
