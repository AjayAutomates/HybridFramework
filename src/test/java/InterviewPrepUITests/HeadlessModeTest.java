package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeadlessModeTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        // Headless execution (CI/CD friendly)
        options.addArguments("--headless=new");

        // Incognito mode
        options.addArguments("--incognito");

        // Disable notifications
        options.addArguments("--disable-notifications");

        // Disable extensions
        options.addArguments("--disable-extensions");

        // Start maximized (no effect in headless but safe)
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginSelectProductAndAddToCart() {

        // Login
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();

        // Wait until product is visible
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")));

        // Click on product
        driver.findElement(By.xpath(
                "//div[contains(text(),'Sauce Labs Backpack')]"))
              .click();

        // Add product to cart
        wait.until(ExpectedConditions
                .elementToBeClickable(By.id("add-to-cart")))
              .click();
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}