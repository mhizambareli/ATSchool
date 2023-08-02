package homework13_4.part1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * Напишите тест, в котором отправляется запрос
 * GET httpbin.org/basic-auth/user/password с авторизацией по логину с паролем
 * и проверяется, что вернулся ответ с кодом 200.
 * (см. github.com/rest-assured/rest-assured/wiki/Usage#basic-authentication)
 */
public class BasicAuthTest {
    @Test
    @Tag("13.4.1")
    @Tag("BasicAuth")
    public void testBasicAuth() {
        RestAssured.baseURI = "https://httpbin.org";
        String username = "user";
        String password = "password";

        given()
                .auth().basic(username, password)
                .when()
                .get("/basic-auth/" + username + "/" + password)
                .then()
                .statusCode(200);
    }
}
