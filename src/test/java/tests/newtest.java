package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExcelUtil;
public class NewTest {
	
	 public static void main(String[] args) {
		    String username = ExcelUtil.getCellData("Sheet1", 1, 0); //Read value from row 1, column 0
	        String password = ExcelUtil.getCellData("Sheet1", 1, 1); //Read value from row 1, column 1
	       
	        WebDriver driver = new ChromeDriver();

	        driver.get("https://www.saucedemo.com/");
	        driver.manage().window().maximize();

	        // Enter username
	        WebElement uname = driver.findElement(By.id("user-name"));
	        uname.sendKeys(username);

	        // Enter password
	        WebElement pwd = driver.findElement(By.id("password"));
	        pwd.sendKeys(password);
	        
	        

	        // Click login button
	        WebElement loginBtn = driver.findElement(By.id("login-button"));
	        loginBtn.click();

	        // Validate login success
	        String title = driver.getTitle();

	        if(title.contains("Swag Labs")){
	            System.out.println("Login Successful");
	        }else{
	            System.out.println("Login Failed");
	        }

	        driver.quit();
	    }
	}

