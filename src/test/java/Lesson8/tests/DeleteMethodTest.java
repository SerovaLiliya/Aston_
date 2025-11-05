package Lesson8.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteMethodTest {

    @Test
    void testDeleteRequest() {
        Response response = given()
                .baseUri("https://postman-echo.com")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", containsString("/delete"))
                .extract().response();
        System.out.println(response.prettyPrint());
    }
}

