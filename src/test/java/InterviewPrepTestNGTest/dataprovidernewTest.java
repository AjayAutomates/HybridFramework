package InterviewPrepTestNGTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataprovidernewTest {
	
	WebDriver driver;

	@Test (dataProvider = "loginData")
	public void login(String username, String password)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();   
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		WebElement loginBtn =driver.findElement(By.id("login-button"));
		loginBtn.click();
		System.out.println("Logged into app successfully");
		
	}
	//two values
	@DataProvider(name= "login")
	public Object[][] getdata(){
		return new Object[][] {
			{"standard_user", "secret_sauce"},//first test run
			{"locked_out_user", "secret_sauce"},//second test run
			{"problem_user", "secret_sauce"}//third test run
		};
	}

}
