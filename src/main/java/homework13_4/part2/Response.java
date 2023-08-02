package homework13_4.part2;

import com.google.gson.Gson;

import java.util.List;

/**
 * Общий класс ответа
 */
public class Response {

    private final int statusCode;
    private final String body;

    public <T> T parseToObject(Class<T> tClass) {
        Gson gson = new Gson();
        return gson.fromJson(body, tClass);
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
