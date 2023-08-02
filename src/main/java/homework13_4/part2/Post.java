package homework13_4.part2;

/**
 * Класс сообщения пользователя
 */
public class Post {

    private final int id;
    private final String title;
    private final int userId;

    public Post(int id, String title, int userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }
}
