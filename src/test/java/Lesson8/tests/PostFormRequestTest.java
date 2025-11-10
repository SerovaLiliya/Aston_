package Lesson8.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostFormRequestTest {
    @Test
    void testPostFormRequest() {
        Response response =
                given()
                        .baseUri("https://postman-echo.com")
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("foo1", "bar1")
                        .formParam("foo2", "bar2")
                        .when()
                        .post("/post")
                        .then()
                        .statusCode(200)
                        .body("form.foo1", equalTo("bar1"))
                        .body("form.foo2", equalTo("bar2"))
                        .extract().response();
        System.out.println(response.prettyPrint());
    }

}
