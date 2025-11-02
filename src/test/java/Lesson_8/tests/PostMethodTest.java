package Lesson_8.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostMethodTest {

    @Test
    void testPostRequest() {
        String requestBody = "{ \"name\": \"John\", \"age\": 30 }";
        Response response = given()
                .baseUri("https://postman-echo.com")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.name", equalTo("John"))
                .body("data.age", equalTo(30))
                .extract().response();
        System.out.println(response.prettyPrint());
    }
}

