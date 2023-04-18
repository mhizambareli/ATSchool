package lesson16.com.fruitbase.fruits;

import java.math.BigDecimal;

public class Orange extends Fruit {
    public Orange(double weight, BigDecimal price, String name) {
        super(weight, price, name);
    }

    @Override
    public Fruit clone() {
        return new Orange(this.getWeight(), this.getPrice(), this.getName());
    }
}
