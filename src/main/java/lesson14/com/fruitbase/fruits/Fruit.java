package lesson14.com.fruitbase.fruits;

import java.math.BigDecimal;
import java.util.Objects;

import static lesson13.com.fruitbase.fruits.Freshness.FRESH;

/**
 * Для фруктов нужно добавить
 *         - внутренний параметр freshness - отражает состояние свежести фрукта;
 *           для значений нужно завести enum с как минимум состояниями: FRESH, OVERRIPED, SPOILED
 *           при создании объект имеет состояние FRESH
 *         - метод equals
 *         - метод hashcode
 *         - метод isFresh - возвращает true, если параметр freshness имеет состояние FRESH
 */
public abstract class Fruit {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.weight, weight) == 0
                && Objects.equals(price, fruit.price)
                && Objects.equals(name, fruit.name)
                && freshness == fruit.freshness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, price, name, freshness);
    }

    /**
     * Метод проверяет свежий ли продукт
     * @return значение true, если фрукт свежий
     * или false в остальных случаях
     */
    public boolean isFresh(){
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

    public Freshness getFreshness() {
        return freshness;
    }

    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }
}
