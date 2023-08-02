package homework13_4.part2;

import com.google.gson.Gson;

import java.util.List;

/**
 * Общий класс ответа
 */
public class Response {

    private final int statusCode;
    private final String body;

    public User parseToUser() {
        Gson gson = new Gson();
        User user = gson.fromJson(body, User.class);
        return user;
    }

    public Token parseToToken() {
        Gson gson = new Gson();
        Token token = gson.fromJson(body, Token.class);
        return token;
    }

    public List<Post> parseToPost() {
        Gson gson = new Gson();
        PostResponseWrapper postResponseWrapper = gson.fromJson(body, PostResponseWrapper.class);
        return postResponseWrapper.getPosts();
    }

    public Response(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }
}
