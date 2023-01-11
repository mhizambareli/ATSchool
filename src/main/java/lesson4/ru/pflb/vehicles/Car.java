package lesson4.ru.pflb.vehicles;

import lesson4.ru.pflb.details.Engine;
import lesson4.ru.pflb.professions.Driver;

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
    private String model;
    private VehicleClass vehicleClass;
    private int weight;
    private Driver driver;
    private Engine engine;

    public String getModel() {
        return model;
    }

    public VehicleClass getVehicleClass() {
        return vehicleClass;
    }

    public int getWeight() {
        return weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVehicleClass(VehicleClass vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

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

    /**
     * Конструктор для унаследованных классов Lorry и SportCar без параметра vehicleClass
     *
     * @param model  - модель автомобиля
     * @param weight - вес авто в кг
     * @param driver - водитель
     * @param engine - двигатель
     */
    public Car(String model, int weight, Driver driver, Engine engine) {
        this.model = model;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }


    public void start() {
        System.out.println("Поехали");
    }

    public void stop() {
        System.out.println("Останавливаемся");
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
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
