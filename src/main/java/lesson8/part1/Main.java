package lesson8.part1;

/**
 * В программу через аргументы командной строки передаются три целых числа: a, b, c.
 * Выведите наибольшее из данных чисел, (программа должна вывести ровно одно целое число).
 * Проверку на наличие аргументов делать не надо.
 */
public class Main {
    public static void findMax(int a, int b, int c) {
        int max = a >= b && a >= c ? a : (b >= a && b >= c ? b : c);
        System.out.println(max);
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        findMax(a, b, c);
    }
}
