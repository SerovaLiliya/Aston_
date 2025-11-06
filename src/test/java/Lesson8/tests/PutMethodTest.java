package Lesson8.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutMethodTest {
    @Test
    void testPutRequest() {
        String body = "{ \"update\": true }";
        Response response = given ()
                .baseUri("https://postman-echo.com")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.update", equalTo(true))
                .extract().response();
        System.out.println(response.prettyPrint());
    }
}

