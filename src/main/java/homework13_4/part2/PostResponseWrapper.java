package homework13_4.part2;

import java.util.List;

/**
 * Дополнительный класс-обёртка для парса постов из JSON в список постов
 */
public class PostResponseWrapper {
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }
}