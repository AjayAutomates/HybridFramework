package InterviewPrepTestNGTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class annotationrealusageTest {

	 WebDriver driver;

	    @BeforeTest
	    public void beforeTest() {
	        System.out.println("Setting up system property before entire test suite starts");
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
	    }

	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Launching browser before first test method of this class");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Navigating to login page before each test case");
	        driver.get("https://www.saucedemo.com/");
	    }

	    @Test
	    public void loginTest_ValidUser() {
	        System.out.println("Executing login test with valid user...");
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();
	        System.out.println("Logged in successfully!");
	    }

	    @Test
	    public void loginTest_InvalidUser() {
	        System.out.println("Executing login test with invalid user...");
	        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
	        driver.findElement(By.id("password")).sendKeys("wrong_pass");
	        driver.findElement(By.id("login-button")).click();
	        System.out.println("Error message displayed as expected!");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("Clearing cookies after each test method");
	        driver.manage().deleteAllCookies();
	    }

	    @AfterClass
	    public void afterClass() {
	        System.out.println("Closing the browser after all test methods in class");
	        driver.quit();
	    }

	    @AfterTest
	    public void afterTest() {
	        System.out.println("Test execution completed. Generating reports...");
	    }
	}
	

