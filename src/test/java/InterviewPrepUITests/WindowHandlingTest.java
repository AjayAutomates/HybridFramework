package InterviewPrepUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlingTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
    }

    @Test
    public void handleNewWindow() throws InterruptedException {
        // Click the button to open a new window
        driver.findElement(By.id("windowButton")).click();

        // Get window handles
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();

        String parentWindow = it.next();
        String childWindow = it.next();

        // Switch to new window
        driver.switchTo().window(childWindow);
        System.out.println("Child Window Title: " + driver.getTitle());

        // Close child window
        driver.close();

        // Switch back to parent
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window Title: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
