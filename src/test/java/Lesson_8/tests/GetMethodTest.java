package Lesson_8.tests;

import Lesson_8.Base.BaseTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetMethodTest extends BaseTest {

    @Test
    void testGetMethod() {
        given()
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/get"))
                .body("args", notNullValue())
                .body("headers", notNullValue());
    }
}
