package homework12_2.part2;

public interface DirectorRepository {
    /**
     * Метод находит запись в таблице Directors по id и возвращает объект класса Director
     * @param id номер записи в таблице, по которому хотим осуществить поиск
     * @return объект типа Director с информацией из таблицы, либо null, если ничего не найдено
     */
    Director get(int id);

    /**
     * Метод добавляет новую строку в таблицу
     * @param director объект с информацией, которую нужно внести в таблицу Directors
     */
    void save(Director director);

    /**
     * Метод удаляет информацию из таблицы Directors. Удаление происходит по id объекта.
     * @param director объект, который нужно удалить из таблицы
     */
    void delete(Director director);//удаляет запись в таблице
}
