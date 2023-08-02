package homework13_4.part2;

public interface DummyJsonClient {
    /**
     * Получение информации о пользователе по уникальному id (dummyjson.com/docs/users).
     * На сайте предустановлены пользователи с id от 1 до 100.
     *
     * @param id уникальный идентификатор пользователя
     * @return объект класса Response
     */
    Response getUser(int id);

    /**
     * Аутентификация пользователя по логину и паролю (dummyjson.com/docs/auth).
     * Логин и пароль возвращаются со всей информацией пользователя из предыдущего метода.
     *
     * @param u пользователь, под которым хотим произвести аутентификацию
     * @return объект класса Response
     */
    Response login(User u);

    /**
     * Получение списка сообщений по уникальному id пользователя, используя токен, полученный при аутентификации в методе выше.
     * Токен передается через заголовок "Authorization" (см. swagger.io/docs/specification/authentication/bearer-authentication/).
     *
     * @param u
     * @param token
     * @return
     */
    Response getPosts(User u, Token token);
}
