package lesson15.part1;

import java.util.Arrays;

/**
 * Напишите в отдельном классе программу, которая через аргументы командной строки
 * получает последовательность целых чисел и название операции, которую надо применить числам.
 * При выполнении печатается исходная последовательность чисел, а потом печатается последовательность,
 * полученная применением операции к числам.
 * Название операции передается первым аргументом, а далее передаются числа.
 * Название операции соответствует названиям классов Half, Double, Exact, Square.
 * <p>
 * Для реализации программы создайте метод applyFunction, который на вход получает два аргумента:
 * - массив из переданных чисел
 * - объект типа Function.
 * Этот метод возвращает новый массив, где каждый элемент является результатом применения
 * метода evaluate объекта типа Function к соответствующему элементу исходного массива.
 * <p>
 * При обработке аргументов командной строки добавьте следующие проверки:
 * - Если не передано название операции, то программа завершается с соответствующим сообщением об ошибке.
 * - Если передано неподдерживаемое название класса, то программа завершается с соответствующим сообщением.
 * - Если не передано хотя бы одно число, то программа завершается, с соответствующим сообщением об ошибке.
 * <p>
 * Пример:
 * 1) Переданные аругменты:
 * Вывод: Не передано название операции.
 * 2) Переданные аругменты: Exact
 * Вывод: Не переданы числа для операции.
 * 3) Переданные аругменты: Triple
 * Вывод: Операция Triple не поддерживается.
 * 4) Переданные аругменты: Half 1 2 4 8
 * Вывод:
 * 1 2 4 8
 * 0 1 2 4
 */
public class Main {
    /**
     * Метод применения функции над массивом целых чисел
     *
     * @param arr массив переданных чисел
     * @param func объект типа Function
     * @return новый массив, числа в массиве измененены в соответствии с операцией
     */
    public static int[] applyFunction(int[] arr, Function func) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = func.evaluate(arr[i]);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        String result = "";
        for(int elem : arr) {
            result += elem + " ";
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не передано название операции.");
            return;
        }
        Function function;
        switch (args[0]) {
            case "Half":
                function = new Half();
                break;
            case "Double":
                function = new Double();
                break;
            case "Exact":
                function = new Exact();
                break;
            case "Square":
                function = new Square();
                break;
            default:
                System.out.println("Операция " + args[0] + " не поддерживается.");
                return;
        }
        if (args.length == 1) {
            System.out.println("Не переданы числа для операции.");
            return;
        }
        int[] array = new int[args.length - 1];

        for(int i = 0, j = 1; j < args.length; i++, j++){
            array[i] = Integer.parseInt(args[j]);
        }
        printArray(applyFunction(array, function));
    }
}
