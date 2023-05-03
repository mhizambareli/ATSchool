package lesson17.com.fruitbase;

import lesson17.com.fruitbase.fruits.Fruit;

import java.math.BigDecimal;

public interface Delivery {
    double getWeight();
    BigDecimal getPrice();
    void addFruit(Fruit fruit);
    Fruit[] getFruits();
    Fruit removeFruit(Fruit fruit);
}
