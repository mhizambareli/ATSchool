package lesson9.part3;

/**
 * Напишите метод snakePrint(int n, int col),
 * который выводит числа "змейкой" от 1 до n:
 * 1 2 3 4
 * 8 7 6 5
 * 9 10 11 12
 * ... n
 * где:
 * n - максимальное число
 * col - количество цифр в одной строке
 * Выводимые числа разделены пробелами.
 *
 * Используя реализованный метод, напишите программу, которая через
 * аргументы командной строки получает целочисленные значения n и col,
 * а затем печатает соответствующего размера змейку.
 *
 * Проверку на наличие аргументов делать не надо.
 * Сделайте проверку, что n больше или равно 1, а col больше 0.
 * В противном случае выведите сообщение об ошибке
 * и завершите программу.
 */
public class Main {
    public static void snakePrint(int n, int col) {
        String result = "";
        if (n >= 1 && col > 0) {
            for (int i = 1; i <= n; i++) {
                if (i % col != 0) {
                    result += i + " ";
                } else {
                    result += i + "\n";
                }
            }
        } else {
            System.out.println("Ошибка, попробуйте другие аргументы");
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        snakePrint(n, col);
    }
}
