package lesson6.part3;

import org.jetbrains.annotations.NotNull;

public class Main {

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
    public static boolean isDivisible(String a, String b) {
        System.out.println("Дано: a = " + a + ", b = " + b);
        int a1 = Integer.parseInt(a); //парсим в int, т.к. в main() аргументы принимаются в String
        int b1 = Integer.parseInt(b); //парсим в int, т.к. в main() аргументы принимаются в String
        return a1 % b1 == 0;
    }

    public static void main(String @NotNull [] args) {
        System.out.println(isDivisible(args[0], args[1]));
    }


}


