package APITestpackage;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class getTest {

	@Test
	public void gettestapivalidation() {
		RestAssured.baseURI="https://fakestoreapi.com";
		 given()
         .header("Accept", "application/json")     
         .queryParam("limit", 5)
     .when()
         .get("/products") 
     .then()
         .statusCode(200) 
         .body("size()", equalTo(5))
         .body("[0].title", notNullValue())  
         .log().all();
	}

}
