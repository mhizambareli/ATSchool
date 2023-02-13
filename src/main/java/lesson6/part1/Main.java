package lesson6.part1;

public class Main {
    /**
     * Даны две целые переменные a, b. Напишите программу, после исполнения которой значения переменных поменялись бы местами (новое значение a равно старому значению b и наоборот).
     * Выведите исходные значения и результат. Например:
     * Дано: a = 4, b = 5
     * После перестановки: a = 5, b = 4
     */

    public static void swap(int a, int b) {
        System.out.println("Дано: a = " + a + ", b = " + b);
        int c = a;
        a = b;
        b = c;
        System.out.println("После перестановки: a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        swap(4, 5);
    }

}
