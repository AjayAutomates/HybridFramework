package InterviewPrepUITests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLoginTest {
	WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginAndVerifyBackpackProduct() {

        // Login to application
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();

        // Verify "Sauce Labs Backpack" product text is displayed
        		boolean isBackpackDisplayed =
                driver.findElement(By.xpath(
                        "//div[contains(text(),'Sauce Labs Backpack')]"))
                      .isDisplayed();

        Assert.assertTrue(isBackpackDisplayed,
                "'Sauce Labs Backpack' product is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

