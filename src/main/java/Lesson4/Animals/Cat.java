package Lesson4.Animals;

public class Cat extends Animal {
    static String food = "кошачий корм";
    static int foodCounter = 10;
    static int counter = 0;

    //Конструктор
    public Cat(String name, String location, HealthState health) {
        this.name = name;
        this.location = location;
        this.health = health;
        this.counter++;
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу\n");
    }

    @Override
    public void eat() {
        if (foodCounter < 1) {
            System.out.println(name + " не может поесть, корма не осталось:(\n");
        }
        else {
            System.out.println(name + " ест " + food);
            foodCounter--;
            System.out.println("В запасе осталось " + foodCounter + " упаковок кошачьего корма\n");
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
