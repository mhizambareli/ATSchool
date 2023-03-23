package lesson13.com.fruitbase;

import lesson13.com.fruitbase.fruits.Apple;

import java.math.BigDecimal;

/**
 * - класс FruitCatalogue
 *     находится в пакете com.fruitbase
 *     содержит поле массив Fruit - список записей известных фруктов
 *     содержит конструктор без параметров
 *         при создании во внутренний массив добавляются записи-экзмепляры известных фруктов
 *     содержит метод findFruit, доступный только в пакете
 *         по переданному слову проверяет есть ли информация о таком фрукте
 *         если есть, то возвращает Fruit. Если нет, то возвращает null.
 */
public class FruitCatalogue {
    private lesson13.com.fruitbase.fruits.Fruit[] fruits; //каталог, список фруктов

    public FruitCatalogue() {
        lesson13.com.fruitbase.fruits.Apple apple = new Apple(10.5, BigDecimal.valueOf(487.55), "Apple");
        lesson13.com.fruitbase.fruits.Orange orange = new lesson13.com.fruitbase.fruits.Orange(5, BigDecimal.valueOf(541.36), "Orange");
        lesson13.com.fruitbase.fruits.Banana banana = new lesson13.com.fruitbase.fruits.Banana(3.5, BigDecimal.valueOf(321.05), "Banana");
        lesson13.com.fruitbase.fruits.Pineapple pineapple = new lesson13.com.fruitbase.fruits.Pineapple(8.2, BigDecimal.valueOf(596.12), "Pineapple");
        this.fruits = new lesson13.com.fruitbase.fruits.Fruit[]{apple, orange, banana, pineapple};
    }

    /**
     * Метод ищет фрукт по переданному названию фрукта. Внутри идёт сравнение с каталогом фруктов - массивом fruits.
     *
     * @param fruitName название фрукта, по которому будет происходить поиск
     * @return фрукт типа Fruit. Если фрукт не найден - возвращается null
     */
    lesson13.com.fruitbase.fruits.Fruit findFruit(String fruitName) {
        for (lesson13.com.fruitbase.fruits.Fruit fruit : fruits)
            if (fruit.getName().equals(fruitName)) return fruit;
        return null;
    }
}
