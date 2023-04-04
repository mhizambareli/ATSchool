package lesson14.com;

import lesson14.com.customer.Customer;
import lesson14.com.customer.FreshCustomer;
import lesson14.com.customer.UniqueCustomer;
import lesson14.com.fruitbase.FruitBase;
import lesson14.com.fruitbase.fruits.Fruit;

import static lesson14.com.fruitbase.fruits.Freshness.OVERRIPED;


/**
 * Добавить специальный класс Simulation, внутри которого теперь будет выполняться программа.
 * Для этого в него перенесем метод main из Fruitbase и внесем изменения:
 * - после создания объекта FruitBase создается массив покупателей, в который будут входит экземпляры обоих видов покупателей
 * - далее для каждого покупателя:
 * выполняется заказ и формируется груз
 * выводится информации о грузе
 * покупатель выбирает из груза интересующие его фрукты
 * покупатель выводит полученные фрукты
 * выводится информации об оставшемся грузе
 */
public class Simulation {
    public static void main(String[] args) {
        FruitBase base = new FruitBase();
        if (args.length == 0) {
            System.out.println("Заказ отсутствует, введите данные.");
            System.exit(1);
        }
        System.out.print("Первоначальный груз: ");
        base.takeOrder(args);

        base.getCargo().getFruits()[0].setFreshness(OVERRIPED);//хардкодим пока первый фрукт в грузе перезрелым для проверки выбора свежих фруктов

        UniqueCustomer customer1 = new UniqueCustomer(new Fruit[0], "ООО Уникальные Овощи"); //актуальный массив будет установлен далее через сеттер в takeFruits()
        FreshCustomer customer2 = new FreshCustomer(new Fruit[0], "ООО Свежие Овощи"); //актуальный массив будет установлен далее через сеттер в takeFruits()

        Customer[] customers = new Customer[]{customer1, customer2};

        for (Customer customer : customers) {
            customer.takeFruits(base.getCargo().getFruits()); //выбираем фрукты в зависимости от того, какой это покупатель - свежие или уникальные фрукты
            System.out.printf("Покупатель %s выбрал: ", customer.getName());
            customer.printPurchases(); //выводим выбранные покупателем фрукты
            for (int i = 0; i < customer.getPurchases().length; i++) {
                base.getCargo().removeFruit(customer.getPurchases()[i]); //удаление фруктов из груза, если фрукты были выбраны покупателем
            }
            System.out.println("Оставшийся груз: " + base.getCargo()); //выводим информацию об оставшемся грузе после выбора покупателя.
        }
    }
}
