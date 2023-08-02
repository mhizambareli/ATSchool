package lesson19.part2;

import lesson19.part2.fruits.Apple;
import lesson19.part2.fruits.Banana;
import lesson19.part2.fruits.Fruit;
import lesson19.part2.vegetables.Cucumber;
import lesson19.part2.vegetables.Tomato;
import lesson19.part2.vegetables.Vegetable;

/**
 * Задание 7.9.2
 * Реализовать для корзины метод size, возвращающий, количество элементов в корзине.
 *
 * Реализовать класс с огурцами так, чтобы можно было добавить в одну и ту же корзину, в которую добавляем овощи, один и тот же огурец несколько раз. Помидоры не трогать.
 * Другими словами, делаем одно поле с огурцом и одно поле с помидором в корзину для овощей (из третьего задания, в котором складываем всё в глобальное поле HashMap). Добавляем этот огурец три раза подряд и два раза подряд добавляем помидор, вызывая метод addItem. После этого вызываем метод size и он должен вывести ответ 4.
 */
public class Main {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Vegetable tomato = new Tomato();
        Vegetable cucumber = new Cucumber();

        //создаю овощную корзину и заполняю её, помидор засчитается в размере корзины 1 раз
        Basket<Vegetable> vegetableBasket = new Basket<>();
        vegetableBasket.addItem(cucumber);
        vegetableBasket.addItem(cucumber);
        vegetableBasket.addItem(cucumber);
        vegetableBasket.addItem(tomato);
        vegetableBasket.addItem(tomato);

        //аналогичная проверка фруктовой корзины
        Basket<Fruit> fruitBasket = new Basket<>();
        fruitBasket.addItem(apple);
        fruitBasket.addItem(apple);
        fruitBasket.addItem(banana);
        fruitBasket.addItem(apple);
        fruitBasket.addItem(banana);

        System.out.println(vegetableBasket.size()); //4
        System.out.println(fruitBasket.size());//2
    }
}
