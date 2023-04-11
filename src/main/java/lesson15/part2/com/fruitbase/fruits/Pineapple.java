package lesson15.part2.com.fruitbase.fruits;

import java.math.BigDecimal;

public class Pineapple extends Fruit {
    public Pineapple(double weight, BigDecimal price, String name) {
        super(weight, price, name);
    }

    @Override
    public Fruit clone() {
        return new Pineapple(this.getWeight(), this.getPrice(), this.getName());
    }
}
