package lesson9.part4;

import java.util.Random;

/**
 * В основном классе программы объявлена и инициализиована целочисленная переменная n.
 * Реализуйте метод boolean isPrime(int x), который возвращает true, если x - простое число.
 * Реализуйте метод int nextInt(int x), который возвращает случайно сгенерированное целое число от 0 до x, x не включая.
 * <p>
 * Используя эти методы, напишите программу, которая генерит целые
 * числа до тех пор, пока не сгенерит простое число.
 * Для генерации простых чисел можно пользоваться классом
 * java.lang.Math или java.util.Random.
 */
public class Main {
    static int n = 15513400; //верхняя граница для генерации чисел

    public static boolean isPrime(int x) {
        if (x == 2) return true;
        if (x <= 2) return false;

        for (int i = 2; i <= (x / 2); i++) {
            if (x % i != 0) continue;
            else return false;
        }
        return true;
    }

    public static int nextInt(int x) {
        Random result = new Random();
        return result.nextInt(x);
    }

    public static void main(String[] args) {
        int number; //переменная, куда будем складывать сгенерированные числа для проверки
        for (number = nextInt(n); !isPrime(number); number = nextInt(n)) {
            System.out.println("Выпало число " + number + ". Оно не простое");
        }
        System.out.println("Выпало простое число " + number);
    }
}
