package homework13_4.part2;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class DummyJsonClientImpl implements DummyJsonClient {

    private static final String BASE_URL = "https://dummyjson.com";
    private final CloseableHttpClient httpClient;

    public DummyJsonClientImpl() {
        this.httpClient = HttpClients.createDefault();
    }


    @Override
    public Response getUser(int id) {
        Response result;
        try {
            HttpGet httpGet = new HttpGet(BASE_URL + "/users/" + id);
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String body = EntityUtils.toString(httpEntity);
            result = new Response(httpResponse.getCode(), body);
            httpResponse.close();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Response login(User user) {
        Response result;
        try {
            HttpPost httpPost = new HttpPost(BASE_URL + "/auth/login");
            httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            httpPost.setEntity(new StringEntity(user.toJson()));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String body = EntityUtils.toString(httpEntity);
            result = new Response(httpResponse.getCode(), body);
            httpResponse.close();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Response getPosts(User user, Token token) {
        Response result;

        try {
            HttpGet httpGet = new HttpGet(BASE_URL + "/auth/posts/user/" + user.getId());
            httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token.getToken());
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String body = EntityUtils.toString(httpEntity);
            result = new Response(httpResponse.getCode(), body);
            httpResponse.close();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}




