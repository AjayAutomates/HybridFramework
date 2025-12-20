package InterviewPrepUITests;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class pickvaluefromwebTableTest {

	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("https://demoqa.com/webtables");
	    }

	    @Test
	    public void countRowsAndColumns() {
	        // Count rows
	        int rowCount = driver.findElements(By.xpath("//div[@class='rt-tr-group']")).size();
	        System.out.println("Total Rows: " + rowCount);

	        // Count columns
	        int colCount = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']")).size();
	        System.out.println("Total Columns: " + colCount);
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}