package homework13_4.part2;

/**
 * Токен, полученный при аутентификации
 */
public class Token {

    private final String token;

    public Token(String value) {
        this.token = value;
    }

    public String getToken() {
        return token;
    }
}