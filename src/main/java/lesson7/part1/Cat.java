package lesson7.part1;

/**
 * Создать класс Cat, с свойствами количество лет, цвет глаз, вес и цвет шерсти.
 * Создать максимально возможное количество конструкторов.
 * Не забываем про метод toString() для котов.
 */
public class Cat {
    int age; //количество лет
    String eyeColor; //цвет глаз
    int weight; //вес в килограммах
    String furColor; //цвет шерсти

    static int defaultAge = 1;
    static String defaultEyeColor = "Зелёный";
    static int defaultWeight = 4;
    static String defaultFurColor = "Чёрный";

    /*
    * Создаю 12 конструкторов с разными наборами параметров: от полного набора 4 параметров до отсутствия параметров
    */
    public Cat(int age, String eyeColor, int weight, String furColor) {
        this.age = age;
        this.eyeColor = eyeColor;
        this.weight = weight;
        this.furColor = furColor;
    }

    public Cat(int age, String eyeColor, int weight) {
        this(age, eyeColor, weight, defaultFurColor); //вызов без цвета шерсти, по умолчанию будет чёрный цвет шерсти
    }

    public Cat(int age, String eyeColor, String furColor) {
        this(age, eyeColor, defaultWeight, furColor); //вызов без веса, по умолчанию будет вес 4 кг
    }

    public Cat(int age, int weight, String furColor) {
        this(age, defaultEyeColor, weight, furColor); // вызов без цвета глаз, по умолчанию будет зелёный цвет глаз
    }

    public Cat(String eyeColor, int weight, String furColor) {
        this(defaultAge, eyeColor, weight, furColor); //вызов без возраста, по умолчанию возраст 1 год.
    }

    public Cat(int age, String eyeColor) {
        this(age, eyeColor, defaultWeight);
    }

    public Cat(int age, int weight) {
        this(age, weight, defaultFurColor);
    }

    public Cat(String eyeColor, int weight) {
        this(defaultAge, eyeColor, weight);
    }

    public Cat(String eyeColor, String furColor) {
        this(defaultAge, eyeColor, furColor);
    }

    public Cat(int age) {
        this(age, defaultWeight);
    }

    public Cat(String furColor) {
        this(defaultEyeColor, furColor);
    }

    /*
     *Конструктор без параметров, где будет создан кот с дефолтными параметрами:
     *возраст - 1 год
     *цвет глаз - зелёный
     *вес - 4 кг
     *цвет шерсти - чёрный
     */
    public Cat() {
        this(defaultAge);
    }

    @Override
    public String toString() {
        return "Котик имеет следующие характеристики:"
                + "\nВозраст - " + age + " лет"
                + "\nЦвет глаз - " + eyeColor
                + "\nВес - " + weight + " кг"
                + "\nЦвет шерсти - " + furColor + "\n";
    }
}
