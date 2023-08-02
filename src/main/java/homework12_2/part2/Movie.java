package homework12_2.part2;

import java.sql.Date;

/**
 * Задание 12.2 часть 2
 * Дана таблица Movies:
 * id        serial (ключ)          // номер записи
 * title     text                   // название фильма
 * genre     text                   // жанр
 * release   date                   // дата выхода
 * director  integer (внешний ключ) // id режиссера из таблицы Directors
 * <p>
 * Добавьте класс Movie, соответствующий записям в таблице Movies.
 * Добавьте интерфейс MovieRepository со следующими методами:
 * -  Movie get(int id)           - находит запись в таблице по номеру
 * -  void save(Movie movie)      - сохраняет запись в таблицу
 * -  void delete(Movie movie)    - удаляет запись в таблице
 * -  List<Movie> get(Director d) - находит все фильмы, снятые режиссером
 * Добавьте класс MovieRepositoryImpl, реализующий интерфейс MovieRepository.  В конструктор класса передается Connection к бд.
 * Добавьте в интерфейс DirectorRepository и его реализацию метода:
 * -  List<Director> get(List<String> genres) - находит список режиссеров, снимающих в указанных жанрах
 * <p>
 * Напишите тесты, проверяющие выполнение методов MovieRepositoryImpl и новый метод в DirectorRepositoryImpl.
 */
public class Movie {
    private int id;
    private String title;
    private String genre;
    private Date release;
    private int directorId;

    public Movie(int id, String title, String genre, Date release, int directorId) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.release = release;
        this.directorId = directorId;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Date getRelease() {
        return release;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }
}
