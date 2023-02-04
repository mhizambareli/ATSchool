package lesson7.part2;
import static lesson7.part2.Summa.sum;

/**
 * Сделать класс с методом main, в методе объявить переменные а и b типа int , переменные x, y, z типа double.
 * Вызовите созданные методы класса Summa, используя объявленные переменные.
 * Полученные результаты вывести на экран.
 */
public class Main {
    public static void main(String[] args) {
        int a = 791;
        int b = 283;
        double x = 8293;
        double y = 1564;
        double z = 3656;
        Integer a2 = a;
        Integer b2 = b;

        System.out.println(sum(a, b));
        System.out.println(sum(a, b, b));
        System.out.println(sum(x, y));
        System.out.println(sum(x, y, z));
        System.out.println(sum(a, x, y));
        System.out.println(sum(a2, b2));
    }
}
