package Lesson4.ru.pflb;

import Lesson4.ru.pflb.details.Engine;
import Lesson4.ru.pflb.professions.Driver;
import Lesson4.ru.pflb.vehicles.Car;
import Lesson4.ru.pflb.vehicles.Lorry;
import Lesson4.ru.pflb.vehicles.SportCar;

import static Lesson4.ru.pflb.vehicles.VehicleClass.*;

/**
 * Создайте класс Main со статическим метод main, в котором:
 * - создаются 3 разных типа автомобиля (Lorry, SportCar, Car)
 * все необходимые для этого объекты
 * также создаются в main и передаются в необходимые конструкторы
 * - вывести всю информацию о созданных машинах и вложенных объектах
 */
public class Main {
    public static void main(String[] args) {
        //Создаём водителей
        Driver simpleCarDriver = new Driver("Дмитрий", 25, 5, "11 11 111111");
        Driver lorryDriver = new Driver("Василий", 45, 26, "22 22 222222");
        Driver sportCarDriver = new Driver("Ирина", 32, 14, "33 33 333333");

        //Создаём двигатели
        Engine simpleCarEngine = new Engine("Renault", 60000);
        Engine lorryEngine = new Engine("КАМАЗ", 250000);
        Engine sportCarEngine = new Engine("BMW", 157000);

        //Созаём объекты автомобилей разных классов
        Car simpleCar = new Car("Renault Logan", 1000, SMALL, simpleCarDriver, simpleCarEngine);
        Lorry lorry1 = new Lorry("КамАЗ-1111", 6500, lorryDriver, lorryEngine, 5500);
        Lorry lorry2 = new Lorry("КамАЗ-2222", 8500, lorryDriver, lorryEngine, 9000);
        SportCar sportCar = new SportCar("BMW i9", 2500, sportCarDriver, sportCarEngine, 250);

        //Выводим информацию по каждому созданному автомобилю
        System.out.println(simpleCar);
        System.out.println(lorry1);
        System.out.println(lorry2);
        System.out.println(sportCar);

        //Пробуем использовать методы движения и остановки из класса Car на объектах класса Car и дочерних классов
        simpleCar.start();
        simpleCar.turnRight();
        simpleCar.stop();

        lorry1.start();
        lorry1.turnLeft();
        lorry1.turnLeft();
        lorry1.stop();

        sportCar.start();
        sportCar.turnLeft();
        sportCar.turnRight();
        sportCar.stop();
    }
}
