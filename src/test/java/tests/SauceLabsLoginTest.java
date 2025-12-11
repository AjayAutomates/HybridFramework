package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.LoginPage;
import utils.ExcelUtil;

public class SauceLabsLoginTest extends BaseTest {

    @Test
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
        AssertJUnit.assertEquals(driver.getTitle(), "Swag Labs");
        test.pass("Login successful");
        log.info("Login successful");
    }
}