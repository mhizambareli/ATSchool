package homework12_2.part2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    static DirectorRepositoryImpl directors = new DirectorRepositoryImpl();
    static MovieRepositoryImpl movies = new MovieRepositoryImpl();

    @BeforeAll
    static void setup() {
        directors.prepareDB();
        movies.prepareDB();
    }

    @Test
    void getDirectorTest() {
        Director actual = directors.get(3);
        assertAll(
                () -> assertEquals("Иван", actual.getFirst_name()),
                () -> assertEquals("Иванов", actual.getLast_name()),
                () -> assertEquals(Date.valueOf("1999-05-11"), actual.getBirth_date()),
                () -> assertEquals("Россия", actual.getCountry())
        );
        System.out.println("Режиссёр был успешно получен.");
    }

    @Test
    void saveDirectorTest() {
        Director directorToSave = new Director(4, "Алексей", "Стрельцов", Date.valueOf("1963-01-10"), "Украина");
        directors.save(directorToSave);

        Director actualInDB = directors.get(directorToSave.getId());

        assertAll(
                () -> assertEquals(directorToSave.getId(), actualInDB.getId()),
                () -> assertEquals(directorToSave.getFirst_name(), actualInDB.getFirst_name()),
                () -> assertEquals(directorToSave.getLast_name(), actualInDB.getLast_name()),
                () -> assertEquals(directorToSave.getBirth_date(), actualInDB.getBirth_date()),
                () -> assertEquals(directorToSave.getCountry(), actualInDB.getCountry())
        );
    }

    @Test
    void deleteDirectorTest() {
        Director directorToDelete = new Director(4, "Алексей", "Стрельцов", Date.valueOf("1963-01-10"), "Украина");
        directors.delete(directorToDelete);

        assertNull(directors.get(4));
    }

    @Test
    void getListOfDirectorsByGenre() {
        List<String> genres = new ArrayList<>();
        List<Director> actualList = directors.get(genres);

        assertTrue(actualList.isEmpty());

        genres.add("Фэнтази");
        genres.add("Мелодрама");
        actualList = directors.get(genres);

        assertNotNull(actualList);

        for (Director director : actualList) {
            assertTrue(directors.hasGenre(director, "Фэнтази") || directors.hasGenre(director, "Мелодрама"));
        }
    }

    @Test
    void getMovieTest() {
        Movie actual = movies.get(2);

        assertAll(
                () -> assertEquals("Космическая одиссея", actual.getTitle()),
                () -> assertEquals("Фэнтази", actual.getGenre()),
                () -> assertEquals(Date.valueOf("2014-07-05"), actual.getRelease()),
                () -> assertEquals(3, actual.getDirectorId())
        );
        System.out.println("Фильм был успешно получен.");
    }

    @Test
    void saveMovieTest() {
        Movie movieToSave = new Movie(5, "Счастливы вместе", "Боевик", Date.valueOf("1963-01-10"), 2);
        movies.save(movieToSave);

        Movie actualInDB = movies.get(5);

        assertAll(
                () -> assertEquals(movieToSave.getId(), actualInDB.getId()),
                () -> assertEquals(movieToSave.getTitle(), actualInDB.getTitle()),
                () -> assertEquals(movieToSave.getGenre(), actualInDB.getGenre()),
                () -> assertEquals(movieToSave.getRelease(), actualInDB.getRelease()),
                () -> assertEquals(movieToSave.getDirectorId(), actualInDB.getDirectorId())
        );
    }

    @Test
    void deleteMovieTest() {
        Movie movieToDelete = new Movie(5, "Счастливы вместе", "Боевик", Date.valueOf("1963-01-10"), 2);
        movies.delete(movieToDelete);

        assertNull(movies.get(5));
        System.out.println("Фильм успешно удалён");
    }

    @Test
    void getListOfMoviesByDirector() {
        Director directorForSearch = directors.get(1);
        List<Movie> actualList = movies.get(directorForSearch);
        for (Movie movie : actualList) {
            assertEquals(movie.getDirectorId(), directorForSearch.getId());
        }
    }
}
