package lesson18.part3;

import lesson18.part3.fruits.Banana;
import lesson18.part3.fruits.Fruit;
import lesson18.part3.fruits.Apple;
import lesson18.part3.vegetables.Cucumber;
import lesson18.part3.vegetables.Tomato;
import lesson18.part3.vegetables.Vegetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Создать ArrayList plants и заполнить его экземплярами фруктов и овощей всех видов по 1 штуке каждого (!в 1 ArrayList).
 * Создать HashMap и заполнить его фруктами и овощами с помощью forEach(), в ключ записывая название фрукта/овоща, а в значение - само растение.
 * Вывести на экран название растения из карты и рядом с ним имя класса через пробел.
 */
public class Main {

    public static void makeSalad(Basket<? extends Plant> basket) {
        Iterator<? extends Plant> iterator = basket.iterator();
        if (!iterator.hasNext()) {
            System.out.println("Не могу сделать салатик, корзина пуста:(\n");
            return;
        }
        System.out.print("Готовим салатик:\nРежем - ");
        StringBuilder result = new StringBuilder("");
        while (iterator.hasNext()) {
            Plant item = iterator.next();
            result.append(item.getName() + ", ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 2));
        System.out.println(result + "\nУгощайся!\n");
    }

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Vegetable cucumber = new Cucumber();
        Vegetable tomato = new Tomato();
        Fruit apple2 = new Apple();
        Fruit banana2 = new Banana();
        Vegetable cucumber2 = new Cucumber();
        Vegetable tomato2 = new Tomato();

        Basket<Fruit> fruitBasket = new Basket<>();
        Basket<Vegetable> vegetableBasket = new Basket<>();

        fruitBasket.addItem(apple);
        fruitBasket.addItem(banana);
        vegetableBasket.addItem(cucumber);
        vegetableBasket.addItem(tomato);
        fruitBasket.addItem(apple2);
        fruitBasket.addItem(banana2);
        vegetableBasket.addItem(cucumber2);
        vegetableBasket.addItem(tomato2);

        makeSalad(fruitBasket);
        makeSalad(vegetableBasket);

        //Проверка пустой корзины
        fruitBasket.getItems().clear();
        makeSalad(fruitBasket);

        /*
        Всё ещё нерабочие варианты - добавление овощей во фруктовую корзину и фруктов в овощную:
        fruitBasket.addItem(cucumber);
        fruitBasket.addItem(tomato);
        vegetableBasket.addItem(apple);
        vegetableBasket.addItem(banana);
        */

        //Создать ArrayList plants и заполнить его экземплярами фруктов и овощей всех видов по 1 штуке каждого (!в 1 ArrayList).
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(tomato);
        plants.add(cucumber);
        plants.add(apple);
        plants.add(banana);

        //Создать HashMap и заполнить его фруктами и овощами с помощью forEach(), в ключ записывая название фрукта/овоща, а в значение - само растение.
        HashMap<String, Plant> collection = new HashMap<>();
        plants.forEach(entry -> collection.put(entry.getName(), entry));

        //Вывести на экран название растения из карты и рядом с ним имя класса через пробел.
        collection.forEach((key, value) -> {
            System.out.println(key + " " + value.getClass().getSimpleName());
        });
    }
}
