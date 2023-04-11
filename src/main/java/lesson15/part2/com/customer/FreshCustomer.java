package lesson15.part2.com.customer;

import lesson15.part2.com.fruitbase.fruits.Fruit;

public class FreshCustomer extends Customer {
    public FreshCustomer(Fruit[] purchases, String name) {
        super(purchases, name);
    }

    /**
     * Метод принимает груз и сохраняет из него фрукты во внутренний массив, т.е. в грузе объекты заканчиваются.
     * Реализация метода выбирает только свежие фрукты
     *
     * @param order массив груза, который будет сохранён во внутренний массив
     * @return внутренний массив покупок только со свежими фруктами из груза
     */
    @Override
    public Fruit[] takeFruits(Fruit[] order) {
        this.setPurchases(order.clone()); //клонируем актуальный состав груза в массив покупок конкретного покупателя
        //убираем несвежие позиции из массива, заменяем на null
        int nullCounter = 0;
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) continue;
            if (!purchases[i].isFresh()) {
                purchases[i] = null;
                nullCounter++;
            }
        }
        if (nullCounter == 0) return purchases; //все фрукты были свежие, ничего не удаляли

        //уменьшаем массив, записываем в новый массив только свежие позиции без null
        Fruit[] newArr = new Fruit[purchases.length - nullCounter];
        for (int i = 0, j = 0; i < purchases.length; i++) {
            if (purchases[i] != null) {
                newArr[j] = purchases[i];
                j++;
            }
        }
        purchases = newArr;
        return purchases;
    }
}
