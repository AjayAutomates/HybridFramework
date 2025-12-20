package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrolltoElement {
	 WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("https://www.saucedemo.com/");
	    }

	    @Test
	    public void scrollToOnesieProduct() throws InterruptedException {

	        // 1️⃣ Login
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();

	        // 2️⃣ Locate Sauce Labs Onesie product
	        WebElement onesieProduct = driver.findElement(
	                By.xpath("//div[text()='Sauce Labs Onesie']"));

	        // 3️⃣ Scroll to the product using JavaScriptExecutor
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView(true);", onesieProduct);

	        // Optional: highlight or click
	        Thread.sleep(1000); // just to visually verify scrolling
	        onesieProduct.click();
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
}