package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class headlessexecutionTest {
	@Test
	public void headlesstest() {
		
		 	ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless=new");       // Headless mode (latest)
	        options.addArguments("--window-size=1920,1080");
	        WebDriver driver = new ChromeDriver(options);
	        driver.get("https://www.google.com");
	        System.out.println("Page Title is: " + driver.getTitle());
	        driver.quit();
		
	}

}
