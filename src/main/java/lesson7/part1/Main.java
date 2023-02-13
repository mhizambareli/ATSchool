package lesson7.part1;

/**
 * Создать котиков в методе Main и вывести на их экран.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(10, "Голубой", 7, "Рыжий");
        Cat cat2 = new Cat(7, "Жёлтый", 5);
        Cat cat3 = new Cat(2, "Карий", "Полосатый серо-белый");
        Cat cat4 = new Cat(5, 6, "Коричневый");
        Cat cat5 = new Cat("Золотистый", 8, "Пятнистый серый");
        Cat cat6 = new Cat(3, "Голубой");
        Cat cat7 = new Cat(5, 7);
        Cat cat8 = new Cat("Карий", 3);
        Cat cat9 = new Cat("Голубой", "Белый");
        Cat cat10 = new Cat(4);
        Cat cat11 = new Cat("Рыжий");
        Cat cat12 = new Cat();


        System.out.println("Котик 1\n" + cat1);
        System.out.println("Котик 2\n" + cat2);
        System.out.println("Котик 3\n" + cat3);
        System.out.println("Котик 4\n" + cat4);
        System.out.println("Котик 5\n" + cat5);
        System.out.println("Котик 6\n" + cat6);
        System.out.println("Котик 7\n" + cat7);
        System.out.println("Котик 8\n" + cat8);
        System.out.println("Котик 9\n" + cat9);
        System.out.println("Котик 10\n" + cat10);
        System.out.println("Котик 11\n" + cat11);
        System.out.println("Котик 12\n" + cat12);
    }
}
