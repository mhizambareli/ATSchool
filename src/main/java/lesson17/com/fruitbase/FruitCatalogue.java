package lesson17.com.fruitbase;

import lesson17.com.fruitbase.fruits.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  - в класс FruitCatalogue, используя анонимные классы, во внутренний каталог добавьте фрукты:
 *     * Mango
 *     * Kiwi
 */
public class FruitCatalogue implements Serializable {
    private Fruit[] fruits; //каталог, список фруктов

    public FruitCatalogue() {
        Apple apple = new Apple(10.5, BigDecimal.valueOf(447.09), "Apple");
        Orange orange = new Orange(5, BigDecimal.valueOf(541.36), "Orange");
        Banana banana = new Banana(3.5, BigDecimal.valueOf(321.05), "Banana");
        Pineapple pineapple = new Pineapple(8.2, BigDecimal.valueOf(596.12), "Pineapple");
        this.fruits = new Fruit[]{apple, orange, banana, pineapple,
                new Fruit(1.5, BigDecimal.valueOf(123.01), "Mango") {},
                new Fruit(0.5, BigDecimal.valueOf(415.10), "Kiwi") {}
        };
    }

    /**
     * Метод ищет фрукт по переданному названию фрукта. Внутри идёт сравнение с каталогом фруктов - массивом fruits.
     *
     * @param fruitName название фрукта, по которому будет происходить поиск
     * @return фрукт типа Fruit. Если фрукт не найден - возвращается null
     */
    Fruit findFruit(String fruitName) {
        for (Fruit fruit : fruits)
            if (fruit.getName().equals(fruitName)) return fruit;
        return null;
    }

    public Fruit[] getFruits() {
        return fruits;
    }
}
