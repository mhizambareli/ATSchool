package lesson18.part1;

/**
 * Реализовать класс Basket, с методом addItem, который будет принимать в себя только овощи или фрукты
 * и помещать это всё в глобальную переменную - массив (5 элементов достаточно) внутри класса.
 */
public class Basket<T> {
    private T[] items;
    private int itemCount;

    public Basket() {
        items = (T[]) new Object[5];
        itemCount = 0;
    }

    /**
     * Метод добавляет переданный товар во внутренний массив, если товар, соответствует типу корзины
     * @param item добавляемый товар
     */
    public void addItem(T item) {
        if (itemCount < 5) {
            items[itemCount] = item;
            itemCount++;
            System.out.println("Товар добавлен в корзину.");
        } else System.out.println("Невозможно добавить товар, т.к. корзина полна.");
    }
}
