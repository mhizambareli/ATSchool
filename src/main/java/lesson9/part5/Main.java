package lesson9.part5;

import static lesson9.part5.Calculator.*;

/**
 * Используя класс Calculator, напишите программу, которая будет
 * получать через аргументы командной строки два целых числа,
 * знак операции и после этого выводить результат операции.
 * через аргументы командной строки.
 *
 * Пример ввода аргументов:
 * 10 + 12
 * 10 - 12
 * 10 * 12
 * 10 / 0
 *
 * Проверку на наличие аргументов делать не надо.
 * Для проверки знака операции используйте оператор switch.
 * Если введена неподдерживаемая операция, то выводить список поддерживаемых операций и завершать программу.
 */
public class Main {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        String operator = args[1];
        int y = Integer.parseInt(args[2]);

        System.out.println("Введённый пример: " + x + " " + operator + " " + y);

        switch (operator) {
            case "+":
                System.out.println(add(x, y));
                break;
            case "-":
                System.out.println(sub(x, y));
                break;
            case "*":
                System.out.println(mult(x, y));
                break;
            case "/":
                System.out.println(divide(x, y));
                break;
            default:
                System.out.println("Операция " + operator + " не поддерживается. Список поддерживаемых операций: + - * /");
        }
    }
}
