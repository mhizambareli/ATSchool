package Lesson4.Animals;

public class Horse extends Animal {
    static String food = "фураж";
    static int foodCounter = 1; // кол-во запасов пищи
    static int counter = 0;

    public Horse(String name, String location, HealthState health) {
        this.name = name;
        this.location = location;
        this.health = health;
        this.counter++;
    }

    @Override
    public void makeSound() {
        System.out.println("Игого!\n");
    }

    @Override
    public void eat() {
        if (foodCounter < 1) {
            System.out.println(name + " не может поесть, фуража не осталось:(\n");
        }
        else {
            System.out.println(name + " ест " + food);
            foodCounter--;
            System.out.println("В запасе осталось " + foodCounter + " порций фуража\n");
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
