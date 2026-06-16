package base;
import io.restassured.RestAssured;
import utils.ConfigReader;

import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    @BeforeClass
    public void setup() {
    	RestAssured.baseURI = ConfigReader.getProperty("baseURI");
    	RestAssured.basePath = ConfigReader.getProperty("basePath"); 
    	
    }
}