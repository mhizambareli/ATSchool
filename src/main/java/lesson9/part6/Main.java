package lesson9.part6;

/**
 * Напишите программу-таймер обратного отсчета в минутах и секундах, используя созданный класс Timer.
 * Через аргументы командной строки передается число секунд.
 * Проверку на наличие аргумента делать не надо.
 *
 * Пример формата вывода для 61 секунды:
 * 01:01
 * 01:00
 * 00:59
 * ...
 * 00:01
 * 00:00
 */
public class Main {
    public static void main(String[] args) {
        int seconds = Integer.parseInt(args[0]);
        Timer first = new Timer(seconds);
        first.start();
    }
}
