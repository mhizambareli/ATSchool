package homework13_4.part2;

/**
 * Класс пользователя
 */
public class User {

    private final int id;
    private final String username;
    private final String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toJson() {
        return "{\"id\":" + id + ",\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
    }
}
