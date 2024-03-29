package lesson13.com.fruitbase.fruits;

import java.math.BigDecimal;

public class Banana extends Fruit {
    public Banana(double weight, BigDecimal price, String name) {
        super(weight, price, name);
    }

    @Override
    public Fruit clone() {
        return new Banana(this.getWeight(), this.getPrice(), this.getName());
    }
}
