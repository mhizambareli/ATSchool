package lesson15.part2.com.customer;

import lesson15.part2.com.fruitbase.fruits.Fruit;

public class UniqueCustomer extends Customer {
    public UniqueCustomer(Fruit[] purchases, String name) {
        super(purchases, name);
    }

    /**
     * Метод принимает груз и сохраняет из него фрукты во внутренний массив, т.е. в грузе объекты заканчиваются.
     * Реализация метода выбирает только уникальные фрукты
     *
     * @param order массив груза, который будет сохранён во внутренний массив
     * @return внутренний массив покупок только с уникальными фруктами из груза
     */
    @Override
    public Fruit[] takeFruits(Fruit[] order) {
        this.setPurchases(order.clone()); //клонируем актуальный состав груза в массив покупок конкретного покупателя
        //далее убираем неуникальные позиции из массива, делаем их null
        int nullCounter = 0;
        for (int i = 0; i < purchases.length - 1; i++) {
            if (purchases[i] == null) continue; //не будем лишний раз заходить во второй цикл при null, бесполезно
            int j = 1;
            for (j += i; j < purchases.length; j++) {
                if (purchases[i].equals(purchases[j])) {
                    purchases[j] = null;
                    nullCounter++;
                }
            }
        }
        if (nullCounter == 0) return purchases; //все фрукты были уникальны, ничего не удаляли

        //уменьшаем массив, записываем в новый массив только свежие позиции без null
        Fruit[] newArr = new Fruit[purchases.length - nullCounter];
        for (int i = 0, j = 0; i < purchases.length && j < newArr.length; i++) {
            if (purchases[i] != null) {
                newArr[j] = purchases[i];
                j++;
            }
        }
        purchases = newArr;
        return purchases;
    }
}
