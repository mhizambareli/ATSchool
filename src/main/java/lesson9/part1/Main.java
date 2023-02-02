package lesson9.part1;

import static java.util.Arrays.sort;

/**
 * Напишите программу, которая получает два целых числа m и n
 * через аргументы командной строки и печатает целые числа x:
 *      m <= x <= n, которые делятся на 3, но не делятся на 5.
 * Проверку на наличие аргументов делать не надо.
 */
public class Main {
    public static void main(String[] args) {
        //сортируем аргументы сразу, чтобы m было меньше, чем n, либо равно ему
        int[] intArr = {Integer.parseInt(args[0]), Integer.parseInt(args[1])};
        sort(intArr);
        int m = intArr[0];
        int n = intArr[1];

        for (int x = m; x <= n; x++) {
            if (x % 3 == 0 && x % 5 != 0) {
                System.out.println(x);
            }
        }
    }
}
