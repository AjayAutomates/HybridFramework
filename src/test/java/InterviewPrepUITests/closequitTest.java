package InterviewPrepUITests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class closequitTest {
	  public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = new ChromeDriver();

	        // Open first website
	        driver.get("https://www.google.com");

	        // Open a new tab/window
	        driver.get("https://www.youtube.com");

	        // 1️⃣ driver.close() -> closes CURRENT window only
	        driver.close();  // YouTube window closes, Google window may still exist

	        // Sleep to observe behavior
	        Thread.sleep(2000);

	        // 2️⃣ driver.quit() -> closes ALL windows and ends WebDriver session
	        driver.quit();
	    }
	}