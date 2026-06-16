package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;

public class crosswordsiteTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.crossword.in/");
    }

    @Test(priority = 1,enabled=true,description="search for the text manifest")
    public void searchBook() throws InterruptedException {

        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("manifest");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("manifest"));
    }

    @Test(priority = 2,enabled=true,description="sort By LowToHigh")
    public void sortByLowToHigh() throws InterruptedException {

        WebElement sortDropdown = driver.findElement(By.className("wizzy-common-select-selector"));
        sortDropdown.click();
        WebElement sortOption = driver.findElement(
        	    By.xpath("//div[normalize-space()='Price: Low to High']")
        	);
        sortOption.click();
        Thread.sleep(5000);
        List<WebElement> priceElements =
                driver.findElements(By.xpath("//p[@class='product-item-original-price']"));
        List<Double> actualPrices = new ArrayList<>();
     // NORMAL FOR LOOP
     for (int i = 0; i < priceElements.size(); i++) {
         String text = priceElements.get(i).getText();

         text = text.replace("₹", "").replace(",", "").trim();

         actualPrices.add(Double.parseDouble(text));
     }
     List<Double> sortedPrices = new ArrayList<>(actualPrices);
     Collections.sort(sortedPrices);
     Assert.assertEquals(actualPrices, sortedPrices);
    }

    @Test(priority = 4,enabled=false)
    public void validateScrollAndItems() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        int previousHeight = 0;

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);

            int newHeight = (int) js.executeScript("return document.body.scrollHeight");

            if (newHeight == previousHeight)
                break;

            previousHeight = newHeight;
        }

        List<WebElement> priceElements =
                driver.findElements(By.xpath("//span[@class='price']"));

        System.out.println("Total Items: " + priceElements.size());

        Assert.assertTrue(priceElements.size() >= 30);

        List<Double> actualPrices = new ArrayList<>();

        // NORMAL FOR LOOP
        for (int i = 0; i < priceElements.size(); i++) {
            String text = priceElements.get(i).getText()
                    .replace("₹", "")
                    .replace(",", "")
                    .trim();

            actualPrices.add(Double.parseDouble(text));
        }

        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(actualPrices, sortedPrices, "Scroll list NOT sorted");
    }

    // ------------------- TEST 5 -------------------
    @Test(priority = 5,enabled=false)
    public void applyPriceFilter() throws InterruptedException {

        WebElement min = driver.findElement(By.xpath("//input[@placeholder='Min']"));
        WebElement max = driver.findElement(By.xpath("//input[@placeholder='Max']"));

        min.clear();
        min.sendKeys("600");

        max.clear();
        max.sendKeys("900");
        max.sendKeys(Keys.ENTER);

        Thread.sleep(4000);

        List<WebElement> priceElements =
                driver.findElements(By.xpath("//span[@class='price']"));

        // NORMAL FOR LOOP
        for (int i = 0; i < priceElements.size(); i++) {

            String text = priceElements.get(i).getText()
                    .replace("₹", "")
                    .replace(",", "")
                    .trim();

            double price = Double.parseDouble(text);

            Assert.assertTrue(price >= 600 && price <= 900,
                    "Price out of range: " + price);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}