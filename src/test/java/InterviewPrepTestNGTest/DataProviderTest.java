package InterviewPrepTestNGTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	WebDriver driver;
	
	@Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        System.out.println("Tested with user: " + username + " | Password: " + password);
        driver.quit();
    }

    @DataProvider(name = "loginData")//declares a dataprovider named logindata
    public Object[][] getData() {
        //Returns a two-dimensional array 
        //(rows and columns) of test data.
        //So, if you have 3 rows of data, your test will run 3 times,
    	 return new Object[][] { //Defines the actual data sets. 
    		 //Each inner array holds one set of arguments for the test method.
    		{"standard_user", "secret_sauce"},//first test run
            {"locked_out_user", "secret_sauce"},//second test run
            {"problem_user", "secret_sauce"}//third test run
        };
    }
}


