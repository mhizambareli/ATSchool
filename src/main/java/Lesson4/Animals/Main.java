/**
 * Создайте класс Main со статическим метод main, в котором:
 * - добавьте переменные в классов Dog, Cat, Horse
 * - выведите внутреннию информацию о каждой особи
 * - выведите результат makeSound для каждой особи
 * - вызовите метод eat у некоторых животных
 * - создайте ветеринара и отведите каждого животного на прием
 * - вызовите метод sleep у некоторых животных
 */

package Lesson4.Animals;

import static Lesson4.Animals.HealthState.*;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик", "Россия", UNHEALTHY);
        System.out.println(barsik);
        barsik.makeSound();

        Cat simona = new Cat("Симона", "Беларусь", HEALTHY);
        System.out.println(simona);
        simona.makeSound();

        Dog sharik = new Dog("Шарик", "Литва", HEALTHY);
        System.out.println(sharik);
        sharik.makeSound();

        Dog laska = new Dog("Ласка", "Россия", UNHEALTHY);
        System.out.println(laska);
        laska.makeSound();

        Horse iskra = new Horse("Искра", "Россия", HEALTHY);
        System.out.println(iskra);
        iskra.makeSound();

        Horse burya = new Horse("Буря", "Польша", UNHEALTHY);
        System.out.println(burya);
        burya.makeSound();

        barsik.eat();
        laska.eat();
        burya.eat();
        iskra.eat();


        Vet aibolit = new Vet("Айболит");
        aibolit.treatAnimal(barsik);
        aibolit.treatAnimal(simona);
        aibolit.treatAnimal(sharik);
        aibolit.treatAnimal(laska);
        aibolit.treatAnimal(iskra);
        aibolit.treatAnimal(burya);


        simona.sleep();
        iskra.sleep();
        sharik.sleep();
    }
}
