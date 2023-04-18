package lesson16.com;

import lesson16.com.fruitbase.FruitBase;

import java.math.BigDecimal;


/**
 * В проект фруктовой базы, в пакет fruitbase, добавьте интерфейс Delivery.
 * Содержит следующие абстрактные методы
 *    double getWeight();
 *    BigDecimal getPrice();
 *    void addFruit(Fruit fruit);
 *    Fruit[] getFruits();
 *    Fruit removeFruit(Fruit fruit);
 * Укажите, что класс Cargo реализует интерфейс Delivery.
 * Замените в методах проекта типы возвращаемых объектов и типы передаваемых аргументов с Cargo на Delivery.
 */
public class Simulation {
    public static void main(String[] args) {
        FruitBase base = new FruitBase();
        if (args.length == 0) {
            System.out.println("Заказ отсутствует, введите данные.");
            System.exit(1);
        }
        if(args[0].equals("-e") || args[0].equals("--export")){
            base.exportCatalogue();
        }
        if(args[0].equals("-i")|| args[0].equals("--import")){
            base.importCatalogue();
        }

        base.exportCatalogue(); //Для проверки явно экспортирую каталог
        System.out.println("зафиксируем стоимость и вес полученного груза изначально:");
        base.takeOrder(args);

        //После экспорта каталога изменяем вес
        base.getCatalogue().getFruits()[0].setWeight(1111.1);
        base.getCatalogue().getFruits()[1].setWeight(2222.22);
        base.getCatalogue().getFruits()[2].setWeight(3333.333);
        base.getCatalogue().getFruits()[3].setWeight(4444.4);

        //и цену на фрукты в каталоге
        base.getCatalogue().getFruits()[0].setPrice(BigDecimal.valueOf(111.1));
        base.getCatalogue().getFruits()[1].setPrice(BigDecimal.valueOf(222.222));
        base.getCatalogue().getFruits()[2].setPrice(BigDecimal.valueOf(333.333));
        base.getCatalogue().getFruits()[3].setPrice(BigDecimal.valueOf(4444.44));

        System.out.println("зафиксируем стоимость и вес полученного груза после внесения изменений в каталог:");
        base.takeOrder(args);

        base.importCatalogue(); //импортируем обратно ранее экспортированный каталог
        System.out.println("зафиксируем стоимость и вес полученного груза после импорта каталога:");
        base.takeOrder(args);
    }
}
