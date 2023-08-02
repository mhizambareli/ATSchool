package homework12_2.part2;

import java.util.List;

public interface MovieRepository {
    /**
     * Метод находит запись в таблице Movie по номеру
     *
     * @param id номер фильма в таблице
     * @return объект типа Movie, т.е. фильм
     */
    Movie get(int id);

    /**
     * Метод добавляет новую строку в таблицу Movie
     *
     * @param movie объект, который нужно сохранить, добавить в таблицу
     */
    void save(Movie movie);

    /**
     * Метод удаляет запись из таблицы Movie. Удаление производится по id объекта
     *
     * @param movie объект, который нужно удалить из таблицы
     */
    void delete(Movie movie);

    /**
     * Метод находит все фильмы, снятые режиссером
     *
     * @param d режиссёр, по которому производим поиск
     * @return список фильмов
     */
    List<Movie> get(Director d);
}
