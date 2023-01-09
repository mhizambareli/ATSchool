package Lesson4.ru.pflb.vehicles;

import Lesson4.ru.pflb.details.Engine;
import Lesson4.ru.pflb.professions.Driver;

/**
 * Создать класс Car в пакете ru.pflb.vehicles
 * Класс содержит поля:
 * model - название модели автомобиля
 * vehicleClass - класc автомобиля типа vehicleClass
 * weight - вес автомобиля в килограммах
 * driver - водитель, за которым закреплен автомобиль
 * engine - тип мотора типа Engine
 * Класс содержит методы:
 * - start         - вывод строку "Поехали"
 * - stop()        - выводит строку "Останавливаемся"
 * - turnRight()   - выводит строку "Поворот направо"
 * - turnLeft()    - выводит строку "Поворот налево"
 * - toString      - возвращает строку со всей информацией
 * Формат вывода:
 * Модель: <model>, класс: <vehicleClass>
 * Характеристики:
 * вес: <weight>
 * двигатель: <вывод информации по engine>
 * Водитель: <вывод информации по driver>
 */

public class Car {
    String model;
    VehicleClass vehicleClass;
    int weight;
    Driver driver;
    Engine engine;

    /**
     * Конструктор класса Car
     *
     * @param model        - модель автомобиля
     * @param weight       - вес авто в кг
     * @param vehicleClass - класс авто
     * @param driver       - водитель
     * @param engine       - двигатель
     */
    public Car(String model, int weight, VehicleClass vehicleClass, Driver driver, Engine engine) {
        this.model = model;
        this.vehicleClass = vehicleClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public Car() {
        //нужен для создания отличающихся конструкторов в классах-наследниках Lorry и SportCar
        //пока не придумала, как можно иначе реализовать это, можно ли вообще
    }


    public static void start() {
        System.out.println("Поехали");
    }

    public static void stop() {
        System.out.println("Останавливаемся");
    }

    public static void turnRight() {
        System.out.println("Поворот направо");
    }

    public static void turnLeft() {
        System.out.println("Поворот налево");
    }

    @Override
    public String toString() {
        return "Модель: " + model + ", класс: " + vehicleClass
                + "\nХарактеристики:"
                + "\nвес: " + weight + " килограмм"
                + "\nдвигатель: " + engine.toString()
                + "\nВодитель:\n" + driver.toString() + "\n";
    }
}
