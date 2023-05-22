package lesson18.part2;

import lesson18.part2.fruits.Apple;
import lesson18.part2.fruits.Banana;
import lesson18.part2.fruits.Fruit;
import lesson18.part2.vegetables.Cucumber;
import lesson18.part2.vegetables.Tomato;
import lesson18.part2.vegetables.Vegetable;

import java.util.Iterator;

/**
 * Создать интерфейс Plant и унаследоваться от него фруктами и овощами (интерфейсами). В методе Plant создать метод getName(), который будет возвращать строку. Реализовать для классов возврат имени фрукта ("Апельсин", "Огурец" и т.д.)
 * Вместо массива теперь в классе с корзиной поставить HashMap, в методе addItem добавлять новые элементы в ключ, подумать, как можно "заглушить" значение value HashMap, так как вам оно точно не понадобится. Реализовать метод iterator внутри класса корзин, чтобы он возвращал итерратор множества ключей глобального поля HashMap.
 * <p>
 * Реализовать метод makeSalad, в классе, где добавляли фрукты и овощи в корзине, в который можно кидать корзину. Результатом работы этого метода должен был вывод в консоль строк (в методе вывод должен быть с помощью итератора, который реализовали в этом задании):
 * ```
 * Готовим салатик:
 * Режем - тут должно быть столько же фруктов, сколько было элементов в корзине
 * <p>
 * Угощайся!
 * ```
 */
public class Main {

    public static void makeSalad(Basket<? extends Plant> basket) {
        Iterator<? extends Plant> iterator = basket.iterator();
        if (!iterator.hasNext()) {
            System.out.println("Не могу сделать салатик, корзина пуста:(");
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
    }
}
