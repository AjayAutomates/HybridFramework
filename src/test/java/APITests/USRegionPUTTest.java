package APITests;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class USRegionPUTTest {
	
	@Test
    public void updateProduct() {

        RestAssured.baseURI = "https://fakestoreapi.com";
        String updateBody = "{\n" +
                "  \"title\": \"Updated Product\",\n" +
                "  \"price\": 59.99,\n" +
                "  \"description\": \"Updated product description\",\n" +
                "  \"category\": \"electronics\",\n" +
                "  \"image\": \"https://i.pravatar.cc\"\n" +
                "}";
        given()
            .header("Content-Type", "application/json")
            .pathParam("id", 1)   // Update product with id=1
            .body(updateBody)
        .when()
            .put("/products/{id}")
        .then()
            .statusCode(200)
            .body("title", equalTo("Updated Product"))
            .body("price", equalTo(59.99f))
            .log().all();
    }
}


