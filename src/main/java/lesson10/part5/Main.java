package lesson10.part5;

/**
 * Напишите метод "static boolean isInteger(String str)", который получает на вход строку и возвращает true, если строка str состоит только из цифр.
 * <p>
 * С использованием этого метода напишите программу,
 * которая проверяет является ли строка, переданная через аргументы командной строки, целым числом, и выводит результат проверки.
 * <p>
 * Проверку на наличие аргументов делать не надо.
 * Например:
 * 1) Входная строка: "1234567890"
 * Вывод: Строка является целым числом
 * <p>
 * 2) Входная строка: "1,234E567890"
 * Вывод: Строка не является целым числом
 */
public class Main {
    static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = args[0];
        System.out.println("Переданная строка: " + str);
        System.out.println("Вывод: " + (isInteger(str) ? "Строка является целым числом" : "Строка не является целым числом"));
    }
}
