package lesson11.part1;

import java.util.Random;

/**
 * Реализуйте метод void fillArray(int[] a),
 * который устанавливает элементам целочисленного массива а случайные целые числа -9 до 9.
 * <p>
 * Напишите программу, которая создает массив из 20 целочисленных элементов,
 * заполняет его случайными значениями, используя метод fillArray,
 * и печатает его элементы в одну строку, разделив пробелами.
 */
public class Main {
    /**
     * метод для генерации рандомного целого числа в заданном диапозоне
     *
     * @param min минимальное значение при генерации включительно
     * @param max максимальное значение при генерации включительно
     */
    public static int getRandom(int min, int max) {
        Random num = new Random();
        return num.nextInt(max - min + 1) + min;
    }

    /**
     * метод принимает в себя одномерный массив и устанавливает всем элементам массива рандомные значения int в заданном диапозоне
     * после этого печатает получившиеся элементы в одну строку
     *
     * @param a одномерный массив, который хотим заполнить
     */
    public static void fillArray(int[] a) {
        if (a.length == 0) System.out.println("Пустой массив, заполнять нечего");
        String result = "";
        for (int i = 0; i < a.length; i++) {
            a[i] = getRandom(-9, 9);
            result += a[i] + " ";
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        fillArray(arr);
    }
}
