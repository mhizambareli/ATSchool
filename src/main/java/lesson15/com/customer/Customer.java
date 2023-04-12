package lesson15.com.customer;

import lesson15.com.fruitbase.fruits.Fruit;

/**
 * Надо создать новый пакет customers и в нем создать новые классы
 * - абстрактный класс Customer
 * имеет внутренний массив покупок фруктов purchases (доступен у наследников)
 * имеет внутреннее поле name - имя покупателя (доступен у наследников)
 * имеет конструктор
 * инициализируется внутренний массив
 * устанавливается имя
 * имеет метод takeFruits, который должны реализовать наследникик
 * метод принимает груз и сохраняет из него фрукты во внутренний массив, т.е. в грузе объекты заканчиваются.
 * имеет метод printPurchases
 * метод выводит полученные фрукты
 */
public abstract class Customer {
    protected Fruit[] purchases; //массив покупок фруктов
    protected String name; //имя покупателя

    /**
     * Метод принимает груз и сохраняет из него фрукты во внутренний массив, т.е. в грузе объекты заканчиваются.
     *
     * @param order массив груза, который будет сохранён во внутренний массив
     * @return внутренний массив покупок с фруктами из груза
     */
    public abstract Fruit[] takeFruits(Fruit[] order);

    public Customer(Fruit[] purchases, String name) {
        this.purchases = purchases;
        this.name = name;
    }

    /**
     * Метод печатает фрукты, которые были выбраны покупателем
     */
    public void printPurchases() {
        String result = "";
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) continue;
            result += purchases[i].getName() + ", ";
        }
        if (result.length() > 0) result = result.substring(0, result.length() - 2);
        System.out.println(result);
    }

    public Fruit[] getPurchases() {
        return purchases;
    }

    public void setPurchases(Fruit[] purchases) {
        this.purchases = purchases;
    }

    public String getName() {
        return name;
    }
}
