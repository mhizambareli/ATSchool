package lesson4.animals;

public abstract class Animal {
    String name; // кличка животного
    static String food; // название типа пищи
    static int foodCounter; // кол-во запасов пищи
    String location; // название страны обитания
    static int counter; // все животные имеют внутреннюю связь с сородичами, в переменной содержится общее кол-во осыбей данного вида
    HealthState health; // состояние здоровья животного типа HealthState

    //метод выводит текст, как звучит животное
    public abstract void makeSound();

    //метод выводит текст, что животное ест; уменьшает кол-во еды у животного; также выводит сколько запасов осталось
    public abstract void eat();

    //метод выводит текст, что животное спит
    public void sleep() {
        System.out.println(name + " сейчас спит. Тихо.\n");
    }

    //метод вовзращает в виде строки текущую информацию об особи
    public abstract String toString();
}
