package lesson4.ru.pflb.vehicles;

import lesson4.ru.pflb.details.Engine;
import lesson4.ru.pflb.professions.Driver;

import static lesson4.ru.pflb.vehicles.VehicleClass.*;

/**
 * Создать класс SportCar, производный класса Car, в этом же пакете.
 * Класс имеет дополнительный параметр: maxVelocity - максимальная скорость в км/ч
 * Значение vehicleClass устанавливается как SPORTS_CAR.
 * Метод toString надо переопределить.
 * К выводу в характеристики добавляется максимальная скорость.
 */
public class SportCar extends Car {
    int maxVelocity;

    /**
     * Конструктор класса SportCar
     *
     * @param model       - модель спорткара
     * @param weight      - вес спорткара в кг
     * @param driver      - водитель
     * @param engine      - двигатель
     * @param maxVelocity - максимальная скорость в км/ч
     * Класс vehicleClass для спорткара всегда = SPORTS_CAR
     */
    public SportCar(String model, int weight, Driver driver, Engine engine, int maxVelocity) {
        this.model = model;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
        this.maxVelocity = maxVelocity;
        this.vehicleClass = SPORTS_CAR;
    }

    @Override
    public String toString() {
        return "Модель: " + model + ", класс: " + vehicleClass
                + "\nХарактеристики:"
                + "\nвес: " + weight + " килограмм"
                + "\nмаксимальная скорость: " + maxVelocity + " км/ч"
                + "\nдвигатель: " + engine.toString()
                + "\nВодитель:\n" + driver.toString() + "\n";
    }
}
