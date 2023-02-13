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
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String toString();
}
