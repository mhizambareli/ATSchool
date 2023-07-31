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
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String country;

    public Director(int id, String firstName, String lastName, Date birthDate, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
    }

    public Director() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
