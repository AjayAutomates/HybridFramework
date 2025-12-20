package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementPresentinDOMTest {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void verifyElementPresentInDOM() {

        boolean isElementPresent =
                driver.findElements(By.id("login-button")).size() > 0;

        Assert.assertTrue(isElementPresent,
                "Login button is NOT present in DOM");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
