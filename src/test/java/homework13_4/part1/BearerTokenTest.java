package homework13_4.part1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * Напишите тест, в котором отправляется запрос
 * GET httpbin.org/bearer с авторизацией по токену
 * (в данном случае токен может быть некорректным, например, 123)
 * и проверяется, что вернулся ответ с кодом 200.
 * (см. github.com/rest-assured/rest-assured/wiki/Usage#oauth-2 или
 * swagger.io/docs/specification/authentication/bearer-authentication/)
 */

public class BearerTokenTest {
    @Test
    @Tag("13.4.1")
    @Tag("Bearer")
    public void testBearerTokenAuth() {
        RestAssured.baseURI = "https://httpbin.org";
        String token = "123";

        given()
                .auth().oauth2(token)
                .when()
                .get("/bearer")
                .then()
                .statusCode(200);
    }
}
