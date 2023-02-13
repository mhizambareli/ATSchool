package lesson4.ru.pflb.vehicles;

import lesson4.ru.pflb.details.Engine;
import lesson4.ru.pflb.professions.Driver;

import static lesson4.ru.pflb.vehicles.VehicleClass.*;

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
    private int loadingAmount;

    public int getLoadingAmount() {
        return loadingAmount;
    }

    public void setLoadingAmount(int loadingAmount) {
        this.loadingAmount = loadingAmount;
    }

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
        super(model, weight, driver, engine);
        this.loadingAmount = loadingAmount;
        if (loadingAmount < 7000) {
            setVehicleClass(MEDIUM);
        } else {
            setVehicleClass(LARGE);
        }
    }

    @Override
    public String toString() {
        return "Модель: " + getModel() + ", класс: " + getVehicleClass()
                + "\nХарактеристики:"
                + "\nвес: " + getWeight() + " килограмм"
                + "\nгрузоподъёмность: " + loadingAmount + " килограмм"
                + "\nдвигатель: " + getEngine().toString()
                + "\nВодитель:\n" + getDriver().toString() + "\n";
    }
}
