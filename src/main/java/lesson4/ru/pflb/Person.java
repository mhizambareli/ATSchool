package lesson4.ru.pflb;

/**
 * Сделать абстрактный класс Person в ru.pflb
 * Класс содержит поля:
 * age  - возраст в годах
 * name - строка с ФИО
 * Класс содержит методы:
 * - toString - возвращает строку с информацией о водителе
 */
public abstract class Person {
    public int age;
    public String name;

    public abstract String toString();
}
