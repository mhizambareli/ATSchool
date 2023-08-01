package homework13_4.part1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Напишите тест, в котором отправляется запрос
 * GET на httpbin.org/anything с параметрами p1 = v1 и p2 = v2
 * и проверяется, что вернулся ответ с кодом 200,
 * а в ответном json'е объект args содержит переданные параметры.
 */
public class GetRequestTest {
    @Test
    public void testGetRequestWithParameters() {
        RestAssured.baseURI = "https://httpbin.org";
        String p1 = "v1";
        String p2 = "v2";

        given()
                .param("p1", p1)
                .param("p2", p2)
                .when()
                .get("/anything")
                .then()
                .statusCode(200)
                .body("args.p1", equalTo(p1))
                .body("args.p2", equalTo(p2));
    }
}
