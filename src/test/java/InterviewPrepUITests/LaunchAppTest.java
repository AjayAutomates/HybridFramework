package InterviewPrepUITests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchAppTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //In Selenium 4.6 and above, Selenium Manager automatically handles browser driver binaries.
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void verifyPageTitle() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        // Assertion to validate page title
        Assert.assertEquals(actualTitle, expectedTitle,
                "Page title mismatch!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}