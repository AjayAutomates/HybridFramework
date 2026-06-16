package tests;


import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.LoginPage;
import pageobjects.dashboardPage;
import utils.ExcelUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import base.TestListener; //This line only tells Java compiler,This class exists, you can use it
@Listeners(TestListener.class) // Attach this Listener class to this test class, tells testng to execute it
public class dashboardTest extends BaseTest {
	
	dashboardPage  ds;
	
	@BeforeMethod
	public void setupPage() {
		 ds = new dashboardPage(driver);
	}
	 
	 @Test (priority=0)
	    public void loginTest() {
	    	//test = extent.createTest("Sauce Labs Login Test1");
	        //log.info("Starting Sauce Labs Login Test");
	        // Read username, password from Excel
	        String username = ExcelUtil.getCellData("Sheet1", 1, 0);
	        String password = ExcelUtil.getCellData("Sheet1", 1, 1);
	       // dashboardPage ds = new dashboardPage(driver);
	        log.info("Entering username");
	        ds.enterUsername(username);
	        log.info("Entering password");
	        ds.enterPassword(password);
	        log.info("Clicking login button");
	        ds.clickLogin();
	        // Validation
	        Assert.assertEquals(driver.getTitle(), "Swag Labs");
	        test.pass("Login successful");
	        log.info("Login successful");  
	    }

	    @Test(priority=1)
	    public void verifyProductsAreDisplayedOnDashboard() throws InterruptedException {
	    	Thread.sleep(5000);
	        //test = extent.createTest("Verify Products Displayed");
	        List<WebElement> products = driver.findElements(By.className("inventory_item"));
	        Assert.assertTrue(products.size() > 0, "No products found");
	        test.pass("Products are displayed: " + products.size());
	    }

	    @Test(priority=2)
	    public void verifyAddToCartUpdatesCartBadge() throws InterruptedException {
	        //test = extent.createTest("Verify Cart Badge Update");
	        Thread.sleep(5000);
	        ds.addsaucelabsproducttocart();
	        String badge = driver.findElement(By.className("shopping_cart_badge")).getText();
	        Thread.sleep(3000);
	        Assert.assertEquals(badge, "1");
	        test.pass("Cart badge updated correctly");
	    }

	    @Test(priority=3)
	    public void verifyUserNavigatesToProductDetailsPage() throws InterruptedException {
	        //test = extent.createTest("Verify Product Navigation");
	        driver.findElement(By.className("inventory_item_name")).click();
	        Thread.sleep(3000);
	        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item"));
	        test.pass("Navigated to product details page");
	        driver.navigate().back();
	        Thread.sleep(3000);
	    }

	    @Test(priority=4)
	    public void verifyDashboardUIElementsVisibility() {
	        //test = extent.createTest("Verify Dashboard UI Elements");
	        Assert.assertTrue(driver.findElement(By.className("app_logo")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.className("shopping_cart_link")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
	        test.pass("All UI elements are visible");
	    }

	    @Test(priority=5)
	    public void verifyLogoutloginissuccessful() throws InterruptedException {
	        //test = extent.createTest("Verify Logout Functionality");
	        Thread.sleep(3000);
	        driver.findElement(By.id("react-burger-menu-btn")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.id("logout_sidebar_link")).click();
	        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
	        test.pass("Logout successful");
	    }	
}