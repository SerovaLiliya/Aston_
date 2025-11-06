package Lesson8.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchMethodTest {
    @Test
    void testPatchRequest() {
        String body = "{ \"patch\": true }";
        Response response = given ()
                .baseUri("https://postman-echo.com")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.patch", equalTo(true))
                .extract().response();
        System.out.println(response.prettyPrint());
    }
}

