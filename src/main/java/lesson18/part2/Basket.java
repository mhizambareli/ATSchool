package lesson18.part2;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Вместо массива теперь в классе с корзиной поставить HashMap, в методе addItem добавлять новые элементы в ключ, подумать, как можно "заглушить" значение value HashMap, так как вам оно точно не понадобится.
 * Реализовать метод iterator внутри класса корзин, чтобы он возвращал итерратор множества ключей глобального поля HashMap.
 */
public class Basket<Plant> {
    private HashMap<Plant, Void> items;

    public HashMap<Plant, Void> getItems() {
        return items;
    }

    public Basket() {
        items = new HashMap<>(5);
    }

    /**
     * Метод добавляет переданный товар во внутреннюю коллекцию
     *
     * @param item добавляемый товар
     */
    public void addItem(Plant item) {
        items.put(item, null);
        System.out.println("Товар добавлен в корзину");
    }

    /**
     * Итератор, переберирающий ключи в коллекции
     * @return
     */
    public Iterator<Plant> iterator() {
        return items.keySet().iterator();
    }
}
