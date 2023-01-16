package lesson6.part2;

public class Main {
    /**
     * Даны две целые переменные a, b. Напишите программу, после исполнения которой значения переменных поменялись бы местами (новое значение a равно старому значению b и наоборот), но без использования дополнительной переменной.
     * Выведите исходные значения и результат. Например:
     * Дано: a = 4, b = 5
     * После перестановки: a = 5, b = 4
     */
    public static void swapWithoutBuffer(int a, int b) {
        System.out.println("Дано: a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("После перестановки: a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        swapWithoutBuffer(4, 5);
    }
}