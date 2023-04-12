package lesson15.part2.com.fruitbase;

import java.math.BigDecimal;
import lesson15.part2.com.fruitbase.fruits.Fruit;

public interface Delivery {
    double getWeight();
    BigDecimal getPrice();
    void addFruit(Fruit fruit); //TODO уточни у Лёши про возвращаемый тип void
    Fruit[] getFruits();
    Fruit[] removeFruit(Fruit fruit);
}
