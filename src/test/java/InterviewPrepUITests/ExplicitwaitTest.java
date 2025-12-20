package InterviewPrepUITests;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExplicitwaitTest {


    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
    	Map<String, Object> prefs = new HashMap<>();
    	prefs.put("credentials_enable_service", false);
    	prefs.put("profile.password_manager_enabled", false);
    	options.addArguments("--incognito");
    	options.setExperimentalOption("prefs", prefs);
    	driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginAndAddProductToCart() throws InterruptedException {

        // Login
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();
        

     // Explicit wait for popup
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Explicit wait - wait until product is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")));

        // Click on product
        driver.findElement(By.xpath(
                "//div[contains(text(),'Sauce Labs Backpack')]"))
              .click();
        Thread.sleep(5000);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
