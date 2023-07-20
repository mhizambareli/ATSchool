package homework12_2.part1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    static DirectorRepositoryImpl directors = new DirectorRepositoryImpl();

    @BeforeAll
    static void setup() {
        directors.prepareDB();
    }

    @Test
    void getDirectorTest() {
        //directors.prepareDB();
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
}
