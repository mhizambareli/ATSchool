package lesson15.com.fruitbase;

import java.math.BigDecimal;

import lesson15.com.fruitbase.fruits.Fruit;

public interface Delivery {
    double getWeight();
    BigDecimal getPrice();
    void addFruit(Fruit fruit);
    Fruit[] getFruits();
    Fruit removeFruit(Fruit fruit);
}
