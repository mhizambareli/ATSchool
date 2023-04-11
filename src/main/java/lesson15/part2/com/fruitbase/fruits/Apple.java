package lesson15.part2.com.fruitbase.fruits;

import java.math.BigDecimal;

public class Apple extends Fruit {
    public Apple(double weight, BigDecimal price, String name) {
        super(weight, price, name);
    }

    @Override
    public Fruit clone() {
        return new Apple(this.getWeight(), this.getPrice(), this.getName());
    }
}
