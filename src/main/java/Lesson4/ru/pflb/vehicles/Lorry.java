package Lesson4.ru.pflb.vehicles;

import Lesson4.ru.pflb.details.Engine;
import Lesson4.ru.pflb.professions.Driver;

import static Lesson4.ru.pflb.vehicles.VehicleClass.*;

/**
 * Создать класс Lorry (грузовик), производный класса Car,
 * в этом же пакете.
 * Класс имеет дополнительный параметр:
 * loadingAmount - грузоподъемность в киллограммах
 * Значение vehicleClass устанавливается как MEDIUM или LARGE.
 * Метод toString надо переопределить.
 * К выводу в характеристики добавляется грузоподъемность.
 */
public class Lorry extends Car {
    int loadingAmount;

    /**
     * Конструктор класса Lorry
     *
     * @param model         - модель грузовика
     * @param weight        - вес грузовика в кг
     * @param driver        - водитель грузовика
     * @param engine        - двигатель грузовика
     * @param loadingAmount - грузоподъёмность
     * Класс грузовика vehicleClass определяется на основании loadingAmount
     */
    public Lorry(String model, int weight, Driver driver, Engine engine, int loadingAmount) {
        this.model = model;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
        this.loadingAmount = loadingAmount;
        if (loadingAmount < 7000) {
            this.vehicleClass = MEDIUM;
        } else {
            this.vehicleClass = LARGE;
        }
    }

    @Override
    public String toString() {
        return "Модель: " + model + ", класс: " + vehicleClass
                + "\nХарактеристики:"
                + "\nвес: " + weight + " килограмм"
                + "\nгрузоподъёмность: " + loadingAmount + " килограмм"
                + "\nдвигатель: " + engine.toString()
                + "\nВодитель:\n" + driver.toString() + "\n";
    }
}
