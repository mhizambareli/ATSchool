package lesson19.part2;

import lesson19.part2.vegetables.Cucumber;

import java.util.HashMap;
import java.util.Objects;

import lesson19.part2.Plant;
/**
 * Реализовать для корзины метод size, возвращающий, количество элементов в корзине.
 */
public class Basket<Plant> {
    private HashMap<Plant, Integer> items;

    public HashMap<Plant, Integer> getItems() {
        return items;
    }

    public Basket() {
        items = new HashMap<>();
    }

    /**
     * Метод добавляет переданный товар во внутреннюю коллекцию.
     * Повторяющиеся огурцы будут увеличивать размер в size(), остальные повторы не влияют на размерность
     *
     * @param item добавляемый товар
     */
    public void addItem(Plant item) {
        if (item instanceof Cucumber) {
            items.put(item, items.getOrDefault(item, 0) + 1);
        } else {
            items.put(item, 1);
        }
    }

    /**
     * Метод возвращает количество элементов в корзине
     */
    public int size() {
        return items.values().stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
