package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class brokenlinksTest {
	 WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("https://www.amazon.in/");
	    }

	    @Test
	    public void verifyBrokenLinks() {

	        // Get all anchor tags
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        System.out.println("Total links found: " + links.size());

	        for (WebElement link : links) {

	            String url = link.getAttribute("href");

	            // Skip empty or javascript links
	            if (url == null || url.isEmpty() || url.startsWith("javascript")) {
	                continue;
	            }

	            try {
	                HttpURLConnection connection =
	                        (HttpURLConnection) new URL(url).openConnection();

	                connection.setConnectTimeout(5000);
	                connection.connect();

	                int responseCode = connection.getResponseCode();

	                if (responseCode >= 400) {
	                    System.out.println("Broken Link: " + url +
	                            " | Response Code: " + responseCode);
	                } else {
	                    System.out.println("Valid Link: " + url +
	                            " | Response Code: " + responseCode);
	                }

	            } catch (Exception e) {
	                System.out.println("⚠️ Exception for URL: " + url);
	            }
	        }
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	    
}