package homework12_2.part1;

import java.sql.*;

/**
 * Задание 12.2 часть 1
 * Дана таблица Directors:
 * id         serial (ключ) // номер записи
 * first_name text          // имя
 * last_name  text          // фамилия
 * birth_date  date         // дата рождения
 * country    text          // страна
 * <p>
 * Добавьте класс Director, соответствующий записям в таблице Directors.
 * Добавьте интерфейс DirectorRepository со следующими методами:
 * -  Director get(int id)           - находит запись в таблице по номеру
 * -  void save(Director director)   - сохраняет запись в таблицу
 * -  void delete(Director director) - удаляет запись в таблице
 * Добавьте класс DirectorRepositoryImpl, реализующий интерфейс DirectorRepository.  В конструктор класса передается Connection к бд.
 * <p>
 * Напишите позитивные тесты, проверяющие выполнение методов DirectorRepositoryImpl.
 */
public class Director {

    private int id;
    private String first_name;
    private String last_name;
    private Date birth_date;
    private String country;

    public Director(int id, String first_name, String last_name, Date birth_date, String country) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.country = country;
    }

    public Director() {
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static void main(String[] args) {
        DirectorRepositoryImpl director = new DirectorRepositoryImpl();
        director.get(5);
    }
}
