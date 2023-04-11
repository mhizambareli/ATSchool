package lesson15.part2.com;

import lesson15.part2.com.fruitbase.FruitBase;

import java.math.BigDecimal;


/**
 * Для использования методов экспорта и импорта каталога добавьте обработку специальных аргументов ("флагов") в классе Simulation.
 * в методе main после создания объекта FruitBase добавьте проверку аргументов:
 * - если передан флаг "-e" или "--export", то вызовите метод exportCatalogue у объекта FruitBase
 * - если передан флаг "-i" или "--import", то вызовите метод importCatalogue у объекта FruitBase
 * <p>
 * Подготовьте необходимые классы к сериализации.
 * <p>
 * Для проверки экспортируйте каталог, зафиксируйте стоимость и вес полученного груза.
 * После экспорта каталога измените вес и цены у фруктов и зафиксируйте новые вес и стоимость.
 * Далее попробуйте имортировать каталог и обратите внимание, что стоимость и вес груза
 * расчитаны согласно экспортированному каталогу.
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
