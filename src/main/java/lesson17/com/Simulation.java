package lesson17.com;

import lesson17.com.customer.FreshCustomer;
import lesson17.com.customer.UniqueCustomer;
import lesson17.com.fruitbase.fruits.*;
import lesson17.com.customer.Customer;
import lesson17.com.fruitbase.FruitBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

public class Simulation {
    public static void handleExport(FruitBase base, String path) {
        try {
            base.exportCatalogue(path);
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
            System.exit(2);
        } catch (IOException io) {
            System.out.println("Ошибка при экспорте каталога в " + path);
            System.exit(2);
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка при экспорте каталога из файла " + path);
            System.exit(2);
        }
    }

    public static void handleImport(FruitBase base, String path) {
        try {
            base.importCatalogue(path);
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
            System.exit(3);
        } catch (IOException io) {
            System.out.println("Невозможно импортировать каталог из файла " + path + ": неподдерживаемая версия");
            System.exit(3);
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка при импорте каталога из файла " + path);
            System.exit(3);
        }
    }

    public static void main(String[] args) {
        FruitBase base = new FruitBase();
        if (args.length == 0) {
            System.out.println("Заказ отсутствует, введите данные.");
            System.exit(1);
        }

        if ((args[0].equals("-e") || args[0].equals("--export")) && args[1].equals("=") && args.length > 2) {
            handleExport(base, args[2]);
        } else if (args[0].equals("-e") || args[0].equals("--export")) {
            base.exportCatalogue();
        }
        if ((args[0].equals("-i") || args[0].equals("--import")) && args[1].equals("=") && args.length > 2) {
            handleImport(base, args[2]);
        } else if (args[0].equals("-i") || args[0].equals("--import")) {
            base.importCatalogue();
        }
        System.out.print("Первоначальный груз: ");
        base.takeOrder(args);

        /**
         * в классе Simulation, используя анонимный класс, добавьте покупателя, который выбирает дорогие фрукты.
         * Дорогими считаются, те, чья стоимость больше или равна 75% от максимальной.
         */
        Customer richCustomer = new Customer(new Fruit[0], "OOO Богач") {
            @Override
            public Fruit[] takeFruits(Fruit[] order) {
                this.setPurchases(order.clone());//клонируем актуальный состав груза в массив покупок конкретного покупателя
                BigDecimal maxPrice = BigDecimal.valueOf(0);
                //переберём массив и найдём максимальную стоимость, от которой будем считать
                for (Fruit fruit : purchases) {
                    if (fruit.getPrice().compareTo(maxPrice) > 0) maxPrice = fruit.getPrice();
                }
                //переберём ещё раз массив и узнаем, сколько у нас дорогих фруктов
                int count = 0; //тут будет кол-во подходящих фруктов
                for (Fruit fruit : purchases) {
                    if (fruit.getPrice().compareTo(maxPrice.multiply(BigDecimal.valueOf(0.75))) >= 0) count++;
                }
                //создаём итоговый массив и добавляем туда дорогие фрукты
                Fruit[] newArr = new Fruit[count];
                int i = 0;
                for (Fruit fruit : purchases) {
                    if (fruit.getPrice().compareTo(maxPrice.multiply(BigDecimal.valueOf(0.75))) >= 0) {
                        newArr[i] = fruit;
                        i++;
                    }
                }
                return purchases = newArr;
            }
        };

        UniqueCustomer customer1 = new UniqueCustomer(new Fruit[0], "ООО Уникальные Овощи"); //актуальный массив будет установлен далее через сеттер в takeFruits()
        FreshCustomer customer2 = new FreshCustomer(new Fruit[0], "ООО Свежие Овощи"); //актуальный массив будет установлен далее через сеттер в takeFruits()

        Customer[] customers = new Customer[]{richCustomer, customer1, customer2};

        for (Customer customer : customers) {
            customer.takeFruits(base.getCargo().getFruits()); //выбираем фрукты в зависимости от того, какой это покупатель - свежие или уникальные фрукты
            System.out.printf("Покупатель %s выбрал: ", customer.getName());
            customer.printPurchases(); //выводим выбранные покупателем фрукты
            for (int i = 0; i < customer.getPurchases().length; i++) {
                base.getCargo().removeFruit(customer.getPurchases()[i]); //удаление фруктов из груза, если фрукты были выбраны покупателем
            }
            System.out.println("\nОставшийся груз: " + base.getCargo()); //выводим информацию об оставшемся грузе после выбора покупателя.
        }
    }
}
