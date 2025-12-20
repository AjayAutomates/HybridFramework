package InterviewPrepAPITests;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class USRegiongetdata {
	
	 @Test
	    public void getProductsTest() {
	        // Base URI
	        RestAssured.baseURI = "https://fakestoreapi.com";
	        // GET /products with headers and query parameters
	        given()
	            .header("Accept", "application/json")// Request header
	            //Accept header tells the server:“Hey server, I want the response in JSON format.”
	            .queryParam("limit", 5)// Query parameter to get first 5 products
	        .when()
	            .get("/products") // Send GET request to /products
	        .then()
	            .statusCode(200)  // Validate Status Code
	            .body("size()", equalTo(5))   // "size()" → Refers to the size of the JSON array returned by the API.
	            //equalTo(5) → Checks that the array contains exactly 5 items.
	            .body("[0].title", notNullValue())  // Validate first product has a title
	            .log().all();// Logs the entire HTTP response in the console.

}
}