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
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        snakePrint(n, col);
    }

    public static void snakePrint(int n, int col) {
        if (n < 1 || col <= 0) {
            System.out.println("Ошибка, попробуйте другие аргументы");
            System.exit(0);
        }

        int rows = n % col == 0 ? n / col : n / col + 1;

        //i - индекс строки, если он чётный, то вывод будет в прямой последовательности (1 2 3), если нечётный - в обратной (6 5 4)
        //j - переменная для перебора всех чисел до n
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = i * col + 1; j <= (i + 1) * col && j <= n; j++) {
                    System.out.print(j + " ");
                }
            } else {
                for (int j = (i + 1) * col; j > i * col && j <= n; j--) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

}
