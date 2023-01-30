package lesson8.part1;

/**
 * В программу через аргументы командной строки передаются три целых числа: a, b, c.
 * Выведите наибольшее из данных чисел, (программа должна вывести ровно одно целое число).
 * Проверку на наличие аргументов делать не надо.
 */
public class Main {
    public static void findMax(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                System.out.println(a);
            } else {
                System.out.println(c);
            }
        } else {
            if (b > c) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        }
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        findMax(a, b, c);
    }
}
