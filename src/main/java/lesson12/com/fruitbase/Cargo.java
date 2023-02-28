package lesson12.com.fruitbase;

import lesson12.com.fruitbase.fruits.Fruit;

import java.math.BigDecimal;

/**
 * - класс Cargo
 *     находится в пакете com.fruitbase
 *     содержит поле массив Fruit - записи о фруктах, добавленных в груз
 *     содержит консткрутор без параметров
 *         в нем инициализируется внутренний массив
 *     содержит общедоступный метод getWeight - возвращает суммарный вес груза
 *     содержит общедоступный метод getPrice - возвращает суммарную цену груза
 *     содержит метод addFruit, доступный только в пакете - добавляет Fruit во внутренний массив
 */
public class Cargo {
    private Fruit[] order; //список добавленных фруктов в заказ

    public Cargo() {
        order = new Fruit[0];
    }

    /**
     * Метод считает суммарный вес груза на основании данных в списке заказа
     *
     * @return суммарный вес заказа
     */
    public double getWeight() {
        double weight = 0;
        for (Fruit fruit : order)
            weight += fruit.getWeight();
        return weight;
    }

    /**
     * Метод считает суммарную стоимость груза на основании данных в списке заказа
     *
     * @return суммарная стоимость заказа
     */
    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal(0);
        for (Fruit fruit : order)
            price = price.add(fruit.getPrice());
        return price;
    }

    /**
     * Метод добавляет фрукт типа Fruit в список заказа
     *
     * @param fruit фрукт, который хотим добавить
     * @return расширенный массив заказа уже с добавленным фруктом
     */
    Fruit[] addFruit(Fruit fruit) {
        Fruit[] newOrder = new Fruit[order.length + 1];
        for (int i = 0; i < order.length; i++) {
            newOrder[i] = order[i];
        }
        newOrder[newOrder.length - 1] = fruit; //последний элемент расширенного массива = переданный фрукт
        order = newOrder; // присваиваем newOrder в качестве нового массива order
        return order;
    }

    /**
     * Метод собирает названия фруктов в заказе в формате - запятые и пробелы в качестве разделителей.
     * Например: Apple, Orange
     *
     * @param order массив заказа, из которого хотим достать названия фруктов
     * @return строка с названиями фруктов, которые содержатся в заказе/грузе
     */
    public String namesInOrder(Fruit[] order) {
        String result = "";
        for (Fruit fruit : order) {
            result += fruit.getName() + ", ";
        }
        return result = result.substring(0, result.length() - 2);
    }

    @Override
    public String toString() {
        if (order.length == 0) return "Указанных фруктов не найдено. Заказ невозможен.";
        else return "Заказ весом " + getWeight() + " кг на сумму " + getPrice() + " у.е\n" +
                "Состав заказа: " + namesInOrder(order);
    }
}
