package lesson7.part2;

/**
 * Создать класс Summa, в нем cоздать и перегрузить метод sum
 * - возвращающий сумму int от 2х переменных int
 * - возвращающий сумму double от 3х переменных int
 * - возвращающий сумму double от 2х и от 3х переменных double
 * - возвращающий сумму double от 1 int и от 2х переменных double
 * - возвращающий double из 2х переменных типа Integer
 */

public class Summa {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static double sum(int a, int b, int c) {
        return (double) a + b + c;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double sum(double a, double b, double c) {
        return a + b + c;
    }

    public static double sum(int a, double b, double c) {
        return (double) a + b + c;
    }

    public static double sum(Integer a, Integer b) {
        return (double) a + b;
    }
}
