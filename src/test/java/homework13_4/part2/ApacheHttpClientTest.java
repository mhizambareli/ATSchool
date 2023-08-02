package homework13_4.part2;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApacheHttpClientTest {

    private final DummyJsonClient client = new DummyJsonClientImpl();

    @Test
    @Tag("13.4.2")
    public void testGetUser() {
        Response response;
        //Проверим получение вообще всех существующих юзеров + несколько ассертов на поля некоторых объектов
        for (int i = 1; i <= 100; i++) {
            response = client.getUser(i);
            User user = response.parseToUser();
            System.out.println(user.toJson());
            assertEquals(200, response.getStatusCode());
            if (i == 20) {
                assertAll(
                        () -> assertEquals(20, user.getId()),
                        () -> assertEquals("aeatockj", user.getUsername()),
                        () -> assertEquals("szWAG6hc", user.getPassword())
                );
            }
            if (i == 51) {
                assertAll(
                        () -> assertEquals(51, user.getId()),
                        () -> assertEquals("tmullender1e", user.getUsername()),
                        () -> assertEquals("fxJRvUVCFA95", user.getPassword())
                );
            }
        }

        //Проверим несуществующих юзеров
        response = client.getUser(101);
        assertEquals(404, response.getStatusCode());
        System.out.println("Пользователь с ID = 101 не найден");
        response = client.getUser(0);
        assertEquals(404, response.getStatusCode());
        System.out.println("Пользователь с ID = 0 не найден");
    }

    @Test
    @Tag("13.4.2")
    public void testLogin() {
        JsonParser jsonParser = new JsonParser();

        //Проверим логин существующих юзеров
        for (int i = 1; i <= 100; i++) {
            User user = client.getUser(i).parseToUser();
            Response response = client.login(user);
            JsonObject jsonObject = jsonParser.parse(response.getBody()).getAsJsonObject();
            String expectedToken = jsonObject.get("token").getAsString();
            Token token = response.parseToToken();
            assertAll(
                    () -> assertEquals(200, response.getStatusCode()),
                    () -> assertEquals(expectedToken, token.getToken())
            );
            System.out.println("Аутентификация юзера " + i + " прошла успешно");
        }

        //Юзера с неправильным логином и паролем тоже проверим
        User imposter = new User(95, "imposter", "imposter");
        Response response = client.login(imposter);
        assertEquals(400, response.getStatusCode());
        System.out.println("Аутентификация юзера " + imposter.getId() + " не прошла, т.к. указан неверный логин и/или пароль\nлогин: " + imposter.getUsername()
                + "\nпароль: " + imposter.getPassword());

    }

    @Test
    @Tag("13.4.2")
    public void testGetPosts() {
        User user = client.getUser(1).parseToUser();
        Token token = client.login(user).parseToToken();
        Response response = client.getPosts(user, token);
        List<Post> posts = response.parseToPost();
        assertAll(
                () -> assertEquals(200, response.getStatusCode()),
                () -> assertEquals(3, posts.size())
        );

        posts.forEach(post -> {
            assertEquals(1, post.getUserId());
            System.out.printf("ID поста: %s\nНазвание публикации: %s\nID автора: %s\n\n", post.getId(), post.getTitle(), post.getUserId());
        });

        //Посты с несуществующим юзером
        User nonExistent = new User(111111, "abc", "def");
        Response negativeResponse = client.getPosts(nonExistent, token);
        assertEquals(404, negativeResponse.getStatusCode());


        //Проверка на неправильный токен по сути бесполезна, т.к. данному методу, как оказалось, вообще всё равно на токен.
        Token testToken = new Token("");
        Response negativeResponse2 = client.getPosts(user, testToken);
        assertEquals(403, negativeResponse2.getStatusCode(), "Багуля в самом методе https://dummyjson.com/auth/posts/{user.id}. Всегда результат с кодом ответа 200, какой бы токен не вводила.");
    }
}