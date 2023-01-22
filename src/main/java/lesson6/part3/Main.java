package lesson6.part3;

/**
 * Напишите программу, которая получает два положительных числа через программные аргументы командной строки и выводит true, если первое из чисел нацело делится на другое.
 * Проверку на кол-во введенных аргументов делать не надо.
 * Попробуйте решить задание без использования if.
 * Выведите исходные значения и результат. Например:
 *
 * 1)Дано: a = 4, b = 5
 * false
 *
 * 2)Дано: a = 15, b = 5
 * true
 */

public class Main {
    public static boolean isDivisible(int a, int b) {
        System.out.println("Дано: a = " + a + ", b = " + b);
        return a % b == 0;
    }

    public static void main(String[] args) {
        //парсим в int, т.к. в main() аргументы принимаются в String
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(isDivisible(a, b));
    }


}


