package lesson13.com.fruitbase.fruits;

import java.math.BigDecimal;

/**
 * - абстрактный класс Fruit
 * находится в пакете com.fruitbase.fruits
 * содержит наследуемое поле вес
 * содержит наследуемое поле цена
 * содержит наследуемое поле name
 * содержит общедоступный метод по-умолчанию для получения значения веса getWeight
 * содержит общедоступный метод по-умолчанию для получения значения цены getPrice
 * содержит общедоступный метод по-умолчанию для получения значения name getName
 */
public abstract class Fruit {
    private double weight; //вес в кг
    private BigDecimal price; // цена за фрукт в у.е
    private String name; //наименование фрукта

    public Fruit(double weight, BigDecimal price, String name) {
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
