package lesson16.com.fruitbase.fruits;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static lesson16.com.fruitbase.fruits.Freshness.*;

/**
 * Для фруктов нужно добавить
 * - внутренний параметр freshness - отражает состояние свежести фрукта;
 * для значений нужно завести enum с как минимум состояниями: FRESH, OVERRIPED, SPOILED
 * при создании объект имеет состояние FRESH
 * - метод equals
 * - метод hashcode
 * - метод isFresh - возвращает true, если параметр freshness имеет состояние FRESH
 */
public abstract class Fruit implements Serializable {
    private double weight; //вес в кг
    private BigDecimal price; // цена за фрукт в у.е
    private String name; //наименование фрукта
    private Freshness freshness; //свежесть фрукта

    public Fruit(double weight, BigDecimal price, String name) {
        this.weight = weight;
        this.price = price;
        this.name = name;
        freshness = FRESH;
    }

    /**
     * Метод клонирования объектов классов-наследников Fruit
     *
     * @return новый объект класса-наследника Fruit с теми же полями, что и у объекта, у которого метод был вызван.
     */
    public abstract Fruit clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.weight, weight) == 0
                && Objects.equals(price, fruit.price)
                && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, price, name, freshness);
    }

    /**
     * Метод проверяет свежий ли продукт
     *
     * @return значение true, если фрукт свежий
     * или false в остальных случаях
     */
    public boolean isFresh() {
        return this.freshness == FRESH ? true : false;
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

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }
}
