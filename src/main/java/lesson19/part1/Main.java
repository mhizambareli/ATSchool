package lesson19.part1;

import lesson19.part1.fruits.Banana;
import lesson19.part1.fruits.Fruit;
import lesson19.part1.fruits.Apple;
import lesson19.part1.vegetables.Cucumber;
import lesson19.part1.vegetables.Tomato;
import lesson19.part1.vegetables.Vegetable;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Задание 7.9.1
 * Создать общий родительский интерфейс для овощей и фруктов Plant.
 * Создать ArrayList plants и заполнить его экземплярами фруктов и овощей всех видов по 1 штуке каждого (!в 1 ArrayList).
 * Создать ArrayList, который принимает только фрукты, назвать multifruit. Заполнить multifruit только фруктами из plants, используя streamAPI. Один только stream, никаких циклов, вторых stream открывать не надо.
 * Вывести на экран названия фруктов.
 */
public class Main {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Vegetable tomato = new Tomato();
        Vegetable cucumber = new Cucumber();

        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(apple);
        plants.add(banana);
        plants.add(tomato);
        plants.add(cucumber);

        // Создаем ArrayList multifruit, который принимает только фрукты
        ArrayList<Fruit> multifruit = plants.stream()
                .filter(plant -> plant instanceof Fruit) //фильтруем фрукты
                .map(plant -> (Fruit) plant) //явное преобразование в Fruit
                .collect(Collectors.toCollection(ArrayList::new));

        // Выводим на экран названия фруктов из multifruit перебором forEach
        multifruit.forEach(fruit -> System.out.println(fruit.getName()));
    }
}
