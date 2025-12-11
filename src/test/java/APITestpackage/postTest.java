package APITestpackage;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class postTest {
	@Test
	public void postrequestTest() {
	
    RestAssured.baseURI = "https://fakestoreapi.com";
    String requestBody = "{\n" +
            "  \"title\": \"New Product\",\n" +
            "  \"price\": 29.99,\n" +
            "  \"description\": \"A new product for testing\",\n" +
            "  \"category\": \"electronics\",\n" +
            "  \"image\": \"https://i.pravatar.cc\"\n" +
            "}";
    given()
        .header("Content-Type", "application/json")
        .body(requestBody)
    .when()
        .post("/products")
    .then()
        .statusCode(201)
        .body("title", equalTo("New Product"))
        .body("price", equalTo(29.99f))
        .log().all();

}
}