package lesson11.part3;

import static lesson11.part1.Main.*;
/**
 * Реализуйте метод void bubbleSort(int[] a),
 * который сортирует целочисленные элементы в массиве a по возрастанию (первый элемент - минимальный) согласно алгоритму пузырьковой сортировки.
 * en.wikipedia.org/wiki/Bubble_sort
 * <p>
 * Используя метод fillArray из первого задания и метод bubbleSort, напишите программу, которая создает массив из 20 целочисленных элементов, выводит элементы в одну строку, разделив пробелами.
 * Затем, используя метод bubbleSort, сортирует созданный массив
 * и выводит элементы отсортированного массива в одну строку, разделив пробелами.
 */
public class BubbleSort {
    public static void bubbleSort(int[] a) {
        boolean isSorted = false;
        int buffer = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    isSorted = false;
                    buffer = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = buffer;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        System.out.print("Сгенерированный массив: ");
        fillArray(arr);
        System.out.print("Отсортированный массив: ");
        bubbleSort(arr);
    }
}
