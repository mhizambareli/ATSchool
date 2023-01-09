package Lesson4.ru.pflb.professions;

import Lesson4.ru.pflb.Person;


/**
 * Создать класс Driver в пакете ru.pflb.professions, расширяющих класс Person
 * Класс содержит поля:
 * drivingExperience - кол-во целых лет опыта
 * licenseId         - номер водительского удостоверения
 * Метод toString надо переопределить.
 * Формат вывода:
 * <name> - возраст: <age>
 * - стаж: <drivingExperience>
 * - № удостоверения: <licenseId>
 */
public class Driver extends Person {
    int drivingExperience;
    String licenseId;

    /**
     * Конструктор для Driver
     * @param name - имя водителя
     * @param age - возраст водителя в целых годах
     * @param drivingExperience - опыт вождения водителя в целых годах
     * @param licenseId - номер водительского удостоверения
     */
    public Driver(String name, int age, int drivingExperience, String licenseId) {
        this.name = name;
        this.age = age;
        this.drivingExperience = drivingExperience;
        this.licenseId = licenseId;
    }

    @Override
    public String toString() {
        return name + " - возраст: " + age
                + "\nстаж: " + drivingExperience
                + "\n№ удостоверения: " + licenseId;
    }
}
