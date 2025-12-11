package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //By in Selenium is a built-in class used to locate (find) elements on a webpage.
    //By is the locator (the address of the element).
    //WebElement is the actual element on the page.
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    public void enterUsername(String user){
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }
}
