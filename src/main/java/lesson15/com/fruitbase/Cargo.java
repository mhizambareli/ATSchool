package lesson15.com.fruitbase;

import lesson15.com.fruitbase.fruits.Fruit;

import java.math.BigDecimal;

/**
 * В класс Cargo надо добавить
 * - общедоступный метод getFruits
 * с его помощью покупатели получают фрукты из груза
 * возвращает список фруктов
 * <p>
 * - общедоступный метод removeFruit
 * получает в качестве параметра фрукт
 * если такого фрукта нет во внутреннем списке, то метод завершается
 * иначе убирает фрукт с указанным названием из внутреннего массива и возвращает его
 */
public class Cargo implements Delivery {
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
        for (Fruit fruit : order) {
            if (fruit == null) continue;
            weight += fruit.getWeight();
        }
        double scale = Math.pow(10, 2); //нужно для округления до n знаков после запятой, если потребуется, в моём случае до 2-х знаков
        weight = Math.ceil(weight * scale) / scale;
        return weight;
    }

    /**
     * Метод считает суммарную стоимость груза на основании данных в списке заказа
     *
     * @return суммарная стоимость заказа
     */
    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal(0);
        for (Fruit fruit : order) {
            if (fruit == null) continue;
            price = price.add(fruit.getPrice());
        }
        return price;
    }

    /**
     * Метод добавляет фрукт типа Fruit в список заказа
     *
     * @param fruit фрукт, который хотим добавить
     */
    public void addFruit(Fruit fruit) {
        Fruit[] newOrder = new Fruit[order.length + 1];
        for (int i = 0; i < order.length; i++) {
            newOrder[i] = order[i];
        }
        newOrder[newOrder.length - 1] = fruit; //последний элемент расширенного массива = переданный фрукт
        order = newOrder; // присваиваем newOrder в качестве нового массива order
    }

    /**
     * Метод собирает названия фруктов в заказе в формате - запятые и пробелы в качестве разделителей.
     * Например: Apple, Orange
     *
     * @return строка с названиями фруктов, которые содержатся в заказе/грузе
     */
    public String namesInOrder() {
        String result = "";
        if (order.length == 0) return result;
        for (Fruit fruit : order) {
            if (fruit == null) continue;
            result += fruit.getName() + ", ";
        }
        if (result.length() > 0) result = result.substring(0, result.length() - 2);
        return result;
    }


    public Fruit[] getFruits() {
        return order;
    }

    /**
     * Метод удаляет переданный фрукт из внутреннего массива, если таков найден в массиве
     *
     * @param fruit фрукт, который нужно удалить из массива
     * @return если найден фрукт, то возвращается этот фрукт, если нет, то null
     */
    public Fruit removeFruit(Fruit fruit) {
        int nullCounter = 0; //в итоге 0 = ничего не удалялось, 1 = удалили фрукт.
        for (int i = 0; i < order.length; i++) {
            if (order[i] == null) continue;
            if (order[i].equals(fruit)) {
                order[i] = null;
                nullCounter++;
                break;
            }
        }
        if (nullCounter == 0) return null; //не нашли фрукт во внутреннем массиве, ничего не удалили

        Fruit[] newArr = new Fruit[order.length - 1];
        for (int i = 0, j = 0; i < order.length; i++) {
            if (order[i] != null) {
                newArr[j] = order[i];
                j++;
            }
        }
        order = newArr;
        return fruit;
    }

    @Override
    public String toString() {
        if (order.length == 0) return "Указанных фруктов не найдено. Заказ невозможен.";
        else return "Груз весом " + getWeight() + " кг на сумму " + getPrice() + " у.е\n" +
                "Состав груза: " + namesInOrder() + "\n";
    }

}
