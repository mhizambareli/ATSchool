package Lesson4.Animals;

public class Dog extends Animal {
    static String food = "собачий корм";
    static int foodCounter = 5; // кол-во запасов пищи
    static int counter = 0;

    public Dog(String name, String location, HealthState health) {
        this.name = name;
        this.location = location;
        this.health = health;
        counter++;
    }

    @Override
    public void makeSound() {
        System.out.println("Гав\n");
    }

    @Override
    public void eat() {
        if (foodCounter < 1) {
            System.out.println(name + " не может поесть, корма не осталось:(\n");
        }
        else {
            System.out.println(name + " ест " + food);
            foodCounter--;
            System.out.println("В запасе осталось " + foodCounter + " порций собачьего корма\n");
        }
    }

    @Override
    public String toString() {
        return name
                + "\nСтрана обитания: " + location
                + "\nСостояние здоровья: " + health.getDescription()
                + "\nКоличество особей: " + counter + "\n";
    }
}
