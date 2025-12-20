package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHoverandclickTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void hoverAndClickProduct() {

        // Login
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        // Locate Sauce Labs Backpack product
        WebElement backpack =
                driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));

        // Mouse hover using Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(backpack).click().perform();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}