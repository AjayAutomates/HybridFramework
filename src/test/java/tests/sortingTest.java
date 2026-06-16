package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageobjects.LoginPage;
import utils.ExcelUtil;

public class sortingTest extends BaseTest {
	
	@Test (priority=0)
    public void loginTest() {
    	test = extent.createTest("Sauce Labs Login Test1");
        log.info("Starting Sauce Labs Login Test");
        // Read username, password from Excel
        String username = ExcelUtil.getCellData("Sheet1", 1, 0);
        String password = ExcelUtil.getCellData("Sheet1", 1, 1);
        LoginPage login = new LoginPage(driver);
        log.info("Entering username");
        login.enterUsername(username);
        log.info("Entering password");
        login.enterPassword(password);
        log.info("Clicking login button");
        login.clickLogin();
        // Validation
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        test.pass("Login successful");
        log.info("Login successful");
    }

	@Test
	public void verifySortByPriceLowToHigh() {

	    test = extent.createTest("Verify Sort By Price Low to High");
	    // Step 1: Select dropdown
	    WebElement dropdown = driver.findElement(By.className("product_sort_container"));
	    Select select = new Select(dropdown);
	    select.selectByVisibleText("Price (low to high)");
	    
	    // Step 2: Get all price elements
	    List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
	    // Step 3: Store prices using for loop
	    List<Double> actualPrices = new ArrayList<>();

	    for (int i = 0; i < priceElements.size(); i++) {
	        String priceText = priceElements.get(i).getText();   // "$29.99"
	        priceText = priceText.replace("$", "");              // "29.99"
	        double price = Double.parseDouble(priceText);        // 29.99
	        actualPrices.add(price);
	    }
	    //actualPrices-> [7.99, 9.99, 15.99]
	    //sortedPrices->  [7.99, 9.99, 15.99]     
	    
	    // Step 4: Sort copy list
	    List<Double> sortedPrices = new ArrayList<>(actualPrices);
	    Collections.sort(sortedPrices);

	    // Step 5: Compare
	    Assert.assertEquals(actualPrices, sortedPrices, "Prices are NOT sorted low to high");
	    test.pass("Products sorted correctly (Low to High)");
	}
}