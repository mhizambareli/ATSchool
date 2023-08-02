package lesson10.part4;

/**
 * Через аргумент командной строки передается строка.
 * Используя StringBuilder, напишите программу, которая в переданной строке удаляет из неё всё, кроме цифр.
 * Выведите результирующую строку.
 * <p>
 * 1) Пример аргумента: 01a10vt0101c
 * Вывод: 01100101
 * <p>
 * 2) Пример аргумента: avtc
 * Вывод:
 * <p>
 * Проверку на наличие и корректность аргумента делать не надо.
 */
public class Main {
    static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        String str = args[0];
        System.out.println("Переданная строка: " + str);
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray())
            if (isDigit(ch))
                result.append(ch);

        System.out.println("Вывод: " + result);
    }
}
