package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ChromeOptionsTest {

	 WebDriver driver;

	    @BeforeMethod
	    public void setUp() {

	        // 1. ChromeOptions configuration
	        ChromeOptions options = new ChromeOptions();

	        // 2. Disable notifications
	        options.addArguments("--disable-notifications");

	        // 3. Start maximized
	        options.addArguments("--start-maximized");

	        // 4. Disable extensions
	        options.addArguments("--disable-extensions");

	        // 5. Disable infobars
	        options.addArguments("--disable-infobars");

	        // 6. Accept insecure certificates
	        options.setAcceptInsecureCerts(true);

	        // Launch Chrome with options
	        driver = new ChromeDriver(options);
	        driver.get("https://www.saucedemo.com/");
	    }

	    @Test
	    public void loginToSauceDemoTest() {

	        // Login
	        driver.findElement(By.id("user-name"))
	              .sendKeys("standard_user");

	        driver.findElement(By.id("password"))
	              .sendKeys("secret_sauce");

	        driver.findElement(By.id("login-button"))
	              .click();

	        // Verify successful login (Products title)
	        boolean isProductsDisplayed =
	                driver.findElement(By.className("title")).isDisplayed();

	        Assert.assertTrue(isProductsDisplayed,
	                "Login failed - Products page not displayed");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}
