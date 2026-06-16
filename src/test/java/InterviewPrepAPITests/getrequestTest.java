package InterviewPrepAPITests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import base.ApiBaseTest;
import specs.SpecBuilder;

public class getrequestTest extends ApiBaseTest {

    @Test
    public void getPostById() {

        given()
            .spec(SpecBuilder.getRequestSpec())
            .log().all()
        .when()
            .get()
        .then()
            .log().all()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", notNullValue())
            .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
            .body("body", containsString("quia et suscipit"));
    }
}