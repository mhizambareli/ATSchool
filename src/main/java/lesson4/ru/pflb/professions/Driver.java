package lesson4.ru.pflb.professions;

import lesson4.ru.pflb.Person;


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
    private int drivingExperience;
    private String licenseId;

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    /**
     * Конструктор для Driver
     *
     * @param name              - имя водителя
     * @param age               - возраст водителя в целых годах
     * @param drivingExperience - опыт вождения водителя в целых годах
     * @param licenseId         - номер водительского удостоверения
     */
    public Driver(String name, int age, int drivingExperience, String licenseId) {
        setName(name);
        setAge(age);
        this.drivingExperience = drivingExperience;
        this.licenseId = licenseId;
    }

    @Override
    public String toString() {
        return getName() + " - возраст: " + getAge()
                + "\nстаж: " + drivingExperience
                + "\n№ удостоверения: " + licenseId;
    }
}
