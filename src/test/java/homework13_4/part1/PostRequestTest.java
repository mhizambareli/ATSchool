package homework13_4.part1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Напишите тест, в котором отправляется запрос
 * POST на httpbin.org/anything с телом запроса:
 * {
 * "parameter": "value"
 * }
 * Проверяется, что вернулся ответ с кодом 200,
 * а в ответном json'е объект "json" с переданным в теле параметром.
 */

public class PostRequestTest {
    @Test
    @Tag("13.4.1")
    @Tag("POST")
    public void testPostRequestWithJsonBody() {
        RestAssured.baseURI = "https://httpbin.org";

        given()
                .body("{\"parameter\":\"value\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/anything")
                .then()
                .statusCode(200)
                .body("json.parameter", equalTo("value"));
    }
}
