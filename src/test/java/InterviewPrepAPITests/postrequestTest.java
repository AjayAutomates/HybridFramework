package InterviewPrepAPITests;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class postrequestTest {
	
	@Test
    public void createUserTest() {

        // Base URI
        RestAssured.baseURI = "https://reqres.in";

        // Request Body
        String requestBody = "{\n" +
                "    \"name\": \"Ajay\",\n" +
                "    \"job\": \"QA Engineer\"\n" +
                "}";
        
        //String requestBody = "{\"name\":\"Ajay\",\"job\":\"QA Engineer\"}";

        // API Request
        given()
            .header("Content-Type", "application/json")
            .header("x-api-key", "reqres_dfb885e240a04999a4bc1f4e85a450c7") 
            .body(requestBody)

        .when()
            .post("/api/users")

        .then()
            .log().all()   // prints response in console
            .statusCode(201)
            .body("name", equalTo("Ajay"))
            .body("job", equalTo("QA Engineer"))
            .body("id", notNullValue())
            .body("createdAt", notNullValue());
    }
}
