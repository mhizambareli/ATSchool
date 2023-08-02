package lesson11.part5;

import static lesson11.part1.Main.getRandom;
import static java.util.Arrays.sort;
import static java.util.Comparator.comparingInt;

/**
 * Напишите программу, которая создает зубчатый массив целочисленных элементов, сгенеренных случайным образов в диапазоне -9 до 9.
 * Массив должен содержать не более 5 строк и каждая строка иметь не более 7 столбцов.
 * Выведите массив на экран в порядке убывания сумм элементов строк.
 */

public class Main {
    /**
     * Метод считает сумму элементов в строке (в одномерном массиве)
     *
     * @param arr - одномерный массив, у которого хотим узнать сумму элементов
     * @return возвращает сумму
     */
    private static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = new int[getRandom(2, 5)][]; //двумерный массив от 2 до 5 строк включительно

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[getRandom(5, 7)]; //от 5 до 7 элементов в строке
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = getRandom(-9, 9); //значения каждого элемента от -9 до 9
            }
        }

        sort(arr, comparingInt(Main::sum).reversed()); //сортировка по убыванию по сумме элементов в строке.
        //Main::sum - квадроточие позволяет получить ссылку на метод, указанный в правой части, класса, указанного в левой. Т.е. берём метод sum из класса Main

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}