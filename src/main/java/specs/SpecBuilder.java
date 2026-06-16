package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setContentType(ConfigReader.getProperty("contentType"))
                .build();
    }
}

