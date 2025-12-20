package InterviewPrepUITests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferentLocatorsTest {
	WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void demonstrateDifferentLocators() {

        // ID locator
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        // XPATH locator
        driver.findElement(By.xpath("//input[@id='password']"))
              .sendKeys("secret_sauce");

        // CSS Selector
        driver.findElement(By.cssSelector("#login-button"))
              .click();

        // CLASS NAME locator (Products title)
        driver.findElement(By.className("title"))
              .isDisplayed();

        // LINK TEXT locator (About link - inside menu)
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.linkText("About")).click();

        // Navigate back to demonstrate partial link text
        driver.navigate().back();

        // PARTIAL LINK TEXT locator
        driver.findElement(By.partialLinkText("All Ite")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}